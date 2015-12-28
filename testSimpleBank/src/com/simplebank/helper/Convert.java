package com.simplebank.helper;

public class Convert {
	public int strToInt (String[] stringa){
		return Integer.parseInt(stringa[0]);
	}

	public double strToDouble (String[] stringa){
		return Double.parseDouble(stringa[0]);
	}
	
	public String intToStr (int valueInteger){
		return String.valueOf(valueInteger);
	}

	public String doubleToStr (double valueDouble){
		return String.valueOf(valueDouble);
	}
}
