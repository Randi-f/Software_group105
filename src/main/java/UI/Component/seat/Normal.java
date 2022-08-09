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
 * @date: 2022/5/29 10:25
 */
public class Normal extends JSeat implements MouseListener {

    public Normal(int x, int y, int w, int h, String type, int state, int Xm, int Ym) {
        super(x, y, w, h, type, state, Xm, Ym);
    }
    public Normal(){
        this.addMouseListener(this);
        super.special="normal";
    }
    @Override
    protected void paintComponent(Graphics g) {
        Image img;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        if (this.state == 0) {
            img= new ImageIcon(UIStyle.seatOK).getImage();
        }else  if(this.state==1){
            img = new ImageIcon(UIStyle.seatNo).getImage();
        }else img = new ImageIcon(UIStyle.chosenSeat).getImage();

        g2.drawImage(img, 0, 0, (int) (getHeight()), (int) (getHeight()), null);// must set width and height, otherwise it will not display it
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println(54654);
//        if(state!=1){
//            state=2;
//            if(SeatsController.getController().changeJSeat(this)){
//                SeatsController.getController().setCost();
//            }
//            this.repaint();
//            SeatsController.getController().setSeatShowTxt();
//        }
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(state==0){
            state=2;
            if(SeatsController.getController().changeJSeat(this)){
                SeatsController.getController().setCost();
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
