package fr.unice.polytech.soa1.teamforce.business;

import org.json.JSONObject;

/**
 * Created by suparjam on 08/10/2014.
 */
public class Item {
    private Product product;
    private int quantity;
    private boolean available;

    public Item(Product product, int quantity, boolean available) {
        this.product = product;
        this.quantity = quantity;
        this.available = available;
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.available = true;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getAmount()    {
        return this.getQuantity()*this.getProduct().getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (available != item.available) return false;
        if (quantity != item.quantity) return false;
        if (product != null ? !product.equals(item.product) : item.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (available ? 1 : 0);
        return result;
    }

    public JSONObject toJSON()
    {
        JSONObject jso = new JSONObject();
        jso.put("product",product);
        jso.put("quantity",quantity);
        jso.put("available",available);
        return jso;
    }
}
