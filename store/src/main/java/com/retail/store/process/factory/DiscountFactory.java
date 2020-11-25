package com.retail.store.process.factory;

import com.retail.store.process.discount.AmountBasedDiscountProcess;
import com.retail.store.process.discount.DiscountProcess;
import com.retail.store.process.discount.PercentageBasedDiscountProcess;

public class DiscountFactory {
	private static PercentageBasedDiscountProcess percentageBasedInstance;
	private static AmountBasedDiscountProcess amountBasedInstance = null;
	
	private DiscountFactory() {}
	
	public static DiscountProcess getPercentageBasedInstance() {
		synchronized (DiscountFactory.class) {
			if(percentageBasedInstance == null) {
				percentageBasedInstance = new PercentageBasedDiscountProcess();
			}
		}
		return percentageBasedInstance;
	}
	

	
	public static DiscountProcess getAmountBasedInstance(float amountCutOff) {
		synchronized (DiscountFactory.class) {
			if(amountBasedInstance == null) {
				amountBasedInstance = new AmountBasedDiscountProcess(amountCutOff);
			}			
		}
		return amountBasedInstance;
	}

}
