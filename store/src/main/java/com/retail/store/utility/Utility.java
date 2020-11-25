package com.retail.store.utility;

import java.text.DecimalFormat;

public interface Utility {
	
	public static float format(float number) {
	    DecimalFormat df = new DecimalFormat("0.00");
        return Float.valueOf(df.format(number));		
	}
}
