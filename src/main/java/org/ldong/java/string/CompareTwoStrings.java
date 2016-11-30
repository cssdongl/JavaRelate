package org.ldong.java.string;

public class CompareTwoStrings {
	public static void main(String[] args){
		char[] dd = new char[]{'2','d','c'};
		String str3 = new String("sdd");
		String str1 = "sdfsfs";
	
		String str2 = "sdfsfs";
		
		
		boolean isEqual = false;
		
		if(str1 instanceof String && str2 instanceof String){
			int n = str1.length();
			int i=0;
			if(str2.length() == n){
				while(n-- != 0){
					if(str1.charAt(i) != str2.charAt(i)){
						isEqual = false;
					}
					i++;
				}
				isEqual = true;
			}
		}
		System.out.println("compare result"+isEqual);
	}
}
