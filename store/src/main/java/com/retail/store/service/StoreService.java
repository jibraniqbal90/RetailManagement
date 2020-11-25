package com.retail.store.service;

import com.retail.store.model.Bill;
import com.retail.store.model.Customer;

public interface StoreService {
	public Bill generateBill(Customer customer);

}
