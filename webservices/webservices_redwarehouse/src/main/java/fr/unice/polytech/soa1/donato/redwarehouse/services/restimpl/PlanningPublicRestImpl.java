package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import java.util.Random;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import fr.unice.polytech.soa1.donato.redwarehouse.business.DataAccessObject;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Event;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Planning;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Product;

@Path("/rest/redwarehouse/public/plannings")
public class PlanningPublicRestImpl implements PlanningPublicRest{

	@EJB private DataAccessObject dao;
	@Context private UriInfo uri;
	
	@Override
	public Response createPlanning(
			@QueryParam("ref_product") String productRef,
			@QueryParam("quantity") String strQuantity,
			@QueryParam("type_event")  String typeEvent) {
		
		if (productRef == null
				|| productRef.length() <= 0) {
			UnknownResource error = new UnknownResource("product ref", productRef);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		int quantity = 0;
		try {
			quantity = Integer.valueOf(strQuantity);
		} catch (NumberFormatException e) {
			
		}
		if (quantity <= 0) {
			UnknownResource error = new UnknownResource("quantity of product ref is 0", productRef);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Product product = dao.findProducByRef(productRef);
		if (product == null) {
			UnknownResource error = new UnknownResource("product ref", productRef);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		Event event = null;
		for(Event tmp : Event.values()) {
			if (tmp.name().equalsIgnoreCase(typeEvent)) {
				event = tmp;
				break;
			}
		}
		
		String planningId = "";
		
		Planning planningExistant = null;
		while (planningId.length() == 0
				|| planningExistant != null) {
			Random rand = new Random();
			for (int i=0; i < 10; i++) {
				int nombreAleatoire = rand.nextInt(10);
				planningId += String.valueOf(nombreAleatoire);
			}
			planningExistant = dao.findPlanningById(planningId);
		}
		
		
		Planning planning = new Planning();
		planning.id=planningId;//"9008727099"
		planning.product = product;
		planning.quantity = quantity;
		planning.status = event;
		
		return Response.status(Response.Status.CREATED).build();
	}
}
