package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.input;

import fr.unice.polytech.soa1.camillie.fedps.business.Address;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "customer_query")
public class CustomerQuery {

    public CustomerQuery() {}

    private CustomerJobKind job;

    // Create quote/order
    private float parcelWidth;
    private float parcelHeight;
    private float parcelDepth;
    private float parcelWeight;
    private long pickupTimestamp;
    private Address from;
    private Address to;
    private String receiver;

    // Confirm order
    private String id;

    @XmlAttribute(name = "kind", required = true)
    public CustomerJobKind getJob() { return job; }
    public void setJob(CustomerJobKind job) { this.job = job; }

    @XmlElement(name="parcelWidth")
    public float getParcelWidth() {
        return parcelWidth;
    }
    public void setParcelWidth(float parcelWidth) {
        this.parcelWidth = parcelWidth;
    }

    @XmlElement(name="parcelHeight")
    public float getParcelHeight() {
        return parcelHeight;
    }
    public void setParcelHeight(float parcelHeight) {
        this.parcelHeight = parcelHeight;
    }

    @XmlElement(name="parcelDepth")
    public float getParcelDepth() {
        return parcelDepth;
    }
    public void setParcelDepth(float parcelDepth) {
        this.parcelDepth = parcelDepth;
    }

    @XmlElement(name="parcelWeight")
    public float getParcelWeight() {
        return parcelWeight;
    }
    public void setParcelWeight(float parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    @XmlElement(name="pickupTimestamp")
    public long getPickupTimestamp() {
        return pickupTimestamp;
    }
    public void setPickupTimestamp(long pickupTimestamp) {
        this.pickupTimestamp = pickupTimestamp;
    }

    @XmlElement(name="fromAddress")
    public Address getFrom() {
        return from;
    }
    public void setFrom(Address from) {
        this.from = from;
    }

    @XmlElement(name="toAddress")
    public Address getTo() {
        return to;
    }
    public void setTo(Address to) {
        this.to = to;
    }

    @XmlElement(name="receiverName")
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @XmlElement(name="id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "job=" + job +
                ", parcelWidth=" + parcelWidth +
                ", parcelHeight=" + parcelHeight +
                ", parcelDepth=" + parcelDepth +
                ", parcelWeight=" + parcelWeight +
                ", pickupTimestamp=" + pickupTimestamp +
                ", from=" + from +
                ", to=" + to +
                ", receiver='" + receiver + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
