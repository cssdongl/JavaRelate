package org.ldong.java.alogrim;

import java.util.Stack;

public class NumberOfOne {
	// 给定一个数字，打印出二进制表示,模2取余数，商为0时时基本出口，最后的余数倒序就是二级制表示
	private static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		NumberOfOne no = new NumberOfOne();
		no.numberOfOne(20);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	private void numberOfOne(int x) {
		if (x == 0) {
			return;
		} else {
			int y = x / 2;
			stack.push(x % 2);
			numberOfOne(y);
		}
	}
}
