package com.cg.service;

public interface Validator {
	
	String aidpattern = "[1-9]{1}[0-9]{2}";
	String mobilepattern = "[1-9]{1}[0-9]{9}";
	//String namepattern = "((\\w){3}(\\w)* (\\w){3}(\\w)*)|(\\w+'\\w* \\w+)";
	String namepattern = "([A-Za-z]{3}([A-Za-z])* [A-Za-z]{3}([A-Za-z])*)|(([A-Za-z])+'([A-Za-z])* [A-Za-z]{3}([A-Za-z])*)|([A-Za-z]{3}([A-Za-z])* ([A-Za-z])+'([A-Za-z])*)";
	String balancepattern="(\\d)+|(\\d)+.(\\d)+";
	String amountpattern="[1-9][0-9]*.[0-9]{2}";
	public static boolean validatedata(String data,String pattern) {
		
		return data.matches(pattern);
		
	}
	
}
