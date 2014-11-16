package fr.unice.polytech.groupe.integration.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.unice.polytech.groupe.integration.business.GetOrderInput;
import fr.unice.polytech.groupe.integration.business.OrderInput;
import fr.unice.polytech.groupe.integration.business.Receipt;
import fr.unice.polytech.groupe.integration.exceptions.UnknownResourceException;

@WebService(name="MisterDiscountService")
public interface MisterDiscountService {

	@WebResult(name="receipt")
	public Receipt createOrder(@WebParam(name="order") OrderInput order) throws UnknownResourceException;
	
	@WebResult(name="receipt")
	public Receipt getOrderInfo(@WebParam(name="order") GetOrderInput order) throws UnknownResourceException;
	
}
