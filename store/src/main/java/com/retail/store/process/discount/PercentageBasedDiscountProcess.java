package com.retail.store.process.discount;

public class PercentageBasedDiscountProcess implements DiscountProcess{

	public PercentageBasedDiscountProcess() {}
	
	@Override
	public float getAmount(float totalAmount, float discountPercent) {
		  return  totalAmount - ((discountPercent * totalAmount)/100);
	}

}
