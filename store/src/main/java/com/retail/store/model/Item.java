package com.retail.store.model;

import com.retail.store.appenum.ItemType;

public class Item {
	private String name;
	private float amount;
	private ItemType itemType;
	
	public Item() {
	}
	
	public Item(String name, float amount, ItemType itemType) {
		super();
		this.name = name;
		this.amount = amount;
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

}
