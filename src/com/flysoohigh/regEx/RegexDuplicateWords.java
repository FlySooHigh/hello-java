package com.flysoohigh.regEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateWords 
{
	public static void main(String[] args) 
	{
		String regex = "\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		Scanner in = new Scanner("Sam sam samsam went wEnt weNt to to gym gym");

		String input = in.nextLine();
		System.out.println(input.length());

		Matcher m = p.matcher(input);

		while (m.find()) 
		{
			System.out.print(m.group() + "| " + m.group().length() + "\n");
//			input = input.replaceAll("(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+", "$1");
			input = input.replaceAll(m.group(), m.group(1));
		}

		System.out.println(input);
		in.close();
	}
}
