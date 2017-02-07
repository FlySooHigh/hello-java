package com.flysoohigh.xmlBankParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class AccountParser 
{
	private DocumentBuilder builder;
	private XPath path;
	
	public AccountParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		builder = dbfactory.newDocumentBuilder();
		
		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
	}
	
	public Bank parse(String fileName) throws SAXException, IOException, NumberFormatException, XPathExpressionException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		Bank bank = new Bank();
		
		int numberOfAccounts = Integer.parseInt(path.evaluate("count(/bank/account)", doc));
		for (int i = 1; i <= numberOfAccounts; i++)
		{
			int number = Integer.parseInt(path.evaluate("/bank/account[" + i + "]/number", doc));
			double balance = Double.parseDouble(path.evaluate("/bank/account[" + i + "]/balance", doc));
			Account account = new Account(number, balance);
			
			bank.addAccount(account);
		}
		
		return bank;
	}
}
