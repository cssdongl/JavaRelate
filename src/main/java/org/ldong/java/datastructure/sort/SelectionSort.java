package org.ldong.java.datastructure.sort;

public class SelectionSort {
	public static void main(String[] args){
		
		
		int[] arr = new int[]{2,5,3,4,9,7,6};
		
		int minIndex = 0;
		
		
		
		for(int i=0;i<arr.length;i++){
			
			minIndex = i;
			
			for(int j=i+1;j<arr.length;j++){
				
				if(arr[j] < arr[minIndex]){
					
					minIndex = j;
				}
			}
			
			if(minIndex != i){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
				
			}
		}
		
		for(int num:arr){
			System.out.println(num);
		}
	}
}
