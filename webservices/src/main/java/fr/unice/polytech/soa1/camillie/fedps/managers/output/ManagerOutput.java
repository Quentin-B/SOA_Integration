package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import fr.unice.polytech.soa1.camillie.fedps.managers.output.ManagerJobResult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "manager_output")
public class ManagerOutput {

    public ManagerOutput() {}

    private List<ManagerJobResult> results;

    @XmlElementWrapper(name = "results")
    @XmlElement(name = "item")
    public List<ManagerJobResult> getResults() { return results; }
    public void setResults(List<ManagerJobResult> results) { this.results = results; }
}
