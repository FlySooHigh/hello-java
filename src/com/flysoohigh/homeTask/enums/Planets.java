package com.flysoohigh.homeTask.enums;

import java.util.Scanner;

public class Planets 
{
	enum Planet
	{
		MARS(0.38, 227.9e6, 25),
		EARTH(1, 149.6e6, 24),
		JUPITER(2.34, 778.3e6, 10),
		NEPTUNE(1.19, 4.49e6, 16),
		URANUS(0.92, 2.87e6, 17),
		SATURN(1.06, 1.4e6, 11),
		MERCURY(0.38, 57.9e6, 1408),
		VENUS(0.91, 108.2e6, 5832);
		
		double weightMultiplier;
		double distanceFromSun;
		int daysLength;
		
		Planet(double weightMultiplier, double distanceFromSun, int daysLength)
		{
			this.weightMultiplier = weightMultiplier;
			this.distanceFromSun = distanceFromSun;
			this.daysLength = daysLength;
		}
		
		double getWeight(Planet planet, double weight)
		{
			return weight * planet.weightMultiplier;
		}
		
		void printWeight(Planet planet, double weight)
		{
			System.out.printf("Your weight on " + planet + " will be %.2f kg\n", planet.getWeight(planet, weight));
		}
		
		void printDistance(Planet planet)
		{
			System.out.println("Distance from " + planet + " to the Sun is " + planet.distanceFromSun + " km");
		}
		
		void printDayLength(Planet planet)
		{
			System.out.println("Length of day on " + planet + " is " + planet.daysLength + " hours");
		}
		
		void printFullInfo(Planet planet, double weight)
		{
			planet.printWeight(planet, weight);
			planet.printDistance(planet);
			planet.printDayLength(planet);
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter name of planet or q to quit: ");
		boolean done = false;
		Scanner in = new Scanner(System.in);
		while(!done && in.hasNext())
		{
			String input = in.next();
			if (input.equals("q"))
			{
				done = true;
			}
			else 
			{
				System.out.println("Enter your weight: ");
				double weight = in.nextDouble();

				switch(input)
				{
					case "MARS": 
					{
						Planet planet = Planet.MARS;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "EARTH": 
					{
						Planet planet = Planet.EARTH;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "JUPITER": 
					{
						Planet planet = Planet.JUPITER;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "NEPTUNE": 
					{
						Planet planet = Planet.NEPTUNE;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "URANUS": 
					{
						Planet planet = Planet.URANUS;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "SATURN": 
					{
						Planet planet = Planet.SATURN;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "MERCURY": 
					{
						Planet planet = Planet.MERCURY;
						planet.printFullInfo(planet, weight);
						break;
					}
					case "VENUS": 
					{
						Planet planet = Planet.VENUS;
						planet.printFullInfo(planet, weight);
						break;
					}
					default: System.out.println("Wrong planet name");
				}
				System.out.println("Enter name of planet or q to quit: ");
			}
		}
		in.close();
	}
}
