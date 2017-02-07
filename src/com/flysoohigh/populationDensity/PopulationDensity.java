package com.flysoohigh.populationDensity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PopulationDensity
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner in1 = new Scanner(new File("src/com/flysoohigh/populationDensity/worldpop.txt")); 
      Scanner in2 = new Scanner(new File("src/com/flysoohigh/populationDensity/worldarea.txt"));

      PrintWriter out = new PrintWriter("src/com/flysoohigh/populationDensity/world_pop_density.txt"); 

      while (in1.hasNextLine() && in2.hasNextLine())
      {
         CountryValue population = new CountryValue(in1.nextLine());
         CountryValue area = new CountryValue(in2.nextLine());

         double density = 0;
         if (area.getValue() != 0) 				// protection against division by zero
         {
            density = population.getValue() / area.getValue();
         }
         out.printf("%-40s%15.2f\n", population.getCountry(), density);
      }

      in1.close();
      in2.close();
      out.close();
   }
}
