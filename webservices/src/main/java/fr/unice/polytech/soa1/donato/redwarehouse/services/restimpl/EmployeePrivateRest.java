package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces({"application/xml"})
public interface EmployeePrivateRest {

	@Path("/{id_employee}")
	@GET
	public Response getEmployee(@PathParam("id_employee")    String employeeId);
	
	@Path("/{id_employee}/plannings/{id_planning}")
	@GET
	public Response getPlanningByEmployee(@PathParam("id_employee")    String employeeId,
											@PathParam("id_planning") String planningId);
	
	@Path("/{id_employee}/plannings/assign")
	@PUT
	public Response setPlanningsToEmployee(@PathParam("id_employee")    String employeeId,
											@QueryParam("planningIds") String planningIds);
	
	@Path("/{id_employee}/plannings/affected")
	@GET
	public Response getPlanningsByEmployee(@PathParam("id_employee")    String employeeId);
	
	@Path("/{id_employee}/plannings/{id_planning}/register")
	@POST
	public Response registerPlanning(@PathParam("id_employee")    String employeeId,
										@PathParam("id_planning") String planningId);
}
