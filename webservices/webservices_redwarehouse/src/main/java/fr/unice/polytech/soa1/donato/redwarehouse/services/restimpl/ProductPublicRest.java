package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({"application/xml"})
public interface ProductPublicRest {

	@Path("/{ref_product}")
	@GET
	public Response getProductByReference(@PathParam("ref_product")    String productRef);
	
	
}
