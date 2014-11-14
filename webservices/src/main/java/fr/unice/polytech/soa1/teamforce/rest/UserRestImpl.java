package fr.unice.polytech.soa1.teamforce.rest;

import fr.unice.polytech.soa1.teamforce.business.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Quentin Bitschené on 07/10/2014.
 */
@Path("/rest/user")
public class UserRestImpl implements UserRest{

    @EJB
    private DataAccessObject dao;  // Injection dependency to retrieve the database as a singleton

    @Override
    public Response createOrder(String idCustomer, JSONObject addresses) {

        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        JSONObject addressInvoiceJSON = addresses.getJSONObject("invoice");
        JSONObject addressDeliveryJSON = addresses.getJSONObject("delivery");

        String line2Invoice="";
        if (addressInvoiceJSON.has("line2") && !addressInvoiceJSON.isNull("line2")) {
            // Do something with object.
            line2Invoice = addressInvoiceJSON.getString("line2");
        }

        Address invoiceAddress = new Address(addressInvoiceJSON.getString("line1"), line2Invoice,
                addressInvoiceJSON.getString("zipCode"), addressInvoiceJSON.getString("city"), Kind.valueOf(addressInvoiceJSON.getString("kind")));

        String line2Delivery="";
        if (addressDeliveryJSON.has("line2") && !addressDeliveryJSON.isNull("line2")) {
            // Do something with object.
            line2Delivery = addressDeliveryJSON.getString("line2");
        }

        Address deliveryAddress = new Address(addressDeliveryJSON.getString("line1"), line2Delivery,
                addressDeliveryJSON.getString("zipCode"), addressDeliveryJSON.getString("city"), Kind.valueOf(addressDeliveryJSON.getString("kind")));

        
        Order order = new Order(deliveryAddress,invoiceAddress,idCustomer);

        dao.getOrders().add(order);

        return Response.ok().entity(order.toJSON().toString()).build();
    }

    @Override
    public Response addItems(String idCustomer,String idOrder, JSONArray items) {
        Optional<Order> order = dao.findOrderById(idOrder);
        if (!order.isPresent())  {
            UnknownResource error = new UnknownResource("order", idOrder);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        for(int i=0; i< items.length();i++){
            JSONObject itemJSObject = items.getJSONObject(i);

            String idProduct = itemJSObject.getString("idProduct");
            Optional<Product> product = dao.findProductById(idProduct);

            if (!product.isPresent())  {
                UnknownResource error = new UnknownResource("product", idProduct);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }

            int quantity = itemJSObject.getInt("quantity");
            Item item = new Item(product.get() ,quantity);
            order.get().addItem(item);
        }

        return Response.ok().entity(order.get().toJSON().toString()).build();
    }

    @Override
    public Response getOrders(String idCustomer) {
        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        List<Order> listOrders = dao.findOrdersByCostumerId(idCustomer);
        JSONArray jsonArray = new JSONArray();
        for(Order o : listOrders)
        {
            jsonArray.put(o.toJSON());
        }

        return Response.ok().entity(jsonArray.toString()).build();
    }

    @Override
    public Response getOrderById(String idCustomer, String idOrder) {
        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        Optional<Order> order = dao.findOrderById(idOrder);
        if (!order.isPresent())  {
            UnknownResource error = new UnknownResource("order", idOrder);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        return Response.ok().entity(order.get().toJSON().toString()).build();

    }

    @Override
    public Response getSuggestion(String idCustomer) {
        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        return Response.ok().entity(dao.getProducts().get(1).toJSON().toString()).build();
    }

    @Override
    public Response validate(String idCustomer, String idOrder, String state) {
        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        Optional<Order> order = dao.findOrderById(idOrder);
        if (!order.isPresent())  {
            UnknownResource error = new UnknownResource("order", idOrder);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        order.get().setState(State.valueOf(state));

        return Response.ok().entity(order.get().toJSON().toString()).build();
    }

    @Override
    public Response removeItems(String idCustomer, String idOrder, JSONArray items) {
        Optional<User> customer = dao.findUserById(idCustomer);
        if (!customer.isPresent())  {
            UnknownResource error = new UnknownResource("customer", idCustomer);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        Optional<Order> order = dao.findOrderById(idOrder);
        if (!order.isPresent())  {
            UnknownResource error = new UnknownResource("order", idOrder);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        for(int i=0; i< items.length();i++){
            JSONObject itemJSObject = items.getJSONObject(i);

            String idProduct = itemJSObject.getString("idProduct");
            Optional<Product> product = dao.findProductById(idProduct);

            if (!product.isPresent())  {
                UnknownResource error = new UnknownResource("product", idProduct);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }

            int quantity = itemJSObject.getInt("quantity");
            Item item = new Item(product.get() ,quantity);
            order.get().getItems().remove(item);
        }

        return Response.ok().entity(order.get().toJSON().toString()).build();
    }
}
