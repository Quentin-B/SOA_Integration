package fr.unice.polytech.soa1.camillie.fedps.customers.privateservice;

import fr.unice.polytech.soa1.camillie.fedps.errors.BadJobFault;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.input.CustomerInput;
import fr.unice.polytech.soa1.camillie.fedps.customers.privateservice.output.CustomerOutput;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private/customer")
public interface CustomerPrivateInterface {
    @WebMethod(operationName = "process")
    @WebResult(name = "result")
    public CustomerOutput dispatch(@WebParam(name = "jobs") CustomerInput input) throws BadJobFault;
}
