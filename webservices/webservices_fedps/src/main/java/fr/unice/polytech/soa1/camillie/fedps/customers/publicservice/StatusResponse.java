package fr.unice.polytech.soa1.camillie.fedps.customers.publicservice;

import fr.unice.polytech.soa1.camillie.fedps.business.ParcelStatus;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlType
@XmlRootElement(name = "parcel_status")
public class StatusResponse {

    private String parcelId;
    private ParcelStatus status;
    private Date eta;

    public StatusResponse(){}

    public StatusResponse(String parcelId, ParcelStatus status) {
        this.parcelId=parcelId;
        this.status=status;
    }

    public StatusResponse(String parcelId, ParcelStatus status, Date eta) {
        this(parcelId,status);
        this.eta=eta;
    }

    @XmlAttribute(name="id")
    @XmlID
    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    @XmlElement(name="status")
    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    @XmlElement(name="eta")
    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }
}
