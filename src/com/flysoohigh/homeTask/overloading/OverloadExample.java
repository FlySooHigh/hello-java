package com.flysoohigh.homeTask.overloading;

public class OverloadExample 
{
	private int counter = 0;
	
	double add(double number)
	{
		counter += number;
		return counter;
	}
	
	double add(int number)
	{
		counter += number;
		return counter;
	}
	
	double add(byte number)
	{
		counter += number;
		return counter;
	}
	
	double add(short number)
	{
		counter += number;
		return counter;
	}
	
	double add(String number)
	{
		counter += Integer.parseInt(number);
		return counter;
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public static void main(String[] args) 
	{
		OverloadExample oe = new OverloadExample();
		System.out.println(oe.getCounter());
		System.out.println(oe.add(7.0));
		System.out.println(oe.add(3));
		byte b = 3;
		System.out.println(oe.add(b));
		short sh = 130;
		System.out.println(oe.add(sh));		
		System.out.println(oe.add("5"));
	}
}
