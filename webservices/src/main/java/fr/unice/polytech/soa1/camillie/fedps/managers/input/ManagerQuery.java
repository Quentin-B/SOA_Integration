package fr.unice.polytech.soa1.camillie.fedps.managers.input;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "manager_query")
public class ManagerQuery {
    
    public ManagerQuery() {}

    private AdminJobKind job;
    private MetricType metric;
    private String customerId;
    private Integer discount;

    @XmlAttribute(name = "kind", required = true)
    public AdminJobKind getJob() { return job; }
    public void setJob(AdminJobKind job) { this.job = job; }

    @XmlElement(name="metric")
    public MetricType getMetric() {
        return metric;
    }
    public void setMetric(MetricType metric) {
        this.metric = metric;
    }

    @XmlElement(name="customerId")
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @XmlElement(name="discount")
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
