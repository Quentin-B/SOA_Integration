package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlRootElement(name = "metrics")
public class MetricsResultList extends ManagerJobResult {

    private List<MetricResult> results;

    public MetricsResultList() {
        results = new ArrayList<MetricResult>();
    }

    @XmlElementWrapper(name = "metrics")
    @XmlElement(name = "metric")
    public List<MetricResult> getResults() {
        return results;
    }

    public void setResults(List<MetricResult> results) {
        this.results = results;
    }

    public void add(MetricResult res) {
        if (res != null) this.results.add(res);
    }
}
