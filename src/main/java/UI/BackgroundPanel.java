package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Add background image to any panels
 * @version 1.0
 */

public class BackgroundPanel extends JPanel{
	  private static final long serialVersionUID = -6352788025440244338L;
	    private Image image = null;
	    public BackgroundPanel(Image image) {
	        this.image = image;

	    }
	    protected void paintComponent(Graphics g) {
	        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	    }

}