package com.flysoohigh.wordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File inputFile = new File("src/com/flysoohigh/wordCounter/alphabet.txt");
		
		Scanner sc = new Scanner(inputFile);
		
		int numberOfWords = 0;
		int numberOfCharacters = 0;
		int numberOfLines = 0;
		
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			numberOfLines++;
			
			Scanner lineSc = new Scanner(line);
			lineSc.useDelimiter("[^A-Za-z]+");
			while (lineSc.hasNext())
			{
				String word = lineSc.next();
				numberOfWords++;
				numberOfCharacters += word.length();
			}
			
			lineSc.close();
		}
		
		System.out.println("Number of lines: " + numberOfLines);
		System.out.println("Number of words: " + numberOfWords);
		System.out.println("Number of characters: " + numberOfCharacters);
		
		sc.close();
	}
}
