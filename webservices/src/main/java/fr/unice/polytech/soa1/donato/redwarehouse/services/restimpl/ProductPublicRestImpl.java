package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import fr.unice.polytech.soa1.donato.redwarehouse.business.DataAccessObject;
import fr.unice.polytech.soa1.donato.redwarehouse.business.Product;

@Path("/rest/redwarehouse/public/products/")
public class ProductPublicRestImpl implements ProductPublicRest {

	@EJB private DataAccessObject dao;
	@Context private UriInfo uri;
	
	@Override
	public Response getProductByReference(String productRef) {
		
		if (productRef == null
				|| productRef.length() <= 0) {
			UnknownResource error = new UnknownResource("product ref", productRef);
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		
		Product product = dao.findProducByRef(productRef);
		if (product == null) {
			UnknownResource error = new UnknownResource("product ref", productRef);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		ProductByServiceProduct tmp = new ProductByServiceProduct();
		tmp.setProduct(product);
		
		return Response.ok(tmp).build();
	}

}

@XmlRootElement(name = "product")
class ProductByServiceProduct {
	
	private Product product;
	void setProduct (Product product) { this.product = product; }
	
	@XmlID
	public String getId() { return this.product.reference; }
	@XmlElement (name = "floor")
	public int getFloor() { return this.product.box.floor; }
	@XmlElement (name = "corridor")
	public String getCorridor() { return this.product.box.corridor; }
	@XmlElement (name = "rack")
	public String getRack() { return this.product.box.rackNumber; }
	@XmlElement (name = "quantity")
	public int getQuantity() { return this.product.quantity; }
}
