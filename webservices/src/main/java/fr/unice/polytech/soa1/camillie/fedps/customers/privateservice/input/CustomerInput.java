package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.input;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "customer_input")
public class CustomerInput {

    public CustomerInput() {}

    private List<CustomerQuery> jobs;

    @XmlElementWrapper(name = "jobs")
    @XmlElement(name = "job", required = true)
    public List<CustomerQuery> getJobs() { return jobs; }
    public void setJobs(List<CustomerQuery> jobs) { this.jobs = jobs; }

}
