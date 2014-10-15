package fr.unice.polytech.soa1.donato.redwarehouse.business;

import javax.ejb.EJB;

public class Command {

	@EJB private DataAccessObject dao;
	
	private Planning planning;
	private Product product;
	private int quantity;
	
	public Command() {
		super();
	}
	
	public Command(String productRef, int quantity) {
		super();
		this.quantity = quantity;
		this.product = dao.findProducByRef(productRef);
	}
	
	public Command(Product product, int quantity) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
