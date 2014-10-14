package fr.unice.polytech.soa1.camillie.fedps.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType
@XmlRootElement(name = "order")
public class Quote extends Command {

    /** will be able to order the transportation only before this time
     * After, will have to change the preferred pickup date */
    private Date validityTime;

    public Quote() {
    }

    public Quote(String id, String customerId, String receiver, Address from, Address to, Date pickUpDate, Box box) {
        super(id, customerId, receiver, from, to, pickUpDate, box);
    }

    public Quote(String id, String customerId, String receiver, Address from, Address to, Date pickUpDate, float width, float height, float depth, float weight) {
        super(id, customerId, receiver, from, to, pickUpDate, width, height, depth, weight);
    }

    @XmlElement(name="maxValidity")
    public Date getValidityTime() {
        return validityTime;
    }
    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    @Override
    public boolean equals(Object that) {  // Necessary for object stored in collections ( => find, remove, ...)
        return (this == that || (that instanceof Quote && this.id.equals(((Quote) that).id)));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

}
