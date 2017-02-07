package com.flysoohigh.numberConversion;

import java.util.Scanner;

public class DecimalsToRomans 
{
	public static String unitConverter(int remainder)
	{
		switch(remainder)
		{
			case 1: return "I";
			case 2: return "II";
			case 3: return "III";
			case 4: return "IV";
			case 5: return "V";
			case 6: return "VI";
			case 7: return "VII";
			case 8: return "VIII";
			case 9: return "IX";
			default: return "";
		}
	}
	
	public static String decimalConverter(int remainder)
	{
		switch(remainder)
		{
			case 1: return "X";
			case 2: return "XX";
			case 3: return "XXX";
			case 4: return "XL";
			case 5: return "L";
			case 6: return "LX";
			case 7: return "LXX";
			case 8: return "LXXX";
			case 9: return "XC";
			default: return "";
		}
	}
	
	public static String hundredsConverter(int remainder)
	{
		switch(remainder)
		{
			case 1: return "C";
			case 2: return "CC";
			case 3: return "CCC";
			case 4: return "CD";
			case 5: return "D";
			case 6: return "DC";
			case 7: return "DCC";
			case 8: return "DCCC";
			case 9: return "CM";
			default: return "";
		}
	}
	
	public static String thousandsConverter(int remainder)
	{
		switch(remainder)
		{
			case 1: return "M";
			case 2: return "MM";
			case 3: return "MMM";
			default: return "";
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter decimal number from 1 to 3999, -1 to quit: ");
		Scanner in = new Scanner(System.in);

		boolean done = false;
		while (!done && in.hasNextInt())
		{	
			Integer number = in.nextInt();
			if (number == -1)
			{
				done = true;
			}
			else
			{
				String result = "";
				int digitNumber = 1;
				int numberLength = number.toString().length();
				for (int i = 1; i <= numberLength; i++)
				{
					int remainder = number % 10;
					switch (digitNumber)
					{
						case 1: result = unitConverter(remainder); break;
						case 2: result = decimalConverter(remainder) + result; break;
						case 3: result = hundredsConverter(remainder) + result; break;
						case 4: result = thousandsConverter(remainder) + result; break;
					}
					number /= 10;
					digitNumber++;
				}
				System.out.println("Corresponding roman number is: " + result + "\n");
				System.out.println("Enter decimal number from 1 to 3999, -1 to quit: ");
			}
		}
		in.close();
	}
}
