package Tweetproject2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
//creating panel to display the image of in the file
class imagePanel extends JPanel {
	  private Image img;
	  
	  public imagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }
	  //setting the dimensions of the panel
	  public imagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(new Dimension(856, 630));
	    setLayout(null);
	  }
	  //drawing image
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
	  
	  
}