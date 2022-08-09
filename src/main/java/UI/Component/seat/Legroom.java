package UI.Component.seat;

import UI.Component.JSeat;
import UI.SeatsPanel;
import UI.UIStyle;
import controller.SeatsController;

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
public class Legroom extends JSeat implements MouseListener {

    public Legroom(int x, int y, int w, int h, String type, int state, int Xm, int Ym) {
        super(x, y, w, h, type, state, Xm, Ym);
    }
    public Legroom(){
        this.addMouseListener(this);
        super.special="legroom";
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image img;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        if (this.state == 0) {
            img = new ImageIcon(UIStyle.seatLegroom).getImage();
        } else if (this.state == 1) {
            img = new ImageIcon(UIStyle.seatLegroomNo).getImage();
        } else img = new ImageIcon(UIStyle.chosenSeat).getImage();
        g2.drawImage(img, 0, 0, (int) (getHeight()), (int) (getHeight()), null);// must set width and height, otherwise it will not display it
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(state==0){
            SeatsPanel.reminder.popup("It needs extra pay", Color.yellow);
            state=2;
            if(SeatsController.getController().changeJSeat(this)){
                SeatsController.getController().setCost("legroom");
            }
            this.repaint();
            SeatsController.getController().setSeatShowTxt();
        }else if(state==1)  SeatsPanel.reminder.WRONG("seat unavailable");
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
