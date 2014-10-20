package fr.unice.polytech.groupe.integration.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.unice.polytech.groupe.integration.business.Order;
import fr.unice.polytech.groupe.integration.business.Receipt;

@WebService(name="OrderService")
public interface OrderService {

	@WebResult(name="receipt")
	public Receipt createOrder(@WebParam(name="order") Order order);
	
}
