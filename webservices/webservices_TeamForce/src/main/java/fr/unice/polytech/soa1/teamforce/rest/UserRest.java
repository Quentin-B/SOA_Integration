package fr.unice.polytech.soa1.teamforce.rest;

import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
@Produces({"application/json"})
public interface UserRest {

    @Path("{idCustomer}/order")
    @POST
    public Response createOrder(@PathParam("idCustomer") String idCustomer,
                                @QueryParam("addresses") JSONArray addresses);

    @Path("{idCustomer}/order/{idOrder}")
    @PUT
    public Response addItems(@PathParam("idCustomer") String idCustomer,
            @PathParam("idOrder") String idOrder,
            @QueryParam("items") JSONArray items);

    @Path("/{idCustomer}/orders")
    @GET
    public Response getOrders(@PathParam("idCustomer") String idCustomer);

    @Path("/{idCustomer}/orders/{idOrder}")
    @GET
    public Response getOrderById(@PathParam("idCustomer") String idCustomer,
                         @PathParam("idOrder") String idOrder);

    @Path("/{idCustomer}/suggestion")
    @GET
    public Response getSuggestion(@PathParam("idCustomer") String idCustomer);

    @Path("/{idCustomer}/order/{idOrder}")
    @POST
    public Response validate(@PathParam("idCustomer") String idCustomer,
                             @PathParam("idOrder") String idOrder,
                             @QueryParam("state") String state);

    @Path("/{idCustomer}/order/{idOrder}")
    @DELETE
    public Response removeItems(@PathParam("idCustomer") String idCustomer,
                             @PathParam("idOrder") String idOrder,
                             @QueryParam("items") JSONArray items);

}

@XmlRootElement(name = "unknown_resource")
class UnknownResource {
    private String type;
    private String key;

    public UnknownResource() {}

    public UnknownResource(String type, String key) {
        this.type = type;
        this.key = key;
    }

    @XmlElement(name = "kind")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
