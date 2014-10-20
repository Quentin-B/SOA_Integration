package fr.unice.polytech.soa1.camillie.fedps.business;

import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.Validation;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.CustomerJobResult;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.QuotesList;
import fr.unice.polytech.soa1.camillie.fedps.errors.UnknownObjectFault;
import fr.unice.polytech.soa1.camillie.fedps.managers.input.MetricType;
import fr.unice.polytech.soa1.camillie.fedps.managers.output.*;

import java.math.BigInteger;
import java.util.*;
import javax.ejb.Singleton;

@Singleton(name = "FedPS-DB-Mock")
public class DataAccessObject {

    private List<Order> orders;
    private List<Quote> quotes;
    private List<Customer> customers;
    private Round round;

    public DataAccessObject() {
        init();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public ManagerJobResult getMetrics() {
        MetricsResultList res = new MetricsResultList();
        for (MetricType type : MetricType.values()) {
            res.add(getMetric(type));
        }
        return res;
    }

    public MetricResult getMetric(MetricType metric) {
        MetricResult res = null;
        switch (metric) {
            case LATE_ORDERS:
                res = new OrdersList(MetricType.LATE_ORDERS);
                for (Order o : orders) {
                    if (!(o.getStatus() == ParcelStatus.DELIVERED) && o.getETA() < new Date().getTime()) {
                        ((OrdersList) res).add(new ShortOrder(o.getId(), o.getCustomerId(),
                                o.getPickUpDate(), o.getETA(), o.getParcelId(), o.getStatus()));
                    }
                }
                break;
            case UNKNOWN_ORDERS:
                res = new OrdersList(MetricType.UNKNOWN_ORDERS);
                for (Order o : orders) {
                    if (o.getStatus() == ParcelStatus.UNKNOWN) {
                        ((OrdersList) res).add(new ShortOrder(o.getId(), o.getCustomerId(),
                                o.getPickUpDate(), o.getETA(), o.getParcelId(), o.getStatus()));
                    }
                }
                break;
            case NB_STORAGE:
                double d = orders.stream().filter(o -> o.getStatus() == ParcelStatus.STORAGE).count();
                res = new Metric(MetricType.NB_STORAGE, d);
                break;
            case NB_TRANSIT:
                double d2 = orders.stream().filter(o -> o.getStatus() == ParcelStatus.IN_TRANSIT).count();
                res = new Metric(MetricType.NB_TRANSIT, d2);
                break;
        }
        return res;
    }

    public Round getRound() {
        return round;
    }

    public Optional<Order> findOrderById(String id) {
        return getOrders().stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Optional<Order> findOrderByParcelId(String parcelId) {
        return getOrders().stream().filter(r -> r.getParcelId().equals(parcelId)).findFirst();
    }

    public Optional<Quote> findQuoteById(String id) {
        return getQuotes().stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Optional<Customer> findCustomerById(String customerId) {
        return getCustomers().stream().filter(r -> r.getId().equals(customerId)).findFirst();
    }

    private void init() {
        //Addresses
        Address a1 = new Address(32345, "Ap P179-6813 In St.", "Paris", "FR");
        Address a2 = new Address(32345, "669-9468 Nibh. St.", "Leonding", "US");
        Address a3 = new Address(32345, "P.O. Box 119, 9819 Nulla Avenue", "Galmaarden", "US");

        //Customers
        Customer c1 = new Customer("C2443514", "Jean Dupont", 0);
        Customer c2 = new Customer("C3254925", "Marine Jacques", 7);
        Customer c3 = new Customer("C4352939", "Vance Potts", 0);

        customers = new ArrayList<Customer>(Arrays.asList(c1, c2, c3));

        //Quotes
        quotes = new ArrayList<Quote>(Arrays.asList(
                new Quote("Q722466204", c1.getId(), c2.getName(), a1, a2, new Date(), 14, 14, 15, 22),
                new Quote("Q432124532", c1.getId(), c2.getName(), a1, a3, new Date(145423656), 10, 5, 5, 12),
                new Quote("Q759325745", c2.getId(), c3.getName(), a2, a3, new Date(), 8, 15, 12, 18.5f),
                new Quote("Q995738204", c1.getId(), c2.getName(), a1, a2, new Date(), 4, 24, 15, 32),
                new Quote("Q581453693", c3.getId(), c2.getName(), a1, a3, new Date(), 20, 21, 31, 22)));

        //Orders
        orders = new ArrayList<Order>(Arrays.asList(
                new Order("O465477457", c3.getId(), c2.getName(), a2, a3, new Date(145423656).getTime(), 18, 5, 12, 18.4f,
                        "P3377A1Y934XJQ660270"),
                new Order("O359036844", c1.getId(), c2.getName(), a3, a2, new Date(545423656).getTime(), 9, 14, 11, 22.9f, "P3967469799395757932"),
                new Order("O144021858", c3.getId(), c2.getName(), a3, a1, new Date().getTime(), 10, 10, 23, 12.3f, "P1259739579637939935"),
                new Order("O158038503", c2.getId(), c2.getName(), a2, a3, new Date().getTime(), 8, 15, 12.4f, 18, "P3295796794364949354")));

        List<Command> commands = new ArrayList<>(quotes);
        commands.addAll(orders);
        Calendar cal = Calendar.getInstance();
        Random r = new Random();
        //set prices and ETA
        for (Command c : commands) {
            setPriceAndETA(c);
        }

        //set order status
        orders.stream().filter(t -> t.getParcelId().endsWith("0")).forEach(t -> t.setStatus(ParcelStatus.UNKNOWN));
        orders.stream().filter(t -> t.getParcelId().endsWith("1")).forEach(t -> t.setStatus(ParcelStatus.WAIT_PICKUP));
        orders.stream().filter(t -> t.getParcelId().endsWith("2")).forEach(t -> t.setStatus(ParcelStatus.WAIT_PICKUP));
        orders.stream().filter(t -> t.getParcelId().endsWith("3")).forEach(t -> t.setStatus(ParcelStatus.IN_TRANSIT));
        orders.stream().filter(t -> t.getParcelId().endsWith("4")).forEach(t -> t.setStatus(ParcelStatus.IN_TRANSIT));
        orders.stream().filter(t -> t.getParcelId().endsWith("5")).forEach(t -> t.setStatus(ParcelStatus.ARRIVAL_SCAN));
        orders.stream().filter(t -> t.getParcelId().endsWith("6")).forEach(t -> t.setStatus(ParcelStatus.STORAGE));
        orders.stream().filter(t -> t.getParcelId().endsWith("7")).forEach(t -> t.setStatus(ParcelStatus.STORAGE));
        orders.stream().filter(t -> t.getParcelId().endsWith("8")).forEach(t -> t.setStatus(ParcelStatus.CUSTOMS));
        orders.stream().filter(t -> t.getParcelId().endsWith("9")).forEach(t -> t.setStatus(ParcelStatus.DELIVERED));

        //Round
        this.round = new Round();
        int i = 1;
        for (Order o : orders) {
            if (o.getStatus() == ParcelStatus.WAIT_PICKUP) {
                round.addStep(new Step(i++, o.getCustomerId(), o.getParcelId(), o.getFrom(), StepType.PICKUP, o.getStatus()));
            } else if (o.getStatus() == ParcelStatus.IN_TRANSIT) {
                round.addStep(new Step(i++, o.getCustomerId(), o.getParcelId(), o.getTo(), StepType.DELIVERY, o.getStatus()));
            }
        }
    }

    public void setPriceAndETA(Command c) {
        Calendar cal = Calendar.getInstance();
        Random r = new Random();
        //set prices and ETA
        cal.setTime(new Date(c.getPickUpDate()));
        int add = r.nextInt(5) + 2;
        cal.add(Calendar.DAY_OF_WEEK, add);
        c.setETA(cal.getTime().getTime());
        if (c instanceof Quote) {
            cal.add(Calendar.DAY_OF_WEEK, - 1);
            ((Quote) c).setValidityTime(cal.getTime());
        }
        c.setPrice(r.nextDouble() * 50);
    }

    public QuotesList getCustomerQuotes() {
        QuotesList list = new QuotesList();
        quotes.stream().filter(q -> q.getCustomerId().equals(getCustomers().get(0).getId())).forEach(list::add);
        return list;
    }

    public boolean deleteQuote(Quote q) throws UnknownObjectFault {
        return quotes.remove(q);
    }

    public String createId() {
        return new BigInteger(130, new Random()).toString(32);
    }

    public void registerOrder(Order order) {
        orders.add(order);
    }

    public void registerQuote(Quote quote) {
        quotes.add(quote);
    }
}
