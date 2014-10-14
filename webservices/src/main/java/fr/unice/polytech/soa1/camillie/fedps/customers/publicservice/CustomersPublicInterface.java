package fr.unice.polytech.soa1.camillie.fedps.customers.publicservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Produces({"application/xml"})
public interface CustomersPublicInterface {
    @Path("/parcel/{id}")
    @GET
    public Response getStatus(@PathParam("id")String a);
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