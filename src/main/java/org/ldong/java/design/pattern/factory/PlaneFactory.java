package org.ldong.java.design.pattern.factory;

public class PlaneFactory extends VehicleFactory{
	public Plane createPlane(){
		return new Plane();
	}

	@Override
	public Moveable create() {
		return new Plane();
	}
}
