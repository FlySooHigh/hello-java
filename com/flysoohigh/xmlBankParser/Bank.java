package com.flysoohigh.xmlBankParser;

import java.util.ArrayList;

public class Bank 
{
	private ArrayList<Account> bank;
	
	public Bank()
	{
		bank = new ArrayList<>();
	}
	
	public double getTotalSum()
	{
		double result = 0;
		for (Account account : bank)
		{
			result += account.getBalance();
		}
		return result;
	}
	
	public void addAccount(Account account)
	{
		bank.add(account);
	}
}
