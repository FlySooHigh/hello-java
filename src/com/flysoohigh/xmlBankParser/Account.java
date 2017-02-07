package com.flysoohigh.xmlBankParser;

public class Account 
{
	private int number;
	private double balance;
	
	public Account(int aNumber, double aBalance)
	{
		this.number = aNumber;
		this.balance = aBalance;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
}
