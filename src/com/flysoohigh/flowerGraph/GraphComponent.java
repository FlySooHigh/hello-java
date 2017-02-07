package com.flysoohigh.flowerGraph;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GraphComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		GraphRose graphRose = new GraphRose(325, 325, 0, 2 * Math.PI);
		
		graphRose.draw(g2);
	}
}
