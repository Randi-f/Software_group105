package UI.Component.seat;

import UI.Component.JSeat;
import UI.SeatsPanel;
import UI.UIStyle;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/29 13:36
 */
public class Window extends JSeat implements MouseListener {
    public Window(int x, int y, int w, int h, String type, int state, int Xm, int Ym) {
        super(x, y, w, h, type, state, Xm, Ym);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Image img;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        img = new ImageIcon(UIStyle.windowSeat).getImage();

        g2.drawImage(img, 0, 0, (int) (getHeight()), (int) (getHeight()), null);// must set width and height, otherwise it will not display it
    }
    public Window(){

        this.addMouseListener(this);
        super.special="window";
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(state==0){
            state=2;
            SeatsPanel.reminder.popup("It needs extra pay", Color.yellow);
            if(SeatsController.getController().changeJSeat(this)){
                SeatsController.getController().setCost("window");
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
