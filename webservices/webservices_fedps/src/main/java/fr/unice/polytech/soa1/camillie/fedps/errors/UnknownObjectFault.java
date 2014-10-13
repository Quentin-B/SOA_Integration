package fr.unice.polytech.soa1.camillie.fedps.errors;

import javax.xml.ws.WebFault;

@WebFault(name = "UnknownObjectFault", targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private")
public class UnknownObjectFault extends BadJobFault {

    public UnknownObjectFault(String value, String type, String key) {
        super("Bad Job: [" + value + "] [Unknown " + type + "]: " + key + "\n");
    }

}
