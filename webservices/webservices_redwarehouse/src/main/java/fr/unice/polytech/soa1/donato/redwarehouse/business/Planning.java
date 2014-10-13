package fr.unice.polytech.soa1.donato.redwarehouse.business;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@XmlType
public class Planning
{
	@XmlElement(name="id")
	public String id;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Date date;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Event status;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Warehouse warehouse;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Set<Employee> employees = new HashSet<>();
	
	public Product product;
	public int quantity;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Planning(){
		super();
	}

	public String getId() {
		return id;
	}

	@XmlElement(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Event getStatus() {
		return status;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	@XmlIDREF
	@XmlElement(name="employee")
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	
}

