package org.ldong.java.design.pattern.factory;

public class Test {
	public static void main(String[] args) {
		Car c = Car.getInstance();
		c.run();
		PlaneFactory factory = new PlaneFactory();
		Moveable m = factory.createPlane();
	}
}
