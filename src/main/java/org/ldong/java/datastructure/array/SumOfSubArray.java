package org.ldong.java.datastructure.array;

public class SumOfSubArray {
	public static void main(String[] args){
		int a[] = new int[]{1,2,3,4,5,6,7,8};
		
		int value = 7;
		
		int firstIndex = 0;
		int lastIndex = a.length - 1;
		int sum = a[firstIndex]+a[lastIndex];
		
		while(sum != value && firstIndex < lastIndex){
			if(sum < value){
				firstIndex++;
			}else{
				lastIndex--;
			}
			sum = a[firstIndex]+a[lastIndex];
		}
		if(sum == value){
			
			System.out.println("the value sum by "+a[firstIndex]+"+"+a[lastIndex]);
		}
		
		
	}
}
