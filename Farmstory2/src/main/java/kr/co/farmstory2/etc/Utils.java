package kr.co.farmstory2.etc;

import java.text.DecimalFormat;

public class Utils {

	public static String comma(String number) {
		int parseNumber = Integer.parseInt(number);
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(parseNumber);
				
	}
	
	public static String comma(int number) {
		DecimalFormat df = new DecimalFormat("###, ###");
		return df.format(number);
	}
	
	public static String ellipsis(String str, int length) {
		return str.substring(0, length)+"...";
	}
}
