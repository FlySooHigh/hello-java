package chapter24_XML.section3.R24_12;

import java.util.ArrayList;

import chapter24_XML.section3.LineItem;
import chapter24_XML.section3.Product;

public class HarryHopeless 
{
	public static void main(String[] args) 
	{

		ArrayList<LineItem> items = new ArrayList<LineItem>();
		items.add(new LineItem(new Product("Toaster", 29.95), 3));
		items.add(new LineItem(new Product("Hair dryer", 24.95), 1));
		
		System.out.println("<?xml version=\"1.0\"?><items>");
		
		for (LineItem anItem: items)
		{
			Product p = anItem.getProduct();
			System.out.println("<item><product><description>" + p.getDescription()
			+ "</description><price>" + p.getPrice()
			+ "</price></product><quantity>" + anItem.getQuantity()
			+ "</quantity></item>");
		}
		System.out.println("</items>");
	}
}
