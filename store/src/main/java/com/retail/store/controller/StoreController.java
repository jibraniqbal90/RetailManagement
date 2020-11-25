package com.retail.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.model.Bill;
import com.retail.store.model.Customer;
import com.retail.store.service.StoreService;


@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;

	@PostMapping("/bill")
	public Bill generateBill(@RequestBody Customer customer) {
		return service.generateBill(customer);
	}
}
