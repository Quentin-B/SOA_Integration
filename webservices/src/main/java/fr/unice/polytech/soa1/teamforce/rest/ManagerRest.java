package fr.unice.polytech.soa1.teamforce.rest;


import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Quentin Bitschené on 08/10/2014.
 */
@Produces({"application/json"})
public interface ManagerRest {

    @Path("catalogues")
    @POST
    public Response createCatalogue(@QueryParam("name") String name,
                                    @QueryParam("startDate") String startDate,
                                    @QueryParam("endDate") String endDate);

    @Path("catalogue/{idCatalogue}")
    @PUT
    public Response addProduct(@PathParam("idCatalogue") String idCatalogue,
                               @QueryParam("product") JSONArray products);

    @Path("catalogue/{idCatalogue}")
    @GET
    public Response showCatalogue(@PathParam("idCatalogue") String idCatalogue);
}
