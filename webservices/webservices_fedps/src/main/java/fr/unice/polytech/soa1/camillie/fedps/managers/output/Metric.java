package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import fr.unice.polytech.soa1.camillie.fedps.managers.input.MetricType;
import fr.unice.polytech.soa1.camillie.fedps.managers.output.ManagerJobResult;
import fr.unice.polytech.soa1.camillie.fedps.managers.output.MetricResult;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "stat")
public class Metric extends MetricResult {

    private double value;

    public Metric() {
    }

    public Metric(MetricType metricType, double value) {
        super(metricType);
        this.value = value;
    }

    @XmlElement(name = "value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
