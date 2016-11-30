package org.ldong.java.thread.automatic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private int i = 0;

	private AtomicInteger atomicI = new AtomicInteger(0);

	public static void main(String[] args) {
		final Counter c = new Counter();

		List<Thread> threadList = new ArrayList<Thread>();

		long start = System.currentTimeMillis();

		for (int j = 0; j < 100; j++) {
			Thread t = new Thread(new Runnable() {

				public void run() {
					for (int i = 0; i < 10000; i++) {
						c.count();
						c.safeCount();
					}
				}

			});
			threadList.add(t);

		}

		for (Thread t : threadList) {
			t.start();
		}

//		for (Thread t : threadList) {
//			try {
//				t.join();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		System.out.println("i= "+c.i);
		System.out.println("atomici= " + c.atomicI.get());
		System.out.println(System.currentTimeMillis() - start);
	}

	private void safeCount() {
		atomicI.incrementAndGet();
	}

	private void count() {
		i++;
	}
}
