package fr.unice.polytech.soa1.camillie.fedps.business;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement(name = "address")
public class Address {

    private String street;
    private int zipCode;
    private String cityName;
    private String countryId;

    public Address(){}

    public Address(int zipCode, String street, String cityName, String countryId) {
        this.zipCode = zipCode;
        this.street = street;
        this.cityName = cityName;
        this.countryId = countryId;
    }

    @XmlElement(name="zip")
    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @XmlElement(name="street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlElement(name="city")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlElement(name="country")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}