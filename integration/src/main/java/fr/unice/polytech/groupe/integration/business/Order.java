package fr.unice.polytech.groupe.integration.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Order {

	private String customerId;
	private String name;
	private String cardNumber;
	private Address invoiceAddress;
	private Address shippingAddress;
	private List<Item> itemList;
	private String teamForceId;
	private String wareHouseId;
	private String fedPsId;
	private double price;
	private DeliveryInfo deliveryInfo;
	private Map<String, Integer> products;
	private PaymentStatus paymentStatus;
	private ParcelStatus parcelStatus;

	public Order() {
		products = new HashMap<String, Integer>();
		itemList = new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
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

	public String getTeamForceId() {
		return teamForceId;
	}

	public void setTeamForceId(String teamForceId) {
		this.teamForceId = teamForceId;
	}

	public String getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(String wareHouseId) {
		this.wareHouseId = wareHouseId;
	}

	public String getFedPsId() {
		return fedPsId;
	}

	public void setFedPsId(String fedPsId) {
		this.fedPsId = fedPsId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Map<String, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Integer> products) {
		this.products = products;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus status) {
		this.paymentStatus = status;
	}

	public ParcelStatus getParcelStatus() {
		return parcelStatus;
	}

	public void setParcelStatus(ParcelStatus parcelStatus) {
		this.parcelStatus = parcelStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
