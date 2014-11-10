package fr.unice.polytech.groupe.integration.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.unice.polytech.groupe.integration.business.OrderInput;
import fr.unice.polytech.groupe.integration.business.Receipt;

@WebService(name="MisterDiscountService")
public interface MisterDiscountService {

	@WebResult(name="receipt")
	public Receipt createOrder(@WebParam(name="order") OrderInput order);
	
}
