package org.ldong.java.regex;

import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
		String httpResCodeRegex = "\\d{3}";
		boolean matchResult = Pattern.compile(httpResCodeRegex).matcher("500").matches();
		if(matchResult){
			System.out.println("it matches");
		}
	}
}
