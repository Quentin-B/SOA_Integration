package fr.unice.polytech.soa1.teamforce.business;

import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Set<Address> addressSet;
    private Access access;
    private List<Information> informations;


    public User(String id, String firstname, String lastname, String email, String phone, Address address,Access access) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.addressSet = new HashSet<Address>();
        this.addressSet.add(address);
        this.access = access;
        this.informations = new ArrayList<Information>();
    }

    public User(String id, String firstname, String lastname, String email, String phone, Set<Address> addressSetp,Access access) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.addressSet = addressSet;
        this.access = access;
        this.informations = new ArrayList<Information>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressList(Set<Address> addressMap) {
        this.addressSet = addressSet;
    }

    public void putAddress(Address address){
        this.addressSet.add(address);
    }

    public void addAddress(Address a4) {
        addressSet.add(a4);
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public List<Information> getInformations() {
        return informations;
    }

    public JSONObject getInformationsToJSON() {
        JSONObject jso = new JSONObject();
        jso.put("informations",informations);
        return jso;
    }

    public void setInformations(List<Information> informations) {
        this.informations = informations;
    }

    public void addInformation(Information information){
        this.informations.add(information);
    }


    public JSONObject toJSON()
    {
        JSONObject jso = new JSONObject();
        jso.put("id",id);
        jso.put("firstname",firstname);
        jso.put("lastname",lastname);
        jso.put("email",email);
        jso.put("phone",phone);
        jso.put("addressSet",addressSet);
        jso.put("access",access);
        return jso;
    }

}
