package fr.unice.polytech.groupe.integration.business.catalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Quentin Bitschené on 06/10/2014.
 */
public class Catalogue {
    private String id;
    private String name;
    private List<Product> productList;
    private String startDate;
    private String endDate;
    
    public Catalogue()
    {
    	this.productList = new ArrayList<Product>();
    }

    public Catalogue(String id, String name, ArrayList<Product> productList, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.productList = productList;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Catalogue(String name, String startDate, String endDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.productList = new ArrayList<Product>();
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
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

}
