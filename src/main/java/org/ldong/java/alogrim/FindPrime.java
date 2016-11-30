package org.ldong.java.alogrim;

public class FindPrime {
	public static void main(String[] args) {
		int N = 100;
		boolean[] prime = new boolean[N];
		for (int i = 2; i < N; i++) {
			if (i % 2 == 0)
				prime[i] = false;
			else
				prime[i] = true;
		}
		for (int i = 3; i * i < N; i++) {
			if (prime[i]) {
				for (int j = i + i; j < N; j += i) {
					prime[j] = false;
				}
			}
		}
		for (int k = 0; k < N; k++) {
			if(k ==2){
				System.out.println(k);
			}
			if (prime[k]) {
				System.out.print(k+" ");
			}
		}
	}

}
