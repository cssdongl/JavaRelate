package org.ldong.java.thread;

public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();

	}

	private void init() {
		final Outputer outer = new Outputer();
		Thread thread1 = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					outer.output("dongliang");
				}
			}
		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					outer.output("huangjing");
				}
			}

		});
		thread2.start();
	}

	class Outputer {

		private void output(String name) {

			int len = name.length();
			synchronized (this) {
				for (int i = 0; i < len; i++) {

					System.out.print(name.charAt(i));

				}
				System.out.println();
			}
		}
	}
}
