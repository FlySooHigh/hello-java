package com.flysoohigh.numberConversion;

import java.util.Scanner;

public class RomansToDecimals 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Roman number from I to MMMCMXCIX (1 to 3999), q to quit: ");
		Scanner in = new Scanner(System.in);

		boolean done = false;
		while (!done && in.hasNext())
		{	
			String number = in.next();
			if (number.equals("q"))
			{
				done = true;
			}
			else
			{
				int result = 0;
				char[] array = number.toCharArray();

				for (int i = number.length() - 1; i >= 0; i--)		// read from right to left
				{
					switch (array[i])
					{
					case 'I': 
							result += 1;   
							break;
					case 'X': 
							if (i != 0 && array[i-1] == 'I')	//IX = 9
							{ 
								result += 9;
								i--;							// if we find a combination like IX, then skip the next value,
																// so that we don't count it twice
							} 
							else
							{
								result += 10;
							}
							break;
					case 'C': 
							if (i != 0 && array[i-1] == 'X')	//XC = 90
							{ 
								result += 90;
								i--;
							} 
							else
							{
								result += 100;
							}
							break;
					case 'M': 
							if (i != 0 && array[i-1] == 'C')	//CM = 900
							{ 
								result += 900;
								i--;
							} 
							else
							{
								result += 1000;
							}
							break;
					case 'V': 
							if (i != 0 && array[i-1] == 'I') 	//IV = 4 
							{ 
								result += 4;
								i--;
							} 
							else
							{
								result += 5;
							}
							break;
					case 'L':
							if (i != 0 && array[i-1] == 'X')	//XL = 40 
							{ 
								result += 40;
								i--;
							} 
							else
							{
								result += 50;
							}
							break;
					case 'D': 
							if (i != 0 && array[i-1] == 'C')	//CD = 400
							{ 
								result += 400;
								i--;
							} 
							else
							{
								result += 500;
							}
							break;	
					default:
							System.out.println("Not correct Roman number");
							break;
					}
				}
				System.out.println("Corresponding decimal number is: " + result + "\n");
				System.out.println("Enter Roman number from I to MMMCMXCIX (1 to 3999), q to quit: ");
			}
		}
		in.close();
	}
}
