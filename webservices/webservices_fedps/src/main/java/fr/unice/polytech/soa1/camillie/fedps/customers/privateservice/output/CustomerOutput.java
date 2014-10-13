package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "customer_output")
public class CustomerOutput {

    public CustomerOutput() {}

    private List<CustomerJobResult> results;

    @XmlElementWrapper(name = "results")
    @XmlElement(name = "item")
    public List<CustomerJobResult> getResults() { return results; }
    public void setResults(List<CustomerJobResult> results) { this.results = results; }

}
