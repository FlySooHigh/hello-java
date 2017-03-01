package com.flysoohigh.homeTask.polymorphism;

public class Polymorphism 
{
	public static void main(String[] args) 
	{
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Car();
		Vehicle v3 = new Truck();
		applyAction(v1);
		applyAction(v2);
		applyAction(v3);
	}
	
	public static void applyAction(Vehicle v)
	{
		v.action();
	}
}

class Vehicle
{
	public void action()
	{
		System.out.println("Vehicle");
	}
}

class Car extends Vehicle
{
	@Override
	public void action()
	{
		System.out.println("Car");
	}
}

class Truck extends Vehicle
{
	@Override
	public void action()
	{
		System.out.println("Truck");
	}
}

