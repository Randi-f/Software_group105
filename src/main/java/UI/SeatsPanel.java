package UI;

import UI.Component.*;
import controller.BookingController;
import controller.FlightController;
import controller.SeatsController;
import entity.Booking;
import entity.Plane;
import utils.XMLUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.util.ArrayList;

public class SeatsPanel extends JPanel {

    int X_OFFSET = 5;
    int Y_OFFSET = 5;

    int firstRow=4,firstCol=4;
    int clubRow=6,clubCol=6;
//    JLabel economyLabel=new JLabel("Economy");
//    JLabel clubLabel=new JLabel("Club");
//    JLabel firstLabel=new JLabel("First");
    int classLabelX=10,classLabelW=100,classLabelH=30;


    int econSeatSize=35,clubSeatSize=40,firSeatSize=45;
    JPanel firstPanel, clubPanel,economyPanel;
    JPanel fixEconOuter, fixFirP, fixClubP;
    int ecoArea ,clubArea, firArea;//the area of one seat
    int passageSpace = 20,lineSpace=1;

    Plane plane= null;


    JScrollPane econScroller;
    int fixEconOuterWidth,fixEconOuterHeight;
    int econClassWidth,econClassHeight;
    int clubClassWidth,clubClassHeight;
    int firClassWidth,firClassHeight;

    int econClassX,econClassY;




    CardLayout cards = new CardLayout();
    String currentClass="";
    public JPanel contentP = new JPanel(cards);
    public ArrayList<JSeat> jseats =new ArrayList<>();
//    /**
//     *   make the panel inside the scroller get its size so that
//     *   the scroller can play a role
//     */
//    public void expandClassPanel(JPanel panel,int row,int col,int size, Color color,String type){
//
//    }
    /**
     * arrange every JSeat component on the class board
     * @return byproduct-number of column
     */
    public void arrangeClassSeat(JPanel panel,int size,int row,ArrayList<Integer> col,String type,Color color){
        int blockCol=0,Col=0,x=0,state=0;
        int i=0,itemX=0,itemY=0;
        for (i = 0; i < col.size(); i++) {
            blockCol=col.get(i);
            Col=blockCol+Col;
        }
        int width=Col * size + passageSpace*col.size()-1;
        int height=row * size + lineSpace*(row-1)+100;
        if(type.equals("economy")){
            econClassWidth=width;
            econClassHeight=height;
//            fixEconOuterWidth=width+10;
//            fixEconOuterHeight=height;
        }
        else if(type.equals("club")){
            clubClassWidth=width;
            clubClassHeight=height;
        }else if(type.equals("first")){
            firClassWidth=width;
            firClassHeight=height;
        }
        panel.setPreferredSize(new Dimension(width,height));
        panel.setBackground(color);
//        expandClassPanel(panel,row,Col,econSeatSize,Color.WHITE,type);
        boolean paintY=false;
        for (i = 0; i < col.size(); i++) {
            blockCol=col.get(i);
            Col=blockCol+Col;
            for (int c = 0; c < blockCol; c++) {
                itemX=x*size+i*passageSpace+(fixEconOuterWidth-width)/2+size/2;
                for (int r = 0; r <row ; r++) {
                    state=SeatsController.getController().getBoard(type)[r][x];
                    itemY=r*size+size+Y_OFFSET;
                    String special="normal";
                    if(type.equals("economy")) special =SeatsController.getController().getExtraSeatType(r+1,x+1,type);
                    JSeat j=(JSeat) XMLUtils.getBean(special);
//                    JSeat j = new JSeat(itemX,itemY,size,size,type,state,r+1,x+1);,itemX,itemY,size,size,type,state,r+1,x+1
                    j.fillSeat(itemX,itemY,size,size,type,state,r+1,x+1);
                    jseats.add((JSeat) j);panel.add((JSeat)j);
                    if(!paintY){
                        JLabel axisY=new JLabel(r+1+"");//
                        axisY.setBounds(itemX-size,itemY,size,size);
                        panel.add(axisY);
                    }
                }
                JLabel axisX=new JLabel(String.valueOf((char)("A".getBytes()[0]+x)));//
                axisX.setBounds(itemX+10,2,size,size);
                panel.add(axisX);
                paintY=true;
                x=x+1;

            }
        }

    }

    public boolean changeCard(String type){
        if(!type.equals(currentClass)){
            if(currentClass.equals("")){//initial
                cards.show(contentP,type);
                currentClass=type;
                return true;
            }
            else{
                Booking bk=BookingController.getController().getBooking();
                if(bk.getSeat().getType().equals(type)){
                    cards.show(contentP,type);
                    currentClass=type;
                    return true;
                }
                if(SeatsController.getController().checkFullSeat(type)!=null){
                    int  jPrice=SeatsController.getController().classPrice.get(type);
                    int  bkPrice=SeatsController.getController().classPrice.get(bk.getSeat().getType());
                    System.out.println("default Seat : "+currentClass+bkPrice+"->"+jPrice);
                    if(jPrice>bkPrice){
                        SeatsPanel.reminder.popup(type+" class is available right now!",Color.GREEN);
                        SeatsController.getController().setCost(jPrice-bkPrice);
                        cards.show(contentP,type);
                        currentClass=type;
                        return true;
                    }else{
                        SeatsPanel.reminder.WRONG("Lower class unavailable");
                    }//            if(currentClass.equals("economy") && (type.equals("club") || type.equals("first"))){
                }
                else {
                    SeatsPanel.reminder.WRONG(type+" class is unavailable right now!");
                }
            }
        }
        return false;

    }


    public void setContent(){

        fixEconOuter=new JPanel(new BorderLayout(0, 0));//limit the height of scroller
        fixFirP=new JPanel(new BorderLayout(0, 0));
        fixClubP=new JPanel(new BorderLayout(0, 0));
        SeatsController.getController().setSeatsPanel(this);
        try {
            plane = SeatsController.getController().getPlaneById(FlightController.getFlight().plane);
            SeatsController.getController().loadBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }

            economyPanel=new JPanel(null);
            arrangeClassSeat(economyPanel,econSeatSize,plane.getEconRow(),plane.getEconCol(),"economy",Color.WHITE);
            econScroller = new JScrollPane(economyPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            fixEconOuter.add(econScroller,BorderLayout.CENTER);

            clubPanel=new JPanel(null);
            arrangeClassSeat(clubPanel,clubSeatSize,plane.getClubRow(),plane.getClubCol(),"club",Color.WHITE);
//        expandClassPanel(clubPanel,plane.getClubRow(),Col,clubSeatSize,Color.WHITE,"club");
            fixClubP.add(clubPanel);
//        clubPanel.add(new Button("1313"));

            firstPanel=new JPanel(null);
            arrangeClassSeat(firstPanel,firSeatSize,plane.getFirRow(),plane.getFirCol(), "first",Color.WHITE);
//          expandClassPanel(firstPanel,plane.getFirRow(),Col,firSeatSize,Color.WHITE,"first");
            fixFirP.add(firstPanel);


//        this.computePanel(clubPanel,clubRow,clubCol,clubSeatSize,Color.WHITE);
//        clubPanel=makeClassPanel(econSeatSize,economyRow,economyCol,economyOK,economyNO,econRoom);
//        econClass = new classRoom(econSeatSize,economyRow,economyCol,economyOK,economyNO,econRoom);
//        economyPanel.add(econClass);
//        fixFirP.setBounds((UIStyle.flightGraphWidth-firClassWidth)/2,Y_OFFSET,firClassWidth,firClassHeight);
//        fixClubP.setBounds((UIStyle.flightGraphWidth-clubClassWidth)/2,Y_OFFSET+firClassHeight,clubClassWidth,clubClassHeight);
//        fixEconOuter.setBounds((UIStyle.flightGraphWidth-fixEconOuterWidth)/2,Y_OFFSET+firClassHeight+clubClassHeight,fixEconOuterWidth,fixEconOuterHeight);

//        this.add(fixFirP);
//        this.add(fixClubP);
        contentP.add("economy",fixEconOuter);
        contentP.add("club",fixClubP);
        contentP.add("first",fixFirP);
//        economyLabel.setBounds(classLabelX,((firClassHeight+clubClassHeight)/2)+Y_OFFSET,classLabelW,classLabelH);
//        this.add(economyLabel);

        SeatsController.getController().setDefault();
        currentClass=BookingController.getController().getBooking().getSeat().getType();

    }
    public static  MyReminder reminder;
    public SeatsPanel(int w,int h)  {
        reminder=new MyReminder(this);
        fixEconOuterWidth=w;fixEconOuterHeight=h;
        this.add(contentP);

    }




//        else if(e.getSource()==nextB){
//
//            jump2("Flight");
//        }
    }


