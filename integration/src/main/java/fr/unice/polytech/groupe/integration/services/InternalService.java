package fr.unice.polytech.groupe.integration.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.unice.polytech.groupe.integration.business.catalogue.CatalogueRegistry;

@WebService(name="MisterDiscountInternalService")
public interface InternalService {

	@WebResult(name="done")
	public boolean registerForCatalogue(@WebParam(name="data") CatalogueRegistry data);
	
	@WebResult(name="number")
	public int orderCatalogues();
	
	@WebResult(name="number")
	public int sendCatalogues();
	
}