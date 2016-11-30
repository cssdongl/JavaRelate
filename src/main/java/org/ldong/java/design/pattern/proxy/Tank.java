package org.ldong.java.design.pattern.proxy;

import java.util.Random;

public class Tank implements Moveable{

	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank moving...");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end -start);
	}

}
