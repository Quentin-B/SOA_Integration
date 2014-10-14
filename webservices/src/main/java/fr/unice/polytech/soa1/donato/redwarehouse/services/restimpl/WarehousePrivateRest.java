package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({"application/xml"})
public interface WarehousePrivateRest {

	@Path("/plannings")
	@GET
	public Response getAllPlanningsForAllWarehouse();
	
	@Path("/{id_warehouse}/plannings")
	@GET
	public Response getPlanningsForWarehouse(@PathParam("id_warehouse")    String warehouseId);
	
	@Path("/{id_warehouse}/plannings/{date}")
	@GET
	public Response getPlanningsForWarehouseByDate(@PathParam("id_warehouse")    String warehouseId,
											@PathParam("date") String date);
	
}
