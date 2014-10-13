package fr.unice.polytech.soa1.camillie.fedps.managers.output;

import fr.unice.polytech.soa1.camillie.fedps.managers.input.MetricType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType
public class OrdersList extends MetricResult {

    private List<ShortOrder> orders;
    private int number;

    public OrdersList() {
        orders = new ArrayList<ShortOrder>();
    }

    public OrdersList(MetricType metric) {
        super(metric);
        orders = new ArrayList<ShortOrder>();
    }

    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    public List<ShortOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ShortOrder> orders) {
        this.orders = orders;
        this.number = orders.size();
    }

    @XmlAttribute(name = "nbOrders")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void add(ShortOrder order) {
        if (order != null) {
            this.orders.add(order);
            number++;
        }
    }
}
