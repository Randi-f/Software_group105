package UI;



import controller.FlightController;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SeatChoicePanel extends JPanel {

//    CardLayout cards;
//    JPanel contentPanel;
    JPanel markPanel = new JPanel();

    JButton confirmB = new JButton("CONFIRM");
    JButton nextB = new JButton("NEXT");
    SeatsPanel planeSeats =new SeatsPanel();
    public SeatChoicePanel() throws Exception {
//        this.cards=cards;CardLayout cards,String name, JPanel contentPanel
//        this.contentPanel=contentPanel;

//        contentPanel.add(name,this);
        this.setLayout(new BorderLayout());
        planeSeats.setPreferredSize(new Dimension(UIStyle.flightGraphWidth,UIStyle.flightGraphHeight));
        markPanel.setPreferredSize(new Dimension(UIStyle.width-UIStyle.division-UIStyle.flightGraphWidth,UIStyle.flightGraphHeight));

        planeSeats.setBackground(Color.PINK);
        markPanel.setBackground(Color.cyan);
        this.add(markPanel,BorderLayout.WEST);

        this.add(planeSeats,BorderLayout.EAST);

        this.fillMarkPanel();
//
    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==confirmB){
                try {
                    FlightController.getController().updateSeatOnFlight(SeatsController.getController().getSeat());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if(e.getSource()==nextB){

                jump2("Flight");
            }
        }
    }
    
    private void fillMarkPanel(){
        markPanel.setLayout(null);
        confirmB.addActionListener(new ButtonListener());
        markPanel.add(confirmB);
        confirmB.setBounds(50,UIStyle.flightGraphHeight-50,30,20);
        markPanel.add(nextB);
        nextB.setBounds(10,10,60,30);

        nextB.addActionListener(new ButtonListener());
    }

    public void jump2(String name){
    MenuBar.getController().changePage("SeatChoice",name);
//        cards.show(contentPanel,"Flight");

    }
}

