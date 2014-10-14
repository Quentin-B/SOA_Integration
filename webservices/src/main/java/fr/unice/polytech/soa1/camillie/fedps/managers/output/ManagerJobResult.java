package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import fr.unice.polytech.soa1.camillie.fedps.business.Customer;

import javax.xml.bind.annotation.XmlSeeAlso;

// Support polymorphism at the XML serialization level
@XmlSeeAlso({MetricResult.class, Customer.class, MetricsResultList.class})
public abstract class ManagerJobResult {
}
