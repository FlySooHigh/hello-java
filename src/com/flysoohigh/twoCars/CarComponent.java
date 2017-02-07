package com.flysoohigh.twoCars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
This component draws two car shapes.
 */
public class CarComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Car car1 = new Car(0, 0, Color.BLUE);

		int x = getWidth() - 120;
		int y = getHeight() - 60;

		Car car2 = new Car(x, y, Color.MAGENTA);

		car1.draw(g2);
		car2.draw(g2);
	}
}