package org.ldong.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(4);
		MyCall tortoise = new MyCall("乌龟",1000);
		MyCall rabbit = new MyCall("兔子",500);
		Future re1 = service.submit(tortoise);
		Future re2 = service.submit(rabbit);
		Thread.sleep(2000);
		tortoise.setFlag(false);
		rabbit.setFlag(false);
		System.out.println("乌龟跑了"+re1);
		System.out.println("兔子跑了"+re2);
		service.shutdown();
	}
}
