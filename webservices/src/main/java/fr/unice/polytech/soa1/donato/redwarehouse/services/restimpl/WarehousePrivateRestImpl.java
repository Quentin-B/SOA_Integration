package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import fr.unice.polytech.soa1.donato.redwarehouse.business.DataAccessObject;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Employee;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Event;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Planning;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Warehouse;

@Path("/rest/redwarehouse/private/warehouses/")
public class WarehousePrivateRestImpl implements WarehousePrivateRest {

	@EJB private DataAccessObject dao;
	@Context private UriInfo uri;
	
	@Override
	public Response getAllPlanningsForAllWarehouse() {
		
		ListOfWarehouses list = new ListOfWarehouses();
		for (Warehouse warehouse : dao.getWarehouses()) {
			WarehouseView view = new WarehouseView();
			view.setWarehouse(warehouse);
			for (Planning planning : warehouse.plannings) {
				view.getPlannings().add(uri.getAbsolutePath().toString() + "/" + warehouse.id + "/plannings/" + planning.id);
			}
			list.getWarehouses().add(view);
		}
		
		return Response.ok(list).build();
	}
	
	@Override
	public Response getPlanningsForWarehouse(String warehouseId) {
		Warehouse warehouse = dao.findWarehouseById(warehouseId);
		if (warehouse == null) {
			UnknownResource error = new UnknownResource("Warehouse", "The Warehouse with id (" + warehouseId + ") does not exist in the system");
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		ListOfPlannings list = new ListOfPlannings();
		
		Set<Planning> plannings = warehouse.plannings;
		for (Planning planning : plannings) {		
			list.getPlannings().add(new PlanningView(planning));
		}
		
		return Response.ok(list).build();
	}
	
	@Override
	public Response getPlanningsForWarehouseByDate(String warehouseId, String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
		} catch (Exception e) {
			UnknownResource error = new UnknownResource("date", dateStr);
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(error).build();
		}
		
		Warehouse warehouse = dao.findWarehouseById(warehouseId);
		if (warehouse == null) {
			UnknownResource error = new UnknownResource("Warehouse", "The Warehouse with id (" + warehouseId + ") does not exist in the system");
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		ListOfPlannings list = new ListOfPlannings();
		
		Set<Planning> plannings = warehouse.plannings;
		for (Planning planning : plannings) {		
			list.getPlannings().add(new PlanningView(planning));
		}
		
		return Response.ok(list).build();
	}

}

@XmlRootElement(name = "plannings")
class ListOfPlannings {
	private List<PlanningView> plannings = new ArrayList<PlanningView>();
	@XmlElement(name = "planning")
	public List<PlanningView> getPlannings() { return plannings; }
	public void setPlannings(List<PlanningView> plannings) { this.plannings = plannings; }
}

class PlanningView {
	@XmlID
	public String id;
	private Date date;
	public Event status;
	
	@XmlElement(name = "employee")
	public List<EmployeeView> employees = new ArrayList<EmployeeView>();
	
	PlanningView(Planning planning) {
		this.id = planning.id;
		this.date = planning.getDate();
		this.status = planning.status;
		for (Employee employee : planning.getEmployees()) {
			this.employees.add(new EmployeeView(employee));
		}
	}
	
	@XmlElement(name="date")
	public String getDate() { return date.getHours() + ":" + date.getMinutes();	}
}

class EmployeeView {
	
	private String id;
	private String firstname;
	private String lastname;
	private boolean teamLeader;
	
	EmployeeView (Employee employee) {
		this.id = employee.id;
		this.firstname = employee.firstname;
		this.lastname = employee.lastname;
		this.teamLeader = employee.teamLeader;
	}
	
	@XmlID
	public String getRestURL() {
		return "/rest/redwarehouse/private" + "/employees/" + this.id;
	}
}

@XmlRootElement(name = "warehouses")
class ListOfWarehouses {
	private List<WarehouseView> warehouses = new ArrayList<WarehouseView>();
	@XmlElement(name = "warehouse")
	public List<WarehouseView> getWarehouses() { return warehouses; }
	public void setWarehouses(List<WarehouseView> plannings) { this.warehouses = plannings; }
}

class WarehouseView {
	private Warehouse warehouse;
	private List<String> plannings = new ArrayList<String>();
	
	void setWarehouse(Warehouse warehouse) { this.warehouse = warehouse; }
	
	@XmlID
	public String getId() { return this.warehouse.id;}
	
	@XmlElement (name="name")
	public String getName() { return this.warehouse.name;}
	
	@XmlElement (name="address")
	public String getAddress() { return this.warehouse.address;}
	
	@XmlElement (name="zipcode")
	public String getZipCode() { return this.warehouse.zip;}
	
	@XmlElement (name="city")
	public String getCity() { return this.warehouse.city;}
	
	@XmlElementWrapper(name="plannings")
	@XmlElement(name = "planning")
	public List<String> getPlannings() { return this.plannings;	}
}