package org.ldong.java.datastructure.sort;

public class InsertSort {
	public static void main(String[] args){
		
		int[] a = new int[]{4,2,5,3,7,10,8};
		
		for(int i=0;i<a.length;i++){
			
			int newValue = a[i];
			int j = i;
			while(j>0 && a[j-1] > a[j]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = newValue;
		}
	}
}
