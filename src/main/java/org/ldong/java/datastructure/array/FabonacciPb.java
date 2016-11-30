package org.ldong.java.datastructure.array;

public class FabonacciPb {
	public static void main(String[] args){
		
		//1,2,3,5,8,13,21...
		
		int  a = 1,b=2;
		int c = a = 1;
		int i=1, n = 5;
		
		while(i <= 5){
			if(i==1){
				c = a;
			
			}
			if(i==2){
				c = b;
			
			}
			if(i>2){
				c = a +b;
				a = b;
				b = c;
			}
			
			i++;
		}
		System.out.println(c);
	}
}
