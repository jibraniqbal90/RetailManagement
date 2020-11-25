package com.retail.store.model;

import java.util.List;

import com.retail.store.appenum.CustomerType;

public class Customer {
	private CustomerType customerType;
	private List<Item> itemList;
	
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
