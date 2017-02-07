package com.flysoohigh.populationDensity;

/**
   Describes a value that is associated with a country
*/
public class CountryValue
{
   private String country;
   private double value;
   
   public CountryValue(String line)
   {
      int i = 0; 											// find the start of the first digit
      while (!Character.isDigit(line.charAt(i))) { i++; }
      
      int j = i - 1; 										// find the end of the preceding word
      while (Character.isWhitespace(line.charAt(j))) { j--; }     
      
      country = line.substring(0, j + 1); 					// get the country name
      value = Double.parseDouble(line.substring(i).trim()); // get the value
   }

   public String getCountry() { return country; }

   public double getValue() { return value; }
}
