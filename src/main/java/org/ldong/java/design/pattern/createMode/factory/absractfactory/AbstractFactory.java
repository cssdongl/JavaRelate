package org.ldong.java.design.pattern.createMode.factory.absractfactory;

public abstract class AbstractFactory {
	public abstract  Vehicle createVehicle();
	public abstract Weapon createWeapon();
	public abstract Food createFood();
}
