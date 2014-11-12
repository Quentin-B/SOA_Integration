package fr.unice.polytech.groupe.integration.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "unknownOrder")
public class UnknownOrderException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnknownOrderException() {
		super("Wrong order id");
	}

}
