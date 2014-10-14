package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice;

import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.input.CustomerJobKind;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.CustomerJobResult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name="JobValidation")
public class Validation extends CustomerJobResult {

    private CustomerJobKind job;
    private boolean done;

    public Validation() {
    }

    public Validation(CustomerJobKind jobKind, boolean done) {
        this.job = jobKind;
        this.done = done;
    }

    @XmlElement(name = "jobKind")
    public CustomerJobKind getJob() {
        return job;
    }

    public void setJob(CustomerJobKind job) {
        this.job = job;
    }

    @XmlElement(name = "isDone")
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
