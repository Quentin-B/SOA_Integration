package fr.unice.polytech.soa1.camillie.fedps.business;

import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.CustomerJobResult;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlSeeAlso({Order.class, Quote.class})
public abstract class Command extends CustomerJobResult{

    protected String id;
    protected String customerId;
    protected String receiverName;
    protected Address from;
    protected Address to;
    protected Long pickUpDate;
    protected Box box;
    protected Double price;
    protected Long ETA;

    public Command() {
    }

    public Command(String id, String customerId, String receiverName, Address from, Address to, long pickUpDate,
                   float width, float height, float depth, float weight) {
        this.id = id;
        this.customerId = customerId;
        this.receiverName = receiverName;
        this.from = from;
        this.to = to;
        this.pickUpDate = pickUpDate;
        this.box = new Box(width, height, depth, weight);
    }

    public Command(String id, String customerId, String receiverName, Address from, Address to, long pickUpDate,
                   Box box) {
        this.id = id;
        this.customerId = customerId;
        this.receiverName = receiverName;
        this.from = from;
        this.to = to;
        this.pickUpDate = pickUpDate;
        this.box = box;
    }

    @XmlAttribute(name = "id")
    @XmlID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "customerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customer) {
        this.customerId = customer;
    }

    @XmlElement(name = "receiverName")
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @XmlElement(name = "fromAddress")
    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    @XmlElement(name = "toAddress")
    public Address getTo() {
        return to;
    }

    public void setTo(Address to) {
        this.to = to;
    }

    @XmlElement(name = "pickupDate")
    public Long getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(long pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    @XmlElement(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlElement(name = "ETA")
    public long getETA() {
        return ETA;
    }

    public void setETA(long ETA) {
        this.ETA = ETA;
    }

    @XmlElement(name = "box")
    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

}
