package org.ldong.java.string;

public class StringToInteger {
	public static void main(String[] args){
		
		String str = "3459";
		
//		int a = Integer.valueOf(str);
		int sum = 0;
		char[] strChars = str.toCharArray();
		for(int i=0;i<strChars.length;i++){
			char c = strChars[i];
			
			double value = Math.pow(10, strChars.length-i-1);
			//c-48 equals c-'0'
			sum +=  (c-'0')*value;
		}
		System.out.println(sum);
	}
}
