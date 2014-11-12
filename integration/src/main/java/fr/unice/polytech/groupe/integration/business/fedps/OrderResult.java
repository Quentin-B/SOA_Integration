package fr.unice.polytech.groupe.integration.business.fedps;

import java.util.Date;

public class OrderResult {
	
	private String orderId;
	private Date eta;
	private double deliveryPrice;
	private String trackingNumber;
	
	public Date getEstimationDate() {
		return eta;
	}
	public void setEstimationDate(Date estimationDate) {
		this.eta = estimationDate;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
