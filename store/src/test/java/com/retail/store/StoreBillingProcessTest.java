package com.retail.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.retail.store.appenum.ItemType;
import com.retail.store.billing.BillingProcess;
import com.retail.store.model.Item;

@SpringBootTest
public class StoreBillingProcessTest {
	
	@Autowired
	private BillingProcess billingProcess;
	
	@Before
	public void initializeValues() {
		ReflectionTestUtils.setField(billingProcess, "amountCutOff", 100f);
		ReflectionTestUtils.setField(billingProcess, "discountedAmount", 5f);
	}
	
	@Test
	public void generateBill_test() {
		assertEquals(268.05f, billingProcess.generateBill(30.0f, getItemList()).getPayableAmount());
	}
	
	private List<Item> getItemList(){
		List<Item> itemList = new ArrayList<>();
 		itemList.add(new Item("Chicken", 10.99f, ItemType.GROCERY));
 		itemList.add(new Item("Butter", 15.95f, ItemType.GROCERY));
 		itemList.add(new Item("Shoes", 250.0f, ItemType.NON_GROCERY));
 		itemList.add(new Item("Shirt", 88.23f, ItemType.NON_GROCERY));
 		itemList.add(new Item("Belt", 20.50f, ItemType.NON_GROCERY));
 		return itemList;
	}
	
}
