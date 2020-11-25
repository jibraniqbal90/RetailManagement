package com.retail.store.process.discount;

public class AmountBasedDiscountProcess implements DiscountProcess{
	private float amountCutOff;
	
	public AmountBasedDiscountProcess(float amountCutOff) {
		this.amountCutOff = amountCutOff;
	}
	
	@Override
	public float getAmount(float totalAmount, float discountedAmount) {
		return totalAmount - ((int) (totalAmount / amountCutOff) * discountedAmount);
	}


}
