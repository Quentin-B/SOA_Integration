package fr.unice.polytech.soa1.camillie.fedps.errors;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.WebFault;

@XmlSeeAlso({ExpiredQuoteException.class,UnknownObjectFault.class})
@WebFault(name = "BadJobFault", targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private")
public class BadJobFault extends Exception {

    public BadJobFault(String value) {
        super("Bad Job: [" + value + "]");
    }

    public BadJobFault(String value, String detail) {
        super("Bad Job: [" + value + "]\n" + detail);
    }
}
