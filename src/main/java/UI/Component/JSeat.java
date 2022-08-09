package UI.Component;

import UI.SeatsPanel;
import UI.UIStyle;
import backend.dataIO.DataManager;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JSeat extends JLabel {
    protected String type;
    protected int x;
    protected int y;
    protected int state,w,h;
    protected int Xm,Ym;
    public String special="";
    public JSeat(){

}
public void fillSeat(int x, int y, int w, int h, String type,int state, int Xm, int Ym){
    this.type=type;
    this.state=state;
    this.x=x;this.w=w;
    this.y=y;this.h=h;
    this.setBounds(x,y,w,h);
    this.Xm=Xm;this.Ym=Ym;
}
    public JSeat(int x, int y, int w, int h, String type,int state, int Xm, int Ym){
        this.type=type;
        this.state=state;
        this.x=x;this.w=w;
        this.y=y;this.h=h;
        this.setBounds(x,y,w,h);
        this.Xm=Xm;this.Ym=Ym;
//        getSpecial();

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

//    public void getSpecial(){
//        if(type.equals("economy")){  special=SeatsController.getController().getExtraSeatType(Xm,Ym);}
//        else special="normal";
//    }
    @Override
    protected void paintComponent(Graphics g) {

    }



    //    protected void paintBorder(Graphics g)
//    {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setStroke(new BasicStroke(3));
//        g2.setPaint(Color.decode("#F6F6F8"));
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
//    }



}
