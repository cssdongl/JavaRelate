package org.ldong.java.thread.threadLocal;


public class ThreadLocalExample {
	public static class MyRunnable implements Runnable {
		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		
		private int count = 0;

		public void run() {
			
//			count = Math.random()
			threadLocal.set((int) (Math.random() * 1000));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(threadLocal.get());
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnable = new MyRunnable();
		
		Thread thread1 = new Thread(sharedRunnable);
		
		Thread thread2 = new Thread(sharedRunnable);
		
		thread1.start();
		
		thread2.start();
		
		thread1.join();
		
		thread2.join();
	}
}
