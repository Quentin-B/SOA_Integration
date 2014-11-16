package fr.unice.polytech.groupe.integration.business;

import javax.xml.bind.annotation.XmlElement;

public class GetOrderInput {

	private String customerId;
	private String orderId;
	
	@XmlElement(name="customerId", required=true)
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String userId) {
		this.customerId = userId;
	}
	@XmlElement(name="orderId", required=true)
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
