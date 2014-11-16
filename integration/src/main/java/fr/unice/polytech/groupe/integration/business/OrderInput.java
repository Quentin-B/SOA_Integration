package fr.unice.polytech.groupe.integration.business;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class OrderInput {

	private long customerId;
	private String name;
	private String cardNumber;
	private Address invoiceAddress;
	private Address shippingAddress;
	private Map<String, Integer> products;
	
	@XmlElement(name="name", required=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElementWrapper(name="products", required=true, nillable=false)
	public Map<String, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<String, Integer> products) {
		this.products = products;
	}
	
	@XmlElement(name="invoiceAddress", required=true)
	public Address getInvoiceAddress() {
		return invoiceAddress;
	}
	public void setInvoiceAddress(Address invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}
	
	@XmlElement(name="shippingAddress", required=true)
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@XmlElement(name="cardNumber", required=true)
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@XmlElement(name="id", required=true)
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long userId) {
		this.customerId = userId;
	}
}
