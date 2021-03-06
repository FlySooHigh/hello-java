package com.flysoohigh.twoCars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 A car shape that can be positioned anywhere on the screen.
 */
public class Car
{
	private int xLeft;
	private int yTop;
	private Color color;

	/**
 Constructs a car with a given top left corner.
 @param x the x-coordinate of the top-left corner
 @param y the y-coordinate of the top-left corner
	 */
	public Car(int x, int y, Color color)
	{
		xLeft = x;
		yTop = y;
		this.color = color;
	}

	/**
	  Draws the car.
	  @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		Rectangle body = new Rectangle(xLeft, yTop + 20, 120, 20);
		
		Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + 20, yTop + 40, 20, 20);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + 80, yTop + 40, 20, 20);

		Point2D.Double r1 = new Point2D.Double(xLeft + 20, yTop + 20);	// The bottom of the front windshield
		Point2D.Double r2 = new Point2D.Double(xLeft + 40, yTop);		// The front of the roof
		Point2D.Double r3 = new Point2D.Double(xLeft + 80, yTop);		// The rear of the roof
		Point2D.Double r4 = new Point2D.Double(xLeft + 100, yTop + 20);		// The bottom of the rear windshield

		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

		g2.setColor(color);
		g2.fill(body);
		g2.setColor(Color.BLACK);
		g2.fill(frontTire);
		g2.fill(rearTire);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	}
}
