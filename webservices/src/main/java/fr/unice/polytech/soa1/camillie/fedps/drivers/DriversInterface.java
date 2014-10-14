package fr.unice.polytech.soa1.camillie.fedps.drivers;

import fr.unice.polytech.soa1.camillie.fedps.business.ParcelStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Produces({"application/xml"})
public interface DriversInterface {

    @Path("/round")
    @GET
    public Response getRound();

    @Path("/round/{step}")
    @GET
    public Response getStep(@PathParam("step") int a);

    @Path("/round/{step}")
    @PUT
    public Response updateStatus(@PathParam("step") int a, @QueryParam("parcelId") String b, @QueryParam("status") ParcelStatus c);
}

@XmlRootElement(name = "unknown_resource")
class UnknownResource {
    private String type;
    private String key;

    public UnknownResource() {
    }

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
