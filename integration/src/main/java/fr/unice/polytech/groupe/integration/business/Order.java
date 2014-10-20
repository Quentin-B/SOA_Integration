package fr.unice.polytech.groupe.integration.business;

import java.util.Map;

public class Order {

	private String name;
	private String address; // TODO change object type to Address object
	private Map<String, Integer> mapIdProductQuantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<String, Integer> getMapIdProductQuantity() {
		return mapIdProductQuantity;
	}
	public void setMapIdProductQuantity(Map<String, Integer> mapIdProductQuantity) {
		this.mapIdProductQuantity = mapIdProductQuantity;
	}
}
