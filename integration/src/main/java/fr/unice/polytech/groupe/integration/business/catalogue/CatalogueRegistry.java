package fr.unice.polytech.groupe.integration.business.catalogue;

import javax.xml.bind.annotation.XmlElement;

import fr.unice.polytech.groupe.integration.business.Address;

public class CatalogueRegistry {
	
	private String name;
	private Address deliveryAddress;
	
	@XmlElement(name="name", required=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="address", required=true)
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}	

}
