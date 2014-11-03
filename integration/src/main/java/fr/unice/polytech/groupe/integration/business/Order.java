package fr.unice.polytech.groupe.integration.business;

import java.util.Map;

public class Order {

	private String name;
	private Address invoiceAddress;
	private Address shippingAddress;
	private Map<String, Integer> mapIdProductQuantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, Integer> getMapIdProductQuantity() {
		return mapIdProductQuantity;
	}
	public void setMapIdProductQuantity(Map<String, Integer> mapIdProductQuantity) {
		this.mapIdProductQuantity = mapIdProductQuantity;
	}
	
	public Address getInvoiceAddress() {
		return invoiceAddress;
	}
	public void setInvoiceAddress(Address invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
