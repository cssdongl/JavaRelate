package org.ldong.java.alogrim;

public class ArrayCross {
	// 找出2个数组的交集
	// 方法1.暴力循环
	// 方法2.借助HashSet来去重后，添加第2个数组相同的元素会添加失败，失败的就是重复的元素
	// 方法3.2个指针随大小移动，存在指针指向2个数组相同元素的情况
	// 方法4.借助第3个数组存储Hash,如果相同的hash值碰撞则为重复
	
	
	public static void main(String[] args) {
		ArrayCross ac = new ArrayCross();
		int[] a = { 1, 2, 3, 4 };
		int[] b = { 2, 3, 4, 5, 6 };
		// ac.findCross(a, b);
		System.out.println(ac.findCrossByHash(a, b));
	}

	private void findCross(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				i++;
			else if (a[i] > b[j])
				j++;
			else {
				System.out.println(a[i]);
				i++;
				j++; 
			}
		}
	}

	private String findCrossByHash(int[] a, int[] b) {
		int aMax = a[a.length - 1];
		int bMax = b[b.length - 1];

		String sameStr = "";

		int sameAtrLength = 0;
		if (aMax > bMax)
			sameAtrLength = aMax + 1;
		else
			sameAtrLength = bMax + 1;
		int[] sameArr = new int[sameAtrLength];

		for (int i = 0; i < a.length; i++) {
			sameArr[a[i]] = 1;
		}

		for (int j = 0; j < b.length; j++) {
			if (sameArr[b[j]] == 1) {
				sameStr += b[j] + ",";
			}
		}
		return sameStr;
	}
}
