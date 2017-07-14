package org.ldong.java.design.pattern.createMode.factory;

public class CarFactory extends VehicleFactory{

	@Override
	Moveable create() {
		// TODO Auto-generated method stub
		return new Car();
	}

}
