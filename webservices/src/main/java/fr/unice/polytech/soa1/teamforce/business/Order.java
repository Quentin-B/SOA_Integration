package fr.unice.polytech.soa1.teamforce.business;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
public class Order {
    private String id;
    private List<Item> items;
    private Address deliveryAddress;
    private Address invoiceAddress;
    private State state;
    private String customerId;
    private String creationDate;

    public Order(String id, List<Item> items, Address deliveryAddress, Address invoiceAddress, State state, String customerId) {
        this.id = id;
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.invoiceAddress = invoiceAddress;
        this.state = state;
        this.customerId = customerId;
        this.creationDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
    }

    public Order(String id, List<String> deliveryAddress, List<String> invoiceAddress, String customerId) {
        this.id = id;
        items = new ArrayList<Item>();
        this.deliveryAddress = new Address(deliveryAddress.get(0),deliveryAddress.get(1),deliveryAddress.get(2),deliveryAddress.get(3),Kind.valueOf(deliveryAddress.get(4)));
        this.invoiceAddress = new Address(invoiceAddress.get(0),invoiceAddress.get(1),invoiceAddress.get(2),invoiceAddress.get(3),Kind.valueOf(invoiceAddress.get(4)));;
        this.customerId = customerId;
        state = State.PENDING;
        this.creationDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
    }

    public Order(String id,Address deliveryAddress, Address invoiceAddress, String customerId) {
        this.id = id;
        items = new ArrayList<Item>();
        this.deliveryAddress = deliveryAddress;
        this.invoiceAddress = invoiceAddress;
        this.customerId = customerId;
        state = State.PENDING;
        this.creationDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
    }

    public Order(Address deliveryAddress, Address invoiceAddress, String customerId) {
        this.id = UUID.randomUUID().toString();
        items = new ArrayList<Item>();
        this.deliveryAddress = deliveryAddress;
        this.invoiceAddress = invoiceAddress;
        this.customerId = customerId;
        state = State.PENDING;
        this.creationDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public double getAmount() {
        double total = 0;
        for (Item i : items)
           total+=i.getAmount();

        return total;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item i){ items.add(i);  }

    public void addItem(Product p,int quantity){
       Item i = new Item(p,quantity);
        items.add(i);
    }

    public JSONObject toJSON()
    {
        JSONObject jso = new JSONObject();
        jso.put("id",id);
        jso.put("items",items);
        jso.put("deliveryAddress",deliveryAddress.toJSON());
        jso.put("invoiceAddress",invoiceAddress.toJSON());
        jso.put("amount",getAmount());
        jso.put("state",state);
        jso.put("customerId",customerId);
        jso.put("creationDate",creationDate);
        return jso;
    }
}
