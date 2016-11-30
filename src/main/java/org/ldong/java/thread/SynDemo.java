package org.ldong.java.thread;

public class SynDemo {
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		Thread myThread1 = new Thread(web,"ldong");
		Thread myThread2 = new Thread(web,"jinger");
		myThread1.start();
		myThread2.start();
	}
}
class Web12306 implements Runnable{
	private boolean flag = true;
	private int num = 50;
	
	public void run(){
		while(flag){
			test();
		}
	}
	public synchronized void test(){
		if(num <= 0){
			flag = false;
			return;
		}
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
}
