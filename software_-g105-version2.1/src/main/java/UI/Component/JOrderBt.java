package UI.Component;

import UI.UIStyle;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/9 18:02
 */
public class JOrderBt extends JButton {
    int num;String name;
    int W=100,H=50;
    public JOrderBt(String name,int num,int x,int y){
        this.setBounds(x,y,W,H);
        this.name=name;this.num=num;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        g2.setPaint(Color.decode("#6C7089"));
        g2.setFont(UIStyle.TINY_FONT);
        g2.drawString(name,0,0);

        g2.setPaint(Color.BLACK);
        g2.setFont(UIStyle.NORMAL_FONT);
        g2.drawString(num+"",0,H/2);


//        g2.drawString(name);

    }

}
