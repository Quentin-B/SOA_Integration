package fr.unice.polytech.groupe.integration.business;

import java.util.Date;
import java.util.List;

public class Receipt {

	private List<Item> listItem;
	private Date estimationDate;
	private double endPrice;
	private double livraisonPrice;
	private String numSuiviColis;
	public List<Item> getListItem() {
		return listItem;
	}
	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}
	public Date getEstimationDate() {
		return estimationDate;
	}
	public void setEstimationDate(Date estimationDate) {
		this.estimationDate = estimationDate;
	}
	public double getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(double endPrice) {
		this.endPrice = endPrice;
	}
	public double getLivraisonPrice() {
		return livraisonPrice;
	}
	public void setLivraisonPrice(double livraisonPrice) {
		this.livraisonPrice = livraisonPrice;
	}
	public String getNumSuiviColis() {
		return numSuiviColis;
	}
	public void setNumSuiviColis(String numSuiviColis) {
		this.numSuiviColis = numSuiviColis;
	}
}
