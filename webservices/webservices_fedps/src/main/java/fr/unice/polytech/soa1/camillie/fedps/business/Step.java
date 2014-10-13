package fr.unice.polytech.soa1.camillie.fedps.business;

import fr.unice.polytech.soa1.camillie.fedps.customers.publicservice.StatusResponse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "step")
public class Step {

    private int number;
    private String customerId;
    private String parcelId;
    private Address destination;
    private StepType type;
    private ParcelStatus status;

    public Step() {
    }

    public Step(int id, String customer, String parcel, Address address, StepType type, ParcelStatus status) {
        this.number = id;
        this.customerId = customer;
        this.parcelId = parcel;
        this.destination = address;
        this.type = type;
        this.status = status;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int id) {
        this.number = id;
    }

    @XmlElement(name = "customer")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @XmlElement(name = "parcel")
    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelrId) {
        this.parcelId = parcelrId;
    }

    @XmlElement(name = "address")
    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    @XmlElement(name = "type")
    public StepType getType() {
        return type;
    }

    public void setType(StepType type) {
        this.type = type;
    }

    @XmlElement(name = "status")
    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {  // Necessary for object stored in collections ( => find, remove, ...)
        return (this == that || (that instanceof Step && this.number == (((Step) that).number) && this.parcelId.equals(((Step) that).parcelId)));
    }

    @Override
    public int hashCode() {
        return new String("" + number).hashCode() + new String("" + parcelId).hashCode();
    }
}
