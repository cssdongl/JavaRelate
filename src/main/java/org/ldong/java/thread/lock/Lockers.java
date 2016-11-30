package org.ldong.java.thread.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lockers {
	public static class LockTest {
		private Lock lock = new ReentrantLock();

		private double value = 0d;

		private int addTimes = 0;

		public void addValue(final double v) {
			lock.lock();

			System.out.println("Lock test to add value " + v + "  "
					+ System.currentTimeMillis());

			// try {
			// Thread.sleep(100);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }

			this.value += v;

			this.addTimes++;

			lock.unlock();
		}

		public double getValue() {
			return value;
		}

	}

	public static void testLockTest() throws InterruptedException,
			ExecutionException {
		final LockTest lt = new LockTest();

		Runnable runnable1 = new Runnable() {

			public void run() {
				lt.addValue(55.55);
			}
		};

		Runnable runable2 = new Runnable() {

			public void run() {
				System.out.println("value: " + lt.getValue());
			}
		};
		ExecutorService es = Executors.newCachedThreadPool();

		Future future = null;

		for (int i = 0; i < 3; i++) {
			future = es.submit(runnable1);
		}

		future.get();

		future = es.submit(runable2);

		future.get();

		es.shutdownNow();

	}

	public static class ReadWriteLockTest {
		ReadWriteLock lock = new ReentrantReadWriteLock();

		private double value = 0d;

		private int addTimes = 0;

		public void addValue(double v) {
			Lock writeLock = lock.writeLock();
			writeLock.lock();

			System.out.println("ReadWriteLock to addvalue" + v + " "
					+ System.currentTimeMillis());

			try {
				value += v;
				addTimes++;
			} finally {
				writeLock.unlock();
			}
		}

		public String getInfo() {
			Lock readLock = lock.readLock();

			readLock.lock();

			System.out.println("ReadWriteLock to getValue" + " "
					+ System.currentTimeMillis());

			try {
				return this.value + ":" + this.addTimes;
			} finally {
				readLock.unlock();
			}
		}
	}

	public static void testReadWriteLock() throws InterruptedException,
			ExecutionException {
		final ReadWriteLockTest rwt = new ReadWriteLockTest();

		Runnable task1 = new Runnable() {

			public void run() {
				rwt.addValue(55.55);
			}
		};

		Runnable task2 = new Runnable() {

			public void run() {
				System.out.println("info :" + rwt.getInfo());
			}
		};

		ExecutorService es = Executors.newCachedThreadPool();

		Future<?> future1 = null;

		for (int i = 0; i < 2; i++) {

			future1 = es.submit(task1);
		}

		for (int i = 0; i < 2; i++) {
			future1 = es.submit(task2);
		}

		future1 = es.submit(task1);

		future1.get();

		es.shutdownNow();

	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
//		Lockers.testLockTest();
		Lockers.testReadWriteLock();
	}
}
