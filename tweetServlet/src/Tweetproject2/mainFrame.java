package Tweetproject2;
//Seth DeWalt
//This code is to create an editor for a text list

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class mainFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("New Advanced Tweet Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setting size
		frame.setSize(800, 500);
		//not allowing the panel to resize
		frame.setResizable(false);
		//adding main to the pnel
		frame.getContentPane().add(new mainPanel());
		frame.pack();
		frame.setVisible(true);
		imagePanel panel = new imagePanel(
		new ImageIcon("./sentimentanalysis/spooky.jpg").getImage());
		//adding image panel
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
}
