package fr.unice.polytech.soa1.teamforce.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Quentin Bitschené on 08/10/2014.
 */
@Produces({"application/json"})
public interface EmployeeRest {

    @Path("information/{idCustomer}")
    @GET
    public Response getInformation(@PathParam("idCustomer") String idCustomer);
}
