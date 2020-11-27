package com.retail.store.process.discount;

public class PercentageBasedDiscountProcess implements DiscountProcess{
	
	@Override
	public float getAmount(float totalAmount, float discountPercent) {
		  return  totalAmount - ((discountPercent * totalAmount)/100);
	}

}
