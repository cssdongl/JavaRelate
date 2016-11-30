package org.ldong.java.alogrim;

public class FeiShiShulie {
	// 斐那波契数列

	public static void main(String[] args) {
		int N =100;
		FeiShiShulie fss = new FeiShiShulie();
		fss.nonRecruise(N);
//		int result = fss.recruise(N);
//		System.out.println(result);
	}

	private void nonRecruise(int n) {
		long a = 0, b = 1;
		long c = 0;
		for (int i = 0; i < n; i++) {
			c = a + b;
			System.out.println(c);
			a = b;
			b = c;
		}
	}

	private int recruise(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return recruise(n - 1) + recruise(n - 2);
	}
}
