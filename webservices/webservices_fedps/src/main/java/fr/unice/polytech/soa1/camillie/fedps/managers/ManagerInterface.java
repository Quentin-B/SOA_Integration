package fr.unice.polytech.soa1.camillie.fedps.managers;

import fr.unice.polytech.soa1.camillie.fedps.errors.BadJobFault;
import fr.unice.polytech.soa1.camillie.fedps.managers.input.ManagerInput;
import fr.unice.polytech.soa1.camillie.fedps.managers.output.ManagerOutput;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/fedps/camillie/private/manager")
public interface ManagerInterface {

    @WebMethod(operationName = "process")
    @WebResult(name = "result")
    public ManagerOutput dispatch(@WebParam(name = "jobs")ManagerInput input) throws BadJobFault;

}
