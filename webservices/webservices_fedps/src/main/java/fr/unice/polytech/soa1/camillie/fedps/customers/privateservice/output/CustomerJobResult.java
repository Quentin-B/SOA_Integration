package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output;

import fr.unice.polytech.soa1.camillie.fedps.business.Order;
import fr.unice.polytech.soa1.camillie.fedps.business.Quote;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.Validation;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Quote.class, Order.class, QuotesList.class, Order.class, Validation.class})
public abstract class CustomerJobResult {
}
