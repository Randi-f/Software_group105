package UI;



import UI.Component.*;
import UI.Component.IconLabel;
import controller.FlightController;
import controller.SeatsController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SeatChoicePanel extends JPanel implements ActionListener{

    SeatsPanel planeSeats ;
    JPanel iconPanel;

    int markNum;
    int iconW=200,iconH=40;

    int fixEconOuterWidth=500,fixEconOuterHeight=350;

    public static FilterBox classFilter;
    int clsFilterW=350,cfH=40,cfY=80;
    int margin=10;
    int seatsY=cfH+cfY+margin;
    int xShow= 20,yShow=10;
    int hShow=40,wShow=150;
    private JPanel outerP;
    JPanel showSeatP=new JPanel();
    JPanel totalPane;
    private JLabel titleLb=new JLabel();
    public static JButton confirm=new JButton("CONFIRM");;
    
    FontMetrics mt;
    public SeatChoicePanel() throws Exception {
//        this.cards=cards;CardLayout cards,String name, JPanel contentPanel
//        this.contentPanel=contentPanel;

//        contentPanel.add(name,outerP);
        titleLb.setText("Please Choose A Seat");
        titleLb.setFont(new Font("Arial",Font.PLAIN,33));
        titleLb.setForeground(Color.black);
        titleLb.setBounds(10,10,600,50);
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        outerP = new BackgroundPanel(image1);
        outerP.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());
        this.add(outerP,BorderLayout.CENTER);
        outerP.setBorder(new EmptyBorder(12, 12, 12, 12));
        planeSeats=new SeatsPanel(fixEconOuterWidth,fixEconOuterHeight);
        planeSeats.setBounds(0,0,UIStyle.contentW,UIStyle.flightGraphHeight);
        planeSeats.setOpaque(false);
        SeatsController.getController().setSeatsPanel(planeSeats);
        outerP.add(planeSeats,BorderLayout.CENTER);

        arrangeLabel();

        arrangeShowPanel();
        arrangeBill();
        String[] classes = {"class","economy","club","first"};
        classFilter=new FilterBox((UIStyle.contentW-clsFilterW)/2,cfY,clsFilterW,cfH,classes,"dark",true);
        planeSeats.add(classFilter);
        planeSeats.add(iconPanel);


        iconPanel.setBounds(15,seatsY+(fixEconOuterHeight-iconH*5)/2,iconW,iconH*5);
        planeSeats.contentP.setBounds((UIStyle.contentW-fixEconOuterWidth)/2,seatsY,fixEconOuterWidth,fixEconOuterHeight);
        showSeatP.setBounds((UIStyle.contentW+fixEconOuterWidth)/2+20,seatsY+(fixEconOuterHeight-iconH*5)/2,iconW-40,iconH*5);
        totalPane.setBounds((UIStyle.contentW-UIStyle.billW)/2,seatsY+fixEconOuterHeight+4*margin,UIStyle.billW,UIStyle.billH);

        instrButton.setText("Instructions");
        instrButton.setFont(UIStyle.TINY_ARIAL_BOLD);
        instrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instr(e);
            }
        });
        instrButton.setIcon(new ImageIcon(UIStyle.instr));
        instrButton.setContentAreaFilled(false);
        instrButton.setBounds(750,10,150,50);
        planeSeats.add(instrButton);
        planeSeats.add(titleLb);
//
    }
    private void Instr(ActionEvent e){
        JOptionPane.showMessageDialog(null, " Please select the tickets you want to print and then click the Next button." +
                " You can click the Preview button to view the ticket preview ", " Instruction", JOptionPane.INFORMATION_MESSAGE);
    }
    private JButton instrButton=new JButton();

    public void arrangeBill(){
        totalPane=new BillMini(1);
        confirm.setFont(UIStyle.TINY_ARIAL_BOLD);
        confirm.addActionListener(this);

        planeSeats.setLayout(null);
        planeSeats.add(totalPane);
        planeSeats.add(confirm);
//        confirm.setBounds(billX,130+fixEconOuterHeight+UIStyle.billW,UIStyle.billW,30);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            try {
                FlightController.getController().updateSeatOnFlight(SeatsController.getController().getSeat());
                MenuBar.getController().confirmPage("SeatChoice", "FoodChoice");
                BottomBar.getController().setConfirmPage("FoodChoice",FoodChoicePanel.confirm);
//                    FlightController.getController().updateSeatOnFlight(SeatsController.getController().getSeat());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
//    private class ButtonListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(e.getSource()==confirm){
//                try {
//                    FlightController.getController().updateSeatOnFlight(SeatsController.getController().getSeat());
//                    MenuBar.getController().confirmPage("SeatChoice","FoodChoice");
////                    FlightController.getController().updateSeatOnFlight(SeatsController.getController().getSeat());
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            else if(e.getSource()==nextB){
//
//                jump2("Flight");
//            }
//        }
//    }

    private void arrangeShowPanel(){
        int StringWidth;

        showSeatP = new JPanel(null);

        showSeatP.setBorder(BorderFactory.createLineBorder(Color.black));
        planeSeats.add(showSeatP);


        DynamicText seatMark = new DynamicText((int)(xShow ), yShow, "left", Color.WHITE, Color.BLACK, "Chosen Seat", wShow, hShow, UIStyle.NORMAL_ARIAL_BOLD);
        InputText seatShow = new InputText(xShow, yShow+hShow, 110, hShow , 10, false, "");
        seatShow.setEditable(false);
        showSeatP.add(seatMark);
        showSeatP.add(seatShow);
        SeatsController.getController().setSeatShow(seatShow);

        DynamicText tipMark = new DynamicText(xShow , yShow+hShow*2, "left", Color.WHITE, Color.BLACK, "Class", wShow, hShow, UIStyle.NORMAL_ARIAL_BOLD);
        InputText tipShow = new InputText(xShow, yShow+hShow*3 , 110, hShow , 15, false, "");
        tipShow.setEditable(false);
        showSeatP.add(tipMark);
        showSeatP.add(tipShow);
        SeatsController.getController().setSeatTypeShow(tipShow);
    }



    private void arrangeLabel(){
        IconLabel avaiLabel= new IconLabel(iconW,iconH,"available",0,0,UIStyle.seatOK);
        avaiLabel.setFont(UIStyle.TINY_ARIAL_BOLD);
        JPanel avaiP=new JPanel(null);
        avaiP.add(avaiLabel);
        IconLabel occupyLabel= new IconLabel(iconW,iconH,"unavailable",0,0,UIStyle.seatNo);
        occupyLabel.setFont(UIStyle.TINY_ARIAL_BOLD);
        JPanel occupyP=new JPanel(null);
        occupyP.add(occupyLabel);
        IconLabel chosenLabel= new IconLabel(iconW,iconH,"chosen",0,0,UIStyle.chosenSeat);
        chosenLabel.setFont(UIStyle.TINY_ARIAL_BOLD);
        JPanel chosenP=new JPanel(null);
        chosenP.add(chosenLabel);
        IconLabel emergeLabel= new IconLabel(iconW,iconH,"emergency seat",0,0,UIStyle.emergencySeat);
        emergeLabel.setFont(UIStyle.TINY_ARIAL_BOLD);
        JPanel emergeP=new JPanel(null);
        emergeP.add(emergeLabel);
        IconLabel legLabel= new IconLabel(iconW,iconH,"bigger legroom",0,0,UIStyle.seatLegroom);
        legLabel.setFont(UIStyle.TINY_ARIAL_BOLD);
        JPanel legP=new JPanel(null);
        legP.add(legLabel);
         markNum=5;
        iconPanel =new JPanel(new GridLayout(markNum,1));
        iconPanel.add(avaiP);
        iconPanel.add(occupyP);
        iconPanel.add(chosenP);
        iconPanel.add(emergeP);
        iconPanel.add(legP);
    }
    public void arrangeFilter(){


    }

    public void jump2(String name){
//    MenuBar.getController().changePage("SeatChoice",name);
//        cards.show(contentPanel,"Flight");

    }
}

