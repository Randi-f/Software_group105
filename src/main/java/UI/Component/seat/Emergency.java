package UI.Component.seat;

import UI.Component.JSeat;
import UI.SeatsPanel;
import UI.UIStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/29 09:16
 */
public class Emergency extends JSeat implements MouseListener {
    public Emergency(int x, int y, int w, int h, String type, int state, int Xm, int Ym) {
        super(x, y, w, h, type, state, Xm, Ym);
    }
    public Emergency(){
        this.addMouseListener(this);
        super.special="emergency";
    }
    @Override
    protected void paintComponent(Graphics g) {
        Image img;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        img =  new ImageIcon(UIStyle.emergencySeat).getImage();




        g2.drawImage(img, 0,0, (int)(getHeight()),(int)(getHeight()),null);// must set width and height, otherwise it will not display it
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        SeatsPanel.reminder.WRONG("It is emergency seat!,Please go to counter");
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SeatsPanel.reminder.WRONG("It is emergency seat!,Please go to counter");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
