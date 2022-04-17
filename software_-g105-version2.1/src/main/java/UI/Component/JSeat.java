package UI.Component;

import UI.UIStyle;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JSeat extends JLabel {
    protected String type;
    protected int x;
    protected int y;
    protected int state,w,h;
    protected int Xm,Ym;
    private SeatsController controller;


    public JSeat(int x, int y, int w, int h, String type, int state, int Xm, int Ym){
        this.type=type;
        this.state=state;
        this.x=x;this.w=w;
        this.y=y;this.h=h;
        this.setBounds(x,y,w,h);
        this.Xm=Xm;this.Ym=Ym;
        Listener l = new Listener(type,this);
        this.addMouseListener(l);


    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public int getXm() {
        return Xm;
    }

    public int getYm() {
        return Ym;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image img;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        if(this.state==0){  img= new ImageIcon(UIStyle.economyOK).getImage();}
       else  img = new ImageIcon(UIStyle.economyNo).getImage();
        g2.drawImage(img, 0,0, (int)(getHeight()),(int)(getHeight()),null);// must set width and height, otherwise it will not display it
    }
//    protected void paintBorder(Graphics g)
//    {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setStroke(new BasicStroke(3));
//        g2.setPaint(Color.decode("#F6F6F8"));
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
//    }
    private class Listener implements MouseListener {
        String type;
        JSeat jSeat;
        public Listener(String type, JSeat jSeat){
            this.type=type;this.jSeat = jSeat;

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            jSeat.state=1;

            if(SeatsController.getController().getJSeat()==null){
                SeatsController.getController().setJSeat(jSeat);
            }else if(SeatsController.getController().getJSeat()!= jSeat){
                SeatsController.getController().getJSeat().setState(0);
                SeatsController.getController().getJSeat().repaint();
                SeatsController.getController().setJSeat(jSeat);
            }else {}
            jSeat.repaint();
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

}
