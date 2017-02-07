package com.flysoohigh.flowerGraph;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class GraphRose 
{
	private double xCenter;
	private double yCenter;
	private double thetaMin;
	private double thetaMax;
	
	public GraphRose(double xCenter, double yCenter, double thetaMin, double thetaMax) 
	{
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.thetaMin = thetaMin;
		this.thetaMax = thetaMax;
	}
	
	public void draw(Graphics2D g2)
	{
		final int MAGNIFIER = 250;
		double step = (thetaMax - thetaMin) / 100;
		
		double theta = thetaMin;
		
		double r = Math.cos(2 * theta);
		double x = r * Math.cos(theta);
		double y = r * Math.sin(theta);
		Point2D.Double firstPoint = new Point2D.Double(xCenter + x * MAGNIFIER, yCenter + y * MAGNIFIER);
		theta += step;
		
		while (theta <= thetaMax)
		{
			r = Math.cos(2 * theta);
			x = r * Math.cos(theta);
			y = r * Math.sin(theta);
			Point2D.Double nextPoint = new Point2D.Double(xCenter + x * MAGNIFIER, yCenter + y * MAGNIFIER);
			Line2D.Double line = new Line2D.Double(firstPoint, nextPoint);
			
			if ( (theta >= 0 && theta < 2.0 / 4 * Math.PI))
			{
				g2.setColor(Color.MAGENTA);
			}
			else if ( (theta >= 2.0 / 4 * Math.PI && theta < 4.0 / 4 * Math.PI))
			{
				g2.setColor(Color.GREEN);
			}
			else if (theta >= 4.0 / 4 * Math.PI && theta < 6.0 / 4 * Math.PI)
			{
				g2.setColor(Color.YELLOW);
			}
			else 
			{
				g2.setColor(Color.RED);
			}
			
			g2.draw(line);
			firstPoint = nextPoint;
			theta += step;
		}
	}
}
