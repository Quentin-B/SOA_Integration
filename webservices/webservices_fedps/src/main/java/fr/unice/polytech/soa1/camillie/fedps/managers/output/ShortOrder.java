package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import fr.unice.polytech.soa1.camillie.fedps.business.ParcelStatus;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlType
@XmlRootElement(name = "order")
public class ShortOrder {

    private String id;
    private String customerId;
    private Date pickUpDate;
    private Date ETA;
    private String parcelId;
    private ParcelStatus status;

    public ShortOrder() {
    }

    public ShortOrder(String id, String customerId, Date pickUpDate, Date ETA, String parcelId, ParcelStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.pickUpDate = pickUpDate;
        this.ETA = ETA;
        this.parcelId = parcelId;
        this.status = status;
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

    @XmlElement(name = "pickupDate")
    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    @XmlElement(name = "ETA")
    public Date getETA() {
        return ETA;
    }

    public void setETA(Date ETA) {
        this.ETA = ETA;
    }

    @XmlElement(name = "parcelId")
    public String getParcelId() {
        return parcelId;
    }

    public void setParcel(String parcel) {
        this.parcelId = parcel;
    }

    @XmlElement(name = "parcelStatus")
    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {  // Necessary for object stored in collections ( => find, remove, ...)
        return (this == that || (that instanceof ShortOrder && this.id.equals(((ShortOrder) that).id)));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }


}
