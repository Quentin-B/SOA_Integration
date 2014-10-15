package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces({"application/json"})
public interface PlanningPublicRest {

	@Path("/{planning_id}")
	@GET
	public Response getPlanning(
			@PathParam("planning_id") String planningId);
	
	@Path("/")
	@POST
	public Response createPlanning(
			@QueryParam("planning") String planningConstruct);
	
}
