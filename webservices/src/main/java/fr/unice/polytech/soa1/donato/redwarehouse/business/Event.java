package fr.unice.polytech.soa1.donato.redwarehouse.business;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public enum Event
{
	
	PREPARING_EXPEDITIONS_FOR_PICKUP("pickup"), RECEIVING_DELIVERIES_FROM_TRUCKS("delivery");
	
	String name;
	Event (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
