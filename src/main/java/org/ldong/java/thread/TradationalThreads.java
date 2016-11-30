package org.ldong.java.thread;

public class TradationalThreads {
	public static void main(String[] args) {
		Thread myThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {

					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		myThread.start();
		
		Thread thread = new Thread(new Runnable(){
			
			public void run() {

				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {

					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		});
		thread.start();
	}
}
