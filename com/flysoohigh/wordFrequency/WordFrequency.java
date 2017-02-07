package com.flysoohigh.wordFrequency;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

public class WordFrequency
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Map<String, Integer> frequencies = new TreeMap<String, Integer>();
      Scanner in = new Scanner(new File("src/com/flysoohigh/wordFrequency/alice30.txt"));
      while (in.hasNext())
      {
         String word = clean(in.next());    

         Integer count = frequencies.get(word);			// Get the old frequency count

         if (count == null) { count = 1; }		        // If there was nothing, put 1; otherwise, increment the count
         else { count = count + 1; }        

         frequencies.put(word, count);
      }

      for (String key : frequencies.keySet())			      // Print all words and counts
      {
         System.out.printf("%-20s%10d\n", key, frequencies.get(key));
      }
      
      in.close();
   }

   public static String clean(String s)
   {
      String r = "";
      for (int i = 0; i < s.length(); i++)
      {
         char c = s.charAt(i);
         if (Character.isLetter(c))
         {
            r = r + c;
         }
      }
      return r.toLowerCase();
   }
}
