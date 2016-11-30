package org.ldong.java.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

	static class outputer {
		Lock lock = new ReentrantLock();
		ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
		public void output(String name) {
			int len = name.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {

					System.out.println(name.charAt(i));
				}
			} catch (Exception e) {
				lock.unlock();
			}
			lock.unlock();
		}
	}
}
