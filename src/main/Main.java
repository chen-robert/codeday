package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]) {
		JFrame frame = new JFrame("Derp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board b = new Board(frame);
		b.setPreferredSize(new Dimension(500,500));
		
		frame.add(b);
		frame.pack();
		frame.setVisible(true);		
	}
}
