package fr.unice.polytech.soa1.teamforce.business;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
public class Catalogue {
    private String id;
    private String name;
    private Set<Product> productList;
    private String startDate;
    private String endDate;

    public Catalogue(String id, String name, Set<Product> productList, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.productList = productList;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Catalogue(String name, String startDate, String endDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.productList = new HashSet<>();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public JSONObject toJSON()
    {
        JSONObject jso = new JSONObject();
        jso.put("id",id);
        jso.put("name",name);
        jso.put("productList",productList);
        jso.put("startDate",startDate);
        jso.put("endDate",endDate);
        return jso;
    }

}
