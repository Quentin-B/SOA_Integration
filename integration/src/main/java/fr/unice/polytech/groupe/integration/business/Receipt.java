package fr.unice.polytech.groupe.integration.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receipt {

	private List<Item> itemList;
	private Date eta;
	private double price;
	private double deliveryPrice;
	private String trackingNumber;
	private Status status;
	
	public Receipt() {
		itemList = new ArrayList<Item>();
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> items) {
		this.itemList = items;
	}
	public Date getEstimationDate() {
		return eta;
	}
	public void setEstimationDate(Date estimationDate) {
		this.eta = estimationDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double endPrice) {
		this.price = endPrice;
	}
	public double getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
