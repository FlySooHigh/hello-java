package com.flysoohigh.homeTask.enums;



public class EnumExample 
{
	enum Season			// extends only Enum
	{
		SPRING(5), 		// instances
		SUMMER(10), 
		FALL(15), 
		WINTER(20);

		int value;

		private Season(int value)
		{
			this.value = value;
		}

	}

	public static void main(String[] args) 
	{
		Season s = Season.SPRING;

		switch (s)
		{
			case WINTER: System.out.println("W"); break;
			default : System.out.println("D"); break;
		}

		System.out.println(s);

		for (Season season : Season.values())
		{
			System.out.printf("%-10s%5d\n", season, season.value);
		}
	}
}
