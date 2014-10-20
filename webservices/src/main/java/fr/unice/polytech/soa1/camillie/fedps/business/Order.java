package fr.unice.polytech.soa1.camillie.fedps.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType
@XmlRootElement(name = "order")
public class Order extends Command {

    private String parcelId;
    private ParcelStatus status;

    public Order() {
    }

    public Order(String id, String customerId, String receiver, Address from, Address to, long pickUpDate,
                 float width, float height, float depth, float weight, String parcelId) {
        super(id, customerId, receiver, from, to, pickUpDate, width, height, depth, weight);
        this.parcelId = parcelId;
        this.status = ParcelStatus.WAIT_PICKUP;
    }

    public Order(String id, Quote quote, String parcelId) {
        super(id, quote.getCustomerId(), quote.getReceiverName(), quote.getFrom(), quote.getTo(), quote.getPickUpDate(), quote.getBox());
        this.parcelId = parcelId;
        this.status = ParcelStatus.WAIT_PICKUP;
    }

    public Order(String id, Quote quote, long newPickupDate, String parcelId) {
        super(id, quote.getCustomerId(), quote.getReceiverName(), quote.getFrom(), quote.getTo(), newPickupDate, quote.getBox());
        this.parcelId = parcelId;
        this.status = ParcelStatus.WAIT_PICKUP;
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
        return (this == that || (that instanceof Order && this.id.equals(((Order) that).id)));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

}
