package com.retail.store.process.discount;

public interface DiscountProcess {
	/**
	 * 
	 * @param totalAmount
	 * @param discount
	 * @return
	 * This implementation of this method will apply the discount on total amount and return the amount after deducting the discount
	 * Calculation of discount is based on the implementation
	 */
	
	float getAmount(float totalAmount, float discount);
}
