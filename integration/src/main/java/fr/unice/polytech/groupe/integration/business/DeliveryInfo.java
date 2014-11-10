package fr.unice.polytech.groupe.integration.business;

import java.util.Date;

public class DeliveryInfo {

	private float width;
	private float height;
	private float depth;
	private float weight;
	private Date pickupDate;
	private Date eta;
	private double deliveryPrice;
	private Address warehouseAddress;
	private String trackingNumber;

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Address getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(Address warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

}
