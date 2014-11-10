package fr.unice.polytech.groupe.integration.exceptions;

public class UnknownOperationException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnknownOperationException(String op) {
		super("Unknow operation : " + op);
	}
}
