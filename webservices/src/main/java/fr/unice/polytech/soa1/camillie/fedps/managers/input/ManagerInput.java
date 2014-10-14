package fr.unice.polytech.soa1.camillie.fedps.managers.input;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "manager_input")
public class ManagerInput {

    public ManagerInput() {}

    private List<ManagerQuery> jobs;

    @XmlElementWrapper(name = "jobs")
    @XmlElement(name = "job", required = true)
    public List<ManagerQuery> getJobs() { return jobs; }
    public void setJobs(List<ManagerQuery> jobs) { this.jobs = jobs; }

}
