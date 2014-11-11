package fr.unice.polytech.groupe.integration.business.warehouse;

import java.util.Date;

import fr.unice.polytech.groupe.integration.business.Address;

public class CreatePickupResult {

	private String planningUrl;
	private String planningID;
	private Date pickupdate;
	private Address warehouseAddress;
	private int depth;
	private int width;
	private int height;
	private int weight;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPlanningUrl() {
		return planningUrl;
	}

	public void setPlanningUrl(String planningUrl) {
		this.planningUrl = planningUrl;
	}

	public String getPlanningID() {
		return planningID;
	}

	public void setPlanningID(String planningID) {
		this.planningID = planningID;
	}

	public Date getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}

	public Address getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(Address warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
