package com.flysoohigh.flowerGraph;

import javax.swing.JFrame;

public class GraphViewer {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Graph");
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GraphComponent component = new GraphComponent();
		frame.add(component);
		frame.setVisible(true);
	}

}
