package fr.unice.polytech.soa1.donato.redwarehouse.services;

import javax.xml.ws.WebFault;

@WebFault(name="ErrorOnService", targetNamespace = "http://informatique.polytech.unice.fr/soa1/warehouse/rpc/private")
public class ErrorOnService extends Exception{

	private static final long serialVersionUID = 3930078000398444913L;

	public ErrorOnService(String message) {
		super(message);
	}
}
