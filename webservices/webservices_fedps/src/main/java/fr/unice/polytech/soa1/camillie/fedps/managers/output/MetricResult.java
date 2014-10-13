package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import fr.unice.polytech.soa1.camillie.fedps.managers.input.MetricType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Metric.class, OrdersList.class})
@XmlRootElement(name="metric")
public class MetricResult extends ManagerJobResult {

    protected MetricType metric;

    public MetricResult(){}

    public MetricResult(MetricType metricType) {
        this.metric = metricType;
    }

    @XmlElement(name = "metricType")
    public MetricType getMetric() {
        return metric;
    }

    public void setMetric(MetricType metric) {
        this.metric = metric;
    }

}
