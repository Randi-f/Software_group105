package UI.Component;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/13 22:48
 */

import UI.UIStyle;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;

public class IconLabel extends JLabel
{
    int width;
    int height;
    String title;
    URL imagePath;
    Color fontColor = null;
    public IconLabel(int width, int height, String title,int x, int y, URL imagePath, Color fontColor)
    {
        this(width,  height,  title,  x,  y,  imagePath);
        this.fontColor = fontColor;
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public IconLabel(int width, int height, String title, int x, int y, URL imagePath)
    {
        this.width = width;
        this.height = height;
        this.title = title;

        this.imagePath = imagePath;
        this.setBounds(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new HashMap<RenderingHints.Key, Object>()
        {{
            put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        }});
        super.paintComponent(g2);



//        g2.setPaint(Color.decode("#F6F6F8"));
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

//        g2.setPaint(fontColor);
//        if(fontColor == null) {
//            g2.setPaint(Color.BLACK);
//        }
//        else
//        {
//            g2.setPaint(fontColor);
//        }
        
        g2.setFont(UIStyle.NORMAL_FONT);
        if (title != null)
            g2.drawString(title, (int) (0.067 * width), (int) (0.6 * height));

        Image img = new ImageIcon(imagePath).getImage();
        g.drawImage(img, width*4 /5,1, (int)(getHeight() / 1.5), (int)(getHeight() / 1.5),null);// must set width andd height, otherwise it will not display it
    }
    protected void paintBorder(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setPaint(Color.decode("#F6F6F8"));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }
}

