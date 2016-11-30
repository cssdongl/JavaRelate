package org.ldong.java.alogrim;

public class FullCombine {
	// 字符串的全排列，其实就是每个索引的字母跟后面交换
	public static void main(String[] args) {
		FullCombine fc = new FullCombine();
		char[] str = "dongl".toCharArray();
		fc.fullCombine(str, 0);
	}

	private void fullCombine(char[] str, int beginIndex) {

		if (beginIndex == str.length - 1) {
			System.out.println(str);
		} else {
			for (int i = 0; i < str.length; i++) {
				swap(str, beginIndex, i);
				fullCombine(str, beginIndex + 1);
				swap(str, beginIndex, i);
			}

		}

	}

	private void swap(char[] str, int beginIndex, int changeIndex) {
		char temp = str[beginIndex];
		str[beginIndex] = str[changeIndex];
		str[changeIndex] = temp;
	}
}
