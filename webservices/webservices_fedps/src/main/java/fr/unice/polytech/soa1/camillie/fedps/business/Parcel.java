package fr.unice.polytech.soa1.camillie.fedps.business;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "parcel")
public class Parcel extends Box {

    private String id;
    private ParcelStatus status;

    public Parcel() {
    }

    public Parcel(String id, ParcelStatus status, float height, float width, float depth, float weight) {
        super(height, width, depth, weight);
        this.id = id;
        this.status = status;
    }

    public Parcel(String id, ParcelStatus status, Box box) {
        super(box.getHeight(), box.getWidth(), box.getDepth(), box.getWeight());
        this.id = id;
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

    @XmlElement(name = "status")
    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {  // Necessary for object stored in collections ( => find, remove, ...)
        return (this == that || (that instanceof Customer && this.id.equals(((Parcel) that).id)));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
