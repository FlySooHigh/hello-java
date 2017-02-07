package com.flysoohigh.xmlBankParser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class AccountParserDemo 
{
	public static void main(String[] args) throws ParserConfigurationException, NumberFormatException, 
												  XPathExpressionException, SAXException, IOException 
	{
		AccountParser ap = new AccountParser();	
		Bank bank = ap.parse("src/com/flysoohigh/xmlBankParser/bank.xml");
		System.out.println(bank.getTotalSum());
	}
}
