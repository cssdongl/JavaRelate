package org.ldong.java.design.pattern.structureMode.proxy;

public class Client {
	public static void main(String[] args) {
		Moveable m = new Tank();
		m.move();
	}
}
