package org.ldong.java.alogrim;

public class InsertSort {
	public static void main(String[] args) {
		int[] a = { 4, 3, 7, 19, 8, 9 };

		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
		for (int num : a) {
			System.out.print(num + ",");
		}
	}
}
