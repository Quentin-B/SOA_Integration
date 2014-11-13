package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.unice.polytech.soa1.donato.redwarehouse.business.Command;
import fr.unice.polytech.soa1.donato.redwarehouse.business.DataAccessObject;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Event;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Planning;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Product;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Warehouse;

@Path("/rest/redwarehouse/public/plannings")
public class PlanningPublicRestImpl implements PlanningPublicRest {

	@EJB
	private DataAccessObject dao;
	@Context
	private UriInfo uri;
	
	@Override
	public Response getPlanning(String planningId) {
		return Response.status(Response.Status.SERVICE_UNAVAILABLE)
				.entity("Not implemented").build();
	}

	/**
	 * { 'typeEvent': ['delivery' | 'pickup'], 'dateEvent': 'ddMMyyyy',
	 * 'command': [{ 'ref_product': '#ref', 'quantity': 15 }, { 'ref_product':
	 * '#ref', 'quantity': 15 }] }
	 */
	@Override
	public Response createPlanning(String planningConstruct) {

		PlanningResponse response = new PlanningResponse();

		JSONObject json = new JSONObject(planningConstruct);

		Planning planning = new Planning();

		String statusType = json.getString("typeEvent");
		for (Event event : Event.values()) {
			if (event.getName().toUpperCase()
					.contains(statusType.toUpperCase())) {
				planning.status = event;
				break;
			}
		}
		try {
			planning.setDate(new SimpleDateFormat("ddMMyyyy").parse(json
					.getString("dateEvent")));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Command> commands = new ArrayList<Command>();
		planning.commands = commands;

		JSONArray commandsJSON = json.getJSONArray("command");
		for (int idx = 0; idx < commandsJSON.length(); idx++) {
			JSONObject commandJSON = commandsJSON.getJSONObject(idx);
			String refProduct = commandJSON.getString("ref_product");
			int quantity = commandJSON.getInt("quantity");

			Product product = dao.findProducByRef(refProduct);
			if (product == null) {
				continue;
			}

			Command command = new Command(product, quantity);
			commands.add(command);
		}

		String planningId = "";

		Planning planningExistant = null;
		while (planningId.length() == 0 || planningExistant != null) {
			Random rand = new Random();
			for (int i = 0; i < 10; i++) {
				int nombreAleatoire = rand.nextInt(10);
				planningId += String.valueOf(nombreAleatoire);
			}
			planningExistant = dao.findPlanningById(planningId);
		}
		planning.id = planningId;// "9008727099"

		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(100);
		planning.warehouse = dao.getWarehouses().get(nombreAleatoire);
		
		response.setPlanning(planning);
		response.setUrlPlanning(uri.getAbsolutePath().toString() + "/" + planning.id);

		return Response.status(Response.Status.CREATED)
				.entity(response.toJSONString()).build();
	}
}

class PlanningResponse {

	private String urlPlanning;
	private Planning planning;
	private List<String> errorMessage = new ArrayList<String>();

	public Planning getPlanning() {
		return this.planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public String getUrlPlanning() {
		return urlPlanning;
	}

	public void setUrlPlanning(String urlPlanning) {
		this.urlPlanning = urlPlanning;
	}

	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String toJSONString() {
		JSONObject result = new JSONObject();

		result.put("planningID", this.planning.getId());
		result.put("planningUrl", this.urlPlanning);
		result.put("pickupdate", new SimpleDateFormat("ddMMyyyy").format(new Date()));

		JSONObject packageSize = new JSONObject();
		int width = 0, height = 0, depth = 0, weight = 0;
		for (Command command : this.planning.commands) {
			Product product = command.getProduct();
			width += product.width;
			height += product.height;
			depth += product.depth;
			weight += product.weight;
		}
		packageSize.put("width", width);
		packageSize.put("height", height);
		packageSize.put("depth", depth);
		packageSize.put("weight", weight);
		result.put("packagesize", packageSize);
		
		Warehouse warehouse = this.planning.warehouse;
		if (warehouse != null) {
			JSONObject warehouseJson = new JSONObject();
			warehouseJson.put("warehouseID", warehouse.id);
			warehouseJson.put("address", warehouse.address);
			warehouseJson.put("zipcode", warehouse.zip);
			warehouseJson.put("city", warehouse.city);
			result.put("warehouse", warehouseJson);
		}

		if (this.errorMessage != null && this.errorMessage.size() > 0) {
			result.put("errors", this.errorMessage);
		}

		return result.toString();
	}
}
