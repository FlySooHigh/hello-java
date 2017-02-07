package com.flysoohigh.twoCars;

import javax.swing.JFrame;

public class CarViewer {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Two cars");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CarComponent component = new CarComponent();
		frame.add(component);
		frame.setVisible(true);
	}

}
