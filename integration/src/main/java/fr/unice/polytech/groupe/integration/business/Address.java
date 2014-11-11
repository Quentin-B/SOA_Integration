package fr.unice.polytech.groupe.integration.business;

import javax.xml.bind.annotation.XmlElement;

public class Address {

	private String addressLine1;
	private String addressLine2;
	private String cityName;
	private String zipCode;
	private String country;
	private Kind kind;
	
	@XmlElement(name="line1", required=true)
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@XmlElement(name="line2")
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	@XmlElement(name="city", required=true)
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@XmlElement(name="zip", required=true)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@XmlElement(name="country", required=true)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement(name="kind")
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
}
