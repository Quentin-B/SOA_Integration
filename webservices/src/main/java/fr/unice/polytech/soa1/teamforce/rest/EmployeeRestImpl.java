package fr.unice.polytech.soa1.teamforce.rest;

import fr.unice.polytech.soa1.teamforce.business.DataAccessObject;
import fr.unice.polytech.soa1.teamforce.business.User;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by Quentin Bitschené on 08/10/2014.
 */
@Path("/rest/employee")
public class EmployeeRestImpl implements EmployeeRest {

    @EJB
    private DataAccessObject dao;  // Injection dependency to retrieve the database as a singleton

    @Override
    public Response getInformation(String idCustomer) {
        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }


        return Response.ok().entity(customer.get().getInformationsToJSON().toString()).build();
    }
}
