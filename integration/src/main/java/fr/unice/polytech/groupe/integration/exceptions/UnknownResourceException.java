package fr.unice.polytech.groupe.integration.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "unknownResource")
public class UnknownResourceException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnknownResourceException(String type, String id) {
		super("Unknown " + type + " : '" + id + "'");
	}

}
