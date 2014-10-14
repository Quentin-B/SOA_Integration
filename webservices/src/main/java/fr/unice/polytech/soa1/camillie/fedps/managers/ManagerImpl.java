package fr.unice.polytech.soa1.camillie.fedps.managers;

import fr.unice.polytech.soa1.camillie.fedps.business.Customer;
import fr.unice.polytech.soa1.camillie.fedps.business.DataAccessObject;
import fr.unice.polytech.soa1.camillie.fedps.errors.BadJobFault;
import fr.unice.polytech.soa1.camillie.fedps.errors.UnknownObjectFault;
import fr.unice.polytech.soa1.camillie.fedps.managers.input.ManagerInput;
import fr.unice.polytech.soa1.camillie.fedps.managers.input.ManagerQuery;
import fr.unice.polytech.soa1.camillie.fedps.managers.output.ManagerJobResult;
import fr.unice.polytech.soa1.camillie.fedps.managers.output.ManagerOutput;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless(name = "ManagersPrivate")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private/manager",
        portName = "ManagerPrivatePort",
        serviceName = "ManagerPrivateService",
        endpointInterface = "fr.unice.polytech.soa1.camillie.fedps.managers.ManagerInterface")
public class ManagerImpl implements ManagerInterface {

    @EJB
    private DataAccessObject dao;

    @Override
    public ManagerOutput dispatch(ManagerInput input) throws BadJobFault {
        List<ManagerJobResult> results = new ArrayList<>();
        for (ManagerQuery query : input.getJobs()) {
            check(query);
            ManagerJobResult result = null;
            switch (query.getJob()) {
                case VIEW_ALL:
                    result = getAll(query);
                    break;
                case VIEW_STAT:
                    result = getMetric(query);
                    break;
                case OFFER_DISCOUNT:
                    result = discount(query);
                    break;
            }
            results.add(result);
        }
        ManagerOutput out = new ManagerOutput();
        out.setResults(results);
        return out;
    }

    private ManagerJobResult getAll(ManagerQuery query) {
        return dao.getMetrics();
    }

    private ManagerJobResult getMetric(ManagerQuery query) {
        return dao.getMetric(query.getMetric());
    }

    private ManagerJobResult discount(ManagerQuery query) throws BadJobFault {
        Optional<Customer> customer = dao.findCustomerById(query.getCustomerId());
        if (!customer.isPresent())
            throw new UnknownObjectFault(query.getJob().toString(), "customer", query.getCustomerId());
        customer.get().setOneTimeDiscount(query.getDiscount());
        // Build a brand new object. Returning the reference does not prevent from side-effect by other jobs.
        return new Customer(customer.get());
    }

    private void check(ManagerQuery query) throws BadJobFault {
        Boolean error = false;
        if (query == null || query.getJob() == null)
            throw new BadJobFault("NON_EXISTING_JOB");
        switch (query.getJob()) {
            case VIEW_ALL:
                error = false;
                break;
            case VIEW_STAT:
                error = query.getMetric() == null;
                break;
            case OFFER_DISCOUNT:
                error = query.getCustomerId() == null || query.getDiscount() == null
                        || query.getDiscount() < 0 || query.getDiscount() > 100;
                break;
            default:
                error = true;
        }
        if (error)
            throw new BadJobFault(query.getJob().toString());
    }

}
