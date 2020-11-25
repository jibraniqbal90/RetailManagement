package com.retail.store.model;

public class Bill {
	private float groceriesAmount;
	private float nonGroceriesAmount;
	private float payableAmount;
	private int totalItems;
	
	
	public float getGroceriesAmount() {
		return groceriesAmount;
	}
	public void setGroceriesAmount(float groceriesAmount) {
		this.groceriesAmount = groceriesAmount;
	}
	public float getNonGroceriesAmount() {
		return nonGroceriesAmount;
	}
	public void setNonGroceriesAmount(float nonGroceriesAmount) {
		this.nonGroceriesAmount = nonGroceriesAmount;
	}
	public float getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(float payableAmount) {
		this.payableAmount = payableAmount;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	
}
