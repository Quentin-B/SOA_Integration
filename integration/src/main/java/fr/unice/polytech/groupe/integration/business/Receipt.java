package fr.unice.polytech.groupe.integration.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receipt {

	private String orderId;
	private String name;
	private Address shippingAddress;
	private List<Item> itemList;
	private Date eta;
	private double price;
	private double deliveryPrice;
	private double totalPrice;
	private String trackingNumber;
	private ParcelStatus parcelStatus;
	private PaymentStatus paymentStatus;
	
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
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus status) {
		this.paymentStatus = status;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ParcelStatus getParcelStatus() {
		return parcelStatus;
	}
	public void setParcelStatus(ParcelStatus parcelStatus) {
		this.parcelStatus = parcelStatus;
	}
}
