package fr.unice.polytech.soa1.donato.redwarehouse.business;

import java.util.HashSet;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Product
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String reference;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int width;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int height;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int depth;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int quantity;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Box box;
	
	public Set<Planning> plannings = new HashSet<>();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Product(){
		super();
	}
	
	public Product(String reference, int width, int height, int depth,
			int quantity) {
		super();
		this.reference = reference;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.quantity = quantity;
	}

	public Product(String reference, int width, int height, int depth,
			int quantity, Box box) {
		this(reference, width, height, depth, quantity);
		this.box = box;
	}

	
}

