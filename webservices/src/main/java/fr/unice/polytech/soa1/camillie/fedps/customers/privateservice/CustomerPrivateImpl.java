package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice;

import fr.unice.polytech.soa1.camillie.fedps.business.DataAccessObject;
import fr.unice.polytech.soa1.camillie.fedps.business.Order;
import fr.unice.polytech.soa1.camillie.fedps.business.Quote;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.input.*;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.CustomerJobResult;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.CustomerOutput;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.QuotesList;
import fr.unice.polytech.soa1.camillie.fedps.errors.BadJobFault;
import fr.unice.polytech.soa1.camillie.fedps.errors.ExpiredQuoteException;
import fr.unice.polytech.soa1.camillie.fedps.errors.UnknownObjectFault;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless(name = "CustomersPrivate")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private/customer",
        portName = "CustomerPrivatePort",
        serviceName = "CustomerPrivateService",
        endpointInterface = "fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.CustomerPrivateInterface")
public class CustomerPrivateImpl implements CustomerPrivateInterface {

    @EJB
    private DataAccessObject dao;

    @Override
    @WebMethod(operationName = "process")
    @WebResult(name = "result")
    public CustomerOutput dispatch(@WebParam(name = "jobs") CustomerInput input) throws BadJobFault {
        List<CustomerJobResult> results = new ArrayList<CustomerJobResult>();
        for (CustomerQuery query : input.getJobs()) {
            check(query);
            CustomerJobResult result = null;
            switch (query.getJob()) {
                case CREATE_QUOTE:
                    result = createQuote(query);
                    break;
                case CREATE_ORDER:
                    result = createOrder(query);
                    break;
                case CHANGE_QUOTE:
                    result = updateQuote(query);
                    break;
                case ORDER_QUOTE:
                    result = orderQuote(query);
                    break;
                case DELETE_QUOTE:
                    result = deleteQuote(query);
                    break;
                case VIEW_QUOTES:
                    result = getQuotes(query);
                    break;
                case VIEW_ORDER:
                    result = viewOrder(query);
                    break;
            }
            results.add(result);
        }
        CustomerOutput out = new CustomerOutput();
        out.setResults(results);
        return out;
    }

    private QuotesList getQuotes(CustomerQuery query) {
        return dao.getCustomerQuotes();
    }

    private Quote createQuote(CustomerQuery query) throws BadJobFault {
        String id = "Q" + dao.createId();
        Quote quote = new Quote(id, dao.getCustomers().get(0).getId(), query.getReceiver(), query.getFrom(),
                query.getTo(), query.getPickupTimestamp(), query.getParcelWidth(), query.getParcelHeight(),
                query.getParcelDepth(), query.getParcelWeight());
        dao.setPriceAndETA(quote);
        dao.registerQuote(quote);
        return quote;
    }

    private Order createOrder(CustomerQuery query) throws BadJobFault {
        String id = dao.createId();
        Order order = new Order("O" + id, dao.getCustomers().get(0).getId(), query.getReceiver(), query.getFrom(),
                query.getTo(), query.getPickupTimestamp(), query.getParcelWidth(), query.getParcelHeight(),
                query.getParcelDepth(), query.getParcelWeight(), "P" + id);
        dao.setPriceAndETA(order);
        dao.registerOrder(order);
        return order;
    }

    private Order viewOrder(CustomerQuery query) throws BadJobFault {
        Optional<Order> order = dao.findOrderById(query.getId());
        if(order.isPresent())
            return order.get();
        throw new UnknownObjectFault(query.getJob().name(),"order",query.getId());
    }

    private Quote updateQuote(CustomerQuery query) throws BadJobFault {
        Optional<Quote> quote = dao.findQuoteById(query.getId());
        if (!quote.isPresent())
            throw new UnknownObjectFault(query.getJob().name(), "quote", query.getId());
        quote.get().setPickUpDate(query.getPickupTimestamp());
        dao.setPriceAndETA(quote.get());
        return quote.get();
    }

    private Order orderQuote(CustomerQuery query) throws BadJobFault {
        Optional<Quote> quote = dao.findQuoteById(query.getId());
        if (!quote.isPresent())
            throw new UnknownObjectFault(query.getJob().name(), "quote", query.getId());
        if (quote.get().getValidityTime().getTime() < new Date().getTime())
            throw new ExpiredQuoteException(query.getJob().name(), query.getId());
        String tmpId = (query.getId().substring(1, query.getId().length()));
        Order order = new Order("O" + tmpId, quote.get(), "P" + tmpId);
        dao.setPriceAndETA(order);
        dao.registerOrder(order);
        dao.deleteQuote(quote.get());
        return order;
    }

    private Validation deleteQuote(CustomerQuery query) throws BadJobFault {
        Optional<Quote> quote = dao.findQuoteById(query.getId());
        if (!quote.isPresent())
            throw new UnknownObjectFault(query.getJob().name(), "quote", query.getId());
        return new Validation(CustomerJobKind.DELETE_QUOTE, dao.deleteQuote(quote.get()));
    }

    private void check(CustomerQuery query) throws BadJobFault {
        Boolean error = false;
        if (query == null || query.getJob() == null)
            throw new BadJobFault("NON_EXISTING_JOB");
        switch (query.getJob()) {
            case VIEW_QUOTES:
                error = false;
                break;
            case CREATE_ORDER:
            case CREATE_QUOTE:
                error = (query.getFrom() == null || query.getTo() == null || query.getParcelDepth() <= 0
                        || query.getParcelHeight() <= 0 || query.getParcelWidth() <= 0
                        || query.getParcelWeight() <= 0 || query.getPickupTimestamp() <= 0
                        || query.getReceiver() == null || query.getReceiver().isEmpty());
                break;
            case CHANGE_QUOTE:
                error = query.getId() == null || query.getId().isEmpty()
                        || query.getPickupTimestamp() <= 0;
                break;
            case VIEW_ORDER:
            case ORDER_QUOTE:
            case DELETE_QUOTE:
                error = query.getId() == null || query.getId().isEmpty();
                break;
            default:
                error = true;
        }
        if (error)
            throw new BadJobFault(query.getJob().toString());
    }

}
