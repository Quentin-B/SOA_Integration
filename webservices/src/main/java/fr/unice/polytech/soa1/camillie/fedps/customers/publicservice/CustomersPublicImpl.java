package fr.unice.polytech.soa1.camillie.fedps.customers.publicservice;

import fr.unice.polytech.soa1.camillie.fedps.business.DataAccessObject;
import fr.unice.polytech.soa1.camillie.fedps.business.Order;
import fr.unice.polytech.soa1.camillie.fedps.business.ParcelStatus;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/public/customer/")
public class CustomersPublicImpl implements CustomersPublicInterface {

    // Injection dependency to retrieve the database as a singleton and the resource uri
    @EJB
    private DataAccessObject dao;

    @Override
    public Response getStatus(String a) {
        Optional<Order> c = dao.findOrderByParcelId(a);
        if (!c.isPresent()) {
            UnknownResource error = new UnknownResource("order ", "" + a);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        if (c.get().getStatus() == ParcelStatus.DELIVERED)
            return Response.ok(new StatusResponse(c.get().getParcelId(), c.get().getStatus())).build();
        else
            return Response.ok(new StatusResponse(c.get().getParcelId(), c.get().getStatus(), c.get().getETA())).build();
    }
}
