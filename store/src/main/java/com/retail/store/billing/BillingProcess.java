package com.retail.store.billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.retail.store.appenum.ItemType;
import com.retail.store.model.Bill;
import com.retail.store.model.Item;
import com.retail.store.process.discount.DiscountProcess;
import com.retail.store.process.factory.DiscountFactory;
import com.retail.store.utility.Utility;

@Component
public class BillingProcess {
	
	private Bill bill;
	
	@Value("${amountCutOff}")
	private float amountCutOff;
	
	@Value("${discountedAmount}")
	private float discountedAmount;
	
	/**
	 * 
	 * @param discountPercent
	 * @param itemList
	 * @return
	 * 
	 * This method will calculate the final bill.
	 * First it will calculate the Groceries and non Groceries bill
	 * After that it will apply respective discount to non groceries amount
	 * Final bill is calculated after applying amount based discount.
	 * 
	 */
	
	public Bill generateBill(float discountPercent, List<Item> itemList) {
		bill = new Bill();
		float nonGroceriesAmountAfterDiscount;
		float totalAmount;
		float netPayableAmount;
		calcualteBillAmount(itemList);
		nonGroceriesAmountAfterDiscount = getNonGroceriesAmtAfterDiscount(discountPercent);
		totalAmount = nonGroceriesAmountAfterDiscount + bill.getGroceriesAmount();
		netPayableAmount = getNetPayableAmount(totalAmount);
		bill.setPayableAmount(Utility.format(netPayableAmount));
		bill.setTotalItems(itemList.size());
		return bill;
	}
	
	/**
	 * 
	 * @param discountPercent
	 * @return
	 * 
	 * This method will calculate the percentage based discount on Non groceries amount
	 */
	
	private float getNonGroceriesAmtAfterDiscount(float discountPercent) {
		DiscountProcess discountProcess  = DiscountFactory.getPercentageBasedInstance();
		return discountProcess.getAmount(bill.getNonGroceriesAmount(), discountPercent);
	}
	
	/**
	 * 
	 * @param totalAmount
	 * @return
	 * 
	 * This method will calculate the final bill after applying Amount based discount
	 */
	
	
	private float getNetPayableAmount(float totalAmount) {
		DiscountProcess discountProcess  = DiscountFactory.getAmountBasedInstance(amountCutOff);
		return discountProcess.getAmount(totalAmount, discountedAmount);
	}
	
	/**
	 * 
	 * @param itemList
	 * This method will calculate the total amount for Groceries and non Groceries items.
	 */
	
	private void calcualteBillAmount(List<Item> itemList) {
		float nonGroceriesTotalAmount = 0.0f;
		float groceriesTotalAmount = 0.0f;
		for(Item item: itemList) {
			if(item.getItemType() == ItemType.NON_GROCERY) {
				nonGroceriesTotalAmount += item.getAmount();	
			}else {
				groceriesTotalAmount += item.getAmount();
			}
		}
		bill.setGroceriesAmount(Utility.format(groceriesTotalAmount));
		bill.setNonGroceriesAmount(Utility.format(nonGroceriesTotalAmount));
	}
	
}
