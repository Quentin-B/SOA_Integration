package fr.unice.polytech.soa1.camillie.fedps.business;

import fr.unice.polytech.soa1.camillie.fedps.managers.output.ManagerJobResult;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement(name = "customer")
public class Customer extends ManagerJobResult {

    private String id;
    private String name;
    private String email;
    private int permanentDiscount;
    private int oneTimeDiscount;

    public Customer() {
    }

    public Customer(String id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.permanentDiscount = discount;
    }

    public Customer(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.permanentDiscount = customer.getPermanentDiscount();
        this.oneTimeDiscount = customer.getOneTimeDiscount();
    }

    @XmlAttribute(name = "id")
    @XmlID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "permanentDiscount")
    public int getPermanentDiscount() {
        return permanentDiscount;
    }

    public void setPermanentDiscount(int permanentDiscount) {
        this.permanentDiscount = permanentDiscount;
    }

    @XmlElement(name = "oneTimeDiscount")
    public int getOneTimeDiscount() {
        return oneTimeDiscount;
    }

    public void setOneTimeDiscount(int oneTimeDiscount) {
        this.oneTimeDiscount = oneTimeDiscount;
    }

    @Override
    public boolean equals(Object that) {  // Necessary for object stored in collections ( => find, remove, ...)
        return (this == that || (that instanceof Customer && this.id.equals(((Customer) that).id)));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
