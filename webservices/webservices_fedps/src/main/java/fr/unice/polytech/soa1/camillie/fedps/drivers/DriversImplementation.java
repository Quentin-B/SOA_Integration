package fr.unice.polytech.soa1.camillie.fedps.drivers;

import fr.unice.polytech.soa1.camillie.fedps.business.DataAccessObject;
import fr.unice.polytech.soa1.camillie.fedps.business.Order;
import fr.unice.polytech.soa1.camillie.fedps.business.ParcelStatus;
import fr.unice.polytech.soa1.camillie.fedps.business.Step;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/private/driver/")
public class DriversImplementation implements DriversInterface{

    // Injection dependency to retrieve the database as a singleton and the resource uri
    @EJB
    private DataAccessObject dao;

    @Override
    public Response getRound() {
        return Response.ok(dao.getRound()).build();
    }

    @Override
    public Response getStep(int a) {
        Optional<Step> s=dao.getRound().getStep(a);
        if(!s.isPresent()) {
            UnknownResource error = new UnknownResource("step", ""+a);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        return Response.ok(s.get()).build();
    }

    @Override
    public Response updateStatus(int step, String parcelId, ParcelStatus status) {
        Optional<Step> s=dao.getRound().getStep(step);
        if(!s.isPresent()) {
            UnknownResource error = new UnknownResource("step", ""+step);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        if(!s.get().getParcelId().equals(parcelId) || status==null){
            UnknownResource error = new UnknownResource("parcel", ""+parcelId);
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
        Optional<Order> order = dao.findOrderByParcelId(parcelId);
        if(!s.isPresent()) {
            UnknownResource error = new UnknownResource("step", ""+step);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        //TODO check status/parcel/round

        order.get().setStatus(status);
        s.get().setStatus(status);
        return Response.ok(s.get()).build();
    }
}
