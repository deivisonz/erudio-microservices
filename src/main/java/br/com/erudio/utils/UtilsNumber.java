package br.com.erudio.utils;

public class UtilsNumber {

	public static Double convertToDouble(String strNumber) {
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		} else {
			return 0D;
		}
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
	    String number = strNumber.replaceAll(",", ".");    
	    return number.matches("[-+]?[0-9]*\\.?[0-9]+");	    
	}
	
}
