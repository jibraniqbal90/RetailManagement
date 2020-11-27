package com.retail.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.retail.store.appenum.CustomerType;
import com.retail.store.appenum.ItemType;
import com.retail.store.model.Bill;
import com.retail.store.model.Customer;
import com.retail.store.model.Item;
import com.retail.store.service.StoreService;

@SpringBootTest(classes = StoreApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class StoreControllerTest {
	
	@MockBean
	private StoreService storeService;

	@LocalServerPort
	private int port;
	
	TestRestTemplate template = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	void testBillController() throws Exception {
		HttpEntity<Customer> request = new HttpEntity<>(getCustomer(), headers);
		final String baseURL = "http://localhost:"+port+"/store/bill";
		URI uri = new URI(baseURL);
		ResponseEntity<Bill> result = template.postForEntity(uri, request, Bill.class);
		assertEquals(200, result.getStatusCodeValue());		
	}
	
	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustomerType(CustomerType.EMPLOYEE);
		
		Item item1 = new Item();
		item1.setAmount(10.99f);
		item1.setItemType(ItemType.GROCERY);
		item1.setName("Chicken");
		
		Item item2 = new Item();
		item2.setAmount(15.95f);
		item2.setItemType(ItemType.GROCERY);
		item2.setName("Butter");
		
		Item item3 = new Item();
		item3.setAmount(250.00f);
		item3.setItemType(ItemType.NON_GROCERY);
		item3.setName("Shoes");
		
		Item item4 = new Item();
		item4.setAmount(88.23f);
		item4.setItemType(ItemType.NON_GROCERY);
		item4.setName("Shirt");
		
		Item item5 = new Item();
		item5.setAmount(20.50f);
		item5.setItemType(ItemType.NON_GROCERY);
		item5.setName("Belt");

		List<Item> itemList = new ArrayList<>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		customer.setItemList(itemList);
		return customer;
	}
	

}
