package fr.unice.polytech.soa1.teamforce.rest;

import fr.unice.polytech.soa1.teamforce.business.Catalogue;
import fr.unice.polytech.soa1.teamforce.business.DataAccessObject;
import fr.unice.polytech.soa1.teamforce.business.Item;
import fr.unice.polytech.soa1.teamforce.business.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by Quentin Bitschené on 08/10/2014.
 */
@Path("/rest/manager")
public class ManagerRestImpl implements ManagerRest {

    @EJB
    private DataAccessObject dao;  // Injection dependency to retrieve the database as a singleton

    @Override
    public Response createCatalogue(String name, String startDate, String endDate) {

        Catalogue catalogue = new Catalogue(name,startDate,endDate);
        dao.getCatalogues().add(catalogue);

        return Response.ok().entity(catalogue.toJSON().toString()).build();
    }

    @Override
    public Response addProduct(String idCatalogue, JSONArray products) {
        Optional<Catalogue> catalogue = dao.findCatalogueById(idCatalogue);
        if (!catalogue.isPresent())  {
            UnknownResource error = new UnknownResource("catalogue", idCatalogue);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        for(int i=0; i< products.length();i++){
            JSONObject itemJSObject = products.getJSONObject(i);

            String idProduct = itemJSObject.getString("idProduct");
            Optional<Product> product = dao.findProductById(idProduct);

            if (!product.isPresent())  {
                UnknownResource error = new UnknownResource("product", idProduct);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }

            catalogue.get().addProduct(product.get());
        }

        return Response.ok().entity(catalogue.get().toJSON().toString()).build();
    }

    @Override
    public Response showCatalogue(String idCatalogue) {
        Optional<Catalogue> catalogue = dao.findCatalogueById(idCatalogue);
        if (!catalogue.isPresent()) {
            UnknownResource error = new UnknownResource("catalogue", idCatalogue);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        return Response.ok().entity(catalogue.get().toJSON().toString()).build();
    }

}
