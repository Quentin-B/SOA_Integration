package fr.unice.polytech.soa1.camillie.fedps.errors;

import javax.xml.ws.WebFault;

@WebFault(name = "ExpiredQuote", targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private")
public class ExpiredQuoteException extends BadJobFault {

    public ExpiredQuoteException(String value, String quoteId) {
        super(value, "Quote " + quoteId + " expired.");
    }

}
