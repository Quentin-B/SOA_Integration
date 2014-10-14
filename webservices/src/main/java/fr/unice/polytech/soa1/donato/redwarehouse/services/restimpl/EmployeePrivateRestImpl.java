package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import fr.unice.polytech.soa1.donato.redwarehouse.business.DataAccessObject;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Employee;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Planning;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Product;

@Path("/rest/redwarehouse/private/employees")
public class EmployeePrivateRestImpl implements EmployeePrivateRest {

	@EJB private DataAccessObject dao;
	@Context private UriInfo uri;
	
	@Override
	public Response getEmployee(String employeeId) {
		
		if (employeeId == null
				|| employeeId.length() <= 0) {
			UnknownResource error = new UnknownResource("employee id", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Employee employee = dao.getEmployeeById(employeeId);
		if (employee == null) {
			UnknownResource error = new UnknownResource("employee", employeeId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		EmployeeViewForEmployeeRest tmp = new EmployeeViewForEmployeeRest();
		tmp.setEmployeeData(employee);
		if (employee.plannings != null && employee.plannings.size() > 0) {
			for (Planning planning : employee.plannings) {
				tmp.plannings.getPlannings().add(uri.getAbsolutePath().toString() + "/plannings/" + planning.id);
			}
		}
		
		return Response.ok(tmp).build();
	}
	
	@Override
	public Response getPlanningByEmployee(String employeeId, String planningId) {
		if (employeeId == null
				|| employeeId.length() <= 0) {
			UnknownResource error = new UnknownResource("employee id", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Employee employee = dao.getEmployeeById(employeeId);
		if (employee == null) {
			UnknownResource error = new UnknownResource("employee", employeeId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		Planning planning = null;
		for (Planning planningTmp : employee.plannings) {
			if (planningTmp.id.equalsIgnoreCase(planningId)) {
				planning = planningTmp;
				break;
			}
		}
		if (planning == null) {
			UnknownResource error = new UnknownResource("planning", planningId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		PlanningsForEmployee tmp = new PlanningsForEmployee();
		tmp.setPlanning(planning);
		
		return Response.ok(tmp).build();
	}

	@Override
	public Response setPlanningsToEmployee(String employeeId, String planningIds) {
		
		if (employeeId == null
				|| employeeId.length() <= 0) {
			UnknownResource error = new UnknownResource("employee id", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		if (planningIds == null
				|| planningIds.length() <= 0) {
			UnknownResource error = new UnknownResource("No planning for employee ", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Employee employee = dao.getEmployeeById(employeeId);
		if (employee == null) {
			UnknownResource error = new UnknownResource("employee", employeeId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		for (String planningId : planningIds.split(";")) {
			Planning planning = dao.findPlanningById(planningId);
			if (planning != null) {
				planning.getEmployees().add(employee);
				employee.plannings.add(planning);
			}
		}
		
		return Response.status(Response.Status.OK).build();
	}
	
	@Override
	public Response getPlanningsByEmployee(String employeeId) {
		
		if (employeeId == null
				|| employeeId.length() <= 0) {
			UnknownResource error = new UnknownResource("employee id", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Employee employee = dao.getEmployeeById(employeeId);
		if (employee == null) {
			UnknownResource error = new UnknownResource("employee", employeeId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		EmployeeViewForEmployeeRest2 tmp = new EmployeeViewForEmployeeRest2();
		if (employee.plannings != null && employee.plannings.size() > 0) {
			for (Planning planning : employee.plannings) {
				PlanningsForEmployee planningList = new PlanningsForEmployee();
				
				if (planning.product != null) {
					ProductForRestEmployee productResult = new ProductForRestEmployee();
					productResult.setProduct(planning.product);
					planningList.products.getProducts().add(productResult);
				}
				
				tmp.plannings.getPlannings().add(planningList);
			}
		}
		
		return Response.ok(tmp).build();
	}
	
	@Override
	public Response registerPlanning(String employeeId, String planningId) {
		if (employeeId == null
				|| employeeId.length() <= 0) {
			UnknownResource error = new UnknownResource("employee id", employeeId);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Employee employee = dao.getEmployeeById(employeeId);
		if (employee == null) {
			UnknownResource error = new UnknownResource("employee", employeeId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		Planning planning = null;
		for (Planning planningTmp : employee.plannings) {
			if (planningTmp.id.equalsIgnoreCase(planningId)) {
				planning = planningTmp;
				break;
			}
		}
		if (planning == null) {
			UnknownResource error = new UnknownResource("planning", planningId);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		
		Product existingProductInWarehouse = dao.findProducByRef(planning.product.reference);		
		if (existingProductInWarehouse == null) {
			dao.getProducts().add(planning.product);
		} else {
			existingProductInWarehouse.quantity += planning.product.quantity;
		}
		
		return Response.status(Response.Status.CREATED).build();
	}
}

@XmlRootElement(name = "employee")
class EmployeeViewForEmployeeRest {
	public String id;
	public String firstname;
	public String lastname;
	public boolean teamLeader;
	
	private Employee employee;
	public ListOfPlanningsForEmployee plannings = new ListOfPlanningsForEmployee();
	
	/*EmployeeViewForEmployeeRest (Employee employee) {
		this.id = employee.id;
		this.firstname = employee.firstname;
		this.lastname = employee.lastname;
		this.teamLeader = employee.teamLeader;
		this.employee = employee;
	}*/
	
	void setEmployeeData (Employee employee) {
		this.id = employee.id;
		this.firstname = employee.firstname;
		this.lastname = employee.lastname;
		this.teamLeader = employee.teamLeader;
		this.employee = employee;
	}
}

@XmlRootElement(name = "plannings")
class ListOfPlanningsForEmployee {
	private List<String> plannings = new ArrayList<String>();
	@XmlElement(name = "planning")
	public List<String> getPlannings() { return plannings; }
	public void setPlannings(List<String> plannings) { this.plannings = plannings; }
}

@XmlRootElement(name = "employee")
class EmployeeViewForEmployeeRest2 {
	public String id;
	public String firstname;
	public String lastname;
	public boolean teamLeader;
	
	private Employee employee;
	public ListOfPlanningsForEmployee2 plannings = new ListOfPlanningsForEmployee2();
	
	/*EmployeeViewForEmployeeRest (Employee employee) {
		this.id = employee.id;
		this.firstname = employee.firstname;
		this.lastname = employee.lastname;
		this.teamLeader = employee.teamLeader;
		this.employee = employee;
	}*/
	
	void setEmployeeData (Employee employee) {
		this.id = employee.id;
		this.firstname = employee.firstname;
		this.lastname = employee.lastname;
		this.teamLeader = employee.teamLeader;
		this.employee = employee;
	}
}

@XmlRootElement(name = "plannings")
class ListOfPlanningsForEmployee2 {
	private List<PlanningsForEmployee> plannings = new ArrayList<PlanningsForEmployee>();
	@XmlElement(name = "planning")
	public List<PlanningsForEmployee> getPlannings() { return plannings; }
	public void setPlannings(List<PlanningsForEmployee> plannings) { this.plannings = plannings; }
}

@XmlRootElement(name = "planning")
class PlanningsForEmployee {

	private Planning planning;
	void setPlanning(Planning planning) {
		this.planning = planning;
		
		if (this.planning.product != null) {
			ProductForRestEmployee product = new ProductForRestEmployee();
			product.setProduct(this.planning.product);
			products.getProducts().add(product);
		}
	}
	public ListOfProductsForEmployee products = new ListOfProductsForEmployee();
	
	@XmlID
	public String getId() {return this.planning.id;}
	@XmlElement(name = "status")
	public String getStatus() {return this.planning.status.getName();}
}

@XmlRootElement(name = "products")
class ListOfProductsForEmployee {
	private List<ProductForRestEmployee> products = new ArrayList<ProductForRestEmployee>();
	@XmlElement(name = "product")
	public List<ProductForRestEmployee> getProducts() { return products; }
	public void setPlannings(List<ProductForRestEmployee> products) { this.products = products; }
}

class ProductForRestEmployee {
	private Product product;
	void setProduct(Product product) {this.product = product;}
	
	@XmlID
	public String getId (){return this.product.reference;}
	@XmlElement(name="quantity")
	public int getQuantity() {return this.product.quantity;}
	@XmlElement(name="width")
	public int getWidth() {return this.product.width;}
	@XmlElement(name="height")
	public int getHeight() {return this.product.height;}
	@XmlElement(name="depth")
	public int getDepth() {return this.product.depth;}
	@XmlElement (name = "floor")
	public int getFloor() { return product.box.floor;}
	@XmlElement (name = "corridor")
	public String getCorridor() { return product.box.corridor;}
	@XmlElement (name = "rackNumber")
	public String getRackNumber() { return product.box.rackNumber;}
}