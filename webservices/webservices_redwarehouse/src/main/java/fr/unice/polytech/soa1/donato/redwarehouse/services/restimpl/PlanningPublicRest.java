package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces({"application/xml"})
public interface PlanningPublicRest {

	@Path("/")
	@POST
	public Response createPlanning(
			@QueryParam("ref_product") String productRef,
			@QueryParam("quantity")    String quantity,
			@QueryParam("type_event")  String typeEvent);
	
}
