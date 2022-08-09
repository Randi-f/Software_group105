


package UI;

import controller.FliInfoController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * This class is used to show flight detail information when user click a flight
 * @author YixuanWang/zyk
 * @version 5.0
 */
public class FlightDetail extends JFrame implements ActionListener {
    public static void main(String[] args){
        FlightDetail lo = new FlightDetail("VS026");
    }
    public FlightDetail(String fliNo) {
        this.setVisible(true);
        initComponents(fliNo);
        this.setSize(800,600);
    }

    private void initComponents(String fliNo) {


        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        panel2 = new BackgroundPanel(image1);
        panel5 = new JPanel();
        panel7 = new JPanel();
        panel6 = new JPanel();
        panel3 = new JPanel();
        numberLb = new JLabel();
        typeLb = new JLabel();
        aviationLb = new JLabel();
        panel4 = new JPanel();
        panel9 = new JPanel();
        originLb = new JLabel();
        departuretimeLb = new JLabel();
        panel8 = new JPanel();
        toLb = new JLabel();
        arrivalTimeLb = new JLabel();
        panel10 = new JPanel();
        gateLb = new JLabel();
        counterNoLb = new JLabel();
        panel11 = new JPanel();
        back = new JButton();
        titleLb=new JLabel();
        back.addActionListener(this);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);



        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(5, 0));
            panel2.setOpaque(false);

            //======== panel5 ========
            {
                panel5.setOpaque(false);
                panel5.setLayout(new GridLayout(1, 2));
                titleLb.setText("Flight Details ");
                titleLb.setFont(new Font("Arial",Font.PLAIN,33));//set text font
                titleLb.setForeground(Color.black);//set text color
                panel5.add(titleLb);
                //======== panel7 ========
                {
                    panel7.setOpaque(false);
                }
                panel5.add(panel7);

                //======== panel6 ========
                {
                    panel6.setOpaque(false);
                }
                panel5.add(panel6);
            }
            panel2.add(panel5);

            //======== panel3 ========
            {
                panel3.setOpaque(false);
                panel3.setLayout(new GridLayout());

                //---- label9 ----
                numberLb.setText("FlightNo: "+ FliInfoController.getController().getDetailByFlightNo(fliNo).getFlightNo());
                numberLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                panel3.add(numberLb);


            }
            panel2.add(panel3);

            //======== panel4 ========
            {
                panel4.setOpaque(false);
                panel4.setLayout(new GridLayout());

                //======== panel9 ========
                {
                    panel9.setOpaque(false);
                    panel9.setLayout(new GridLayout(2, 0));

                    //---- label13 ----
                    originLb.setText("Origin: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getDeparture());
                   // originLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                  //  originLb.setFont(UIStyle.NORMAL_FONT);
                    originLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                    panel9.add(originLb);

                    //---- label14 ----
                    departuretimeLb.setText("DepartureTime: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getDepartureTime());
                    //departuretimeLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    departuretimeLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                    panel9.add(departuretimeLb);
                }
                panel4.add(panel9);

                //======== panel8 ========
                {
                    panel8.setOpaque(false);
                    panel8.setLayout(new GridLayout(2, 0));

                    //---- label15 ----
                    toLb.setText("To: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getArrival());
                  //  toLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    toLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                    panel8.add(toLb);

                    //---- label16 ----
                    arrivalTimeLb.setText("ArrivalTime: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getArrivalTime());
                    //arrivalTimeLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    arrivalTimeLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                    panel8.add(arrivalTimeLb);

                }
                panel4.add(panel8);
            }
            panel2.add(panel4);

            //======== panel10 ========
            {
                panel10.setOpaque(false);
                panel10.setLayout(new GridLayout(1, 2));


                //---- label18 ----
                gateLb.setText("Gate: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getGate());
                //gateLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                gateLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                panel10.add(gateLb);

                //---- label17 ----
                counterNoLb.setText("CounterNo: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getCounterNo());
               // counterNoLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                counterNoLb.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                panel10.add(counterNoLb);
            }
            panel2.add(panel10);

            //======== panel11 ========
            {
                panel11.setOpaque(false);
                panel11.setLayout(null);

                //---- next ----
                back.setText("Back");
                back.setFont(UIStyle.TINY_ARIAL_BOLD);
                back.setBounds(350,50,100,50);
                // back.setSize(30,10);
                panel11.add(back);


            }
            panel2.add(panel11);
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 0, 790, 568);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            ((JComponent)contentPane).setMinimumSize(preferredSize);
            ((JComponent)contentPane).setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel7;
    private JPanel panel6;
    private JPanel panel3;
    private JLabel numberLb;
    private JLabel typeLb;
    private JLabel aviationLb;
    private JPanel panel4;
    private JPanel panel9;
    private JLabel originLb;
    private JLabel departuretimeLb;
    private JPanel panel8;
    private JLabel toLb;
    private JLabel arrivalTimeLb;
    private JPanel panel10;
    private JLabel gateLb;
    private JLabel counterNoLb;
    private JPanel panel11;
    private JButton back;
    private JLabel titleLb;
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==back){
        this.dispose();
    }
    }
}



/*
package UI;

import controller.FliInfoController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FlightDetail extends JFrame implements ActionListener {
    public static void main(String[] args){
        FlightDetail lo = new FlightDetail("VS026");
    }
    
    public FlightDetail(String fliNo) {
        this.setVisible(true);
        initComponents(fliNo);
        this.setSize(800,600);
    }

    private void initComponents(String fliNo) {


        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        panel2 = new BackgroundPanel(image1);
        panel5 = new JPanel();
        panel7 = new JPanel();
        panel6 = new JPanel();
        panel3 = new JPanel();
        numberLb = new JLabel();
        typeLb = new JLabel();
        aviationLb = new JLabel();
        panel4 = new JPanel();
        panel9 = new JPanel();
        originLb = new JLabel();
        departuretimeLb = new JLabel();
        panel8 = new JPanel();
        toLb = new JLabel();
        arrivalTimeLb = new JLabel();
        panel10 = new JPanel();
        gateLb = new JLabel();
        counterNoLb = new JLabel();
        panel11 = new JPanel();
        back = new JButton();
        back.addActionListener(this);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);



        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(5, 0));
            panel2.setOpaque(false);

            //======== panel5 ========
            {
                panel5.setOpaque(false);
                panel5.setLayout(new GridLayout(1, 2));

                //======== panel7 ========
                {
                    panel7.setOpaque(false);
                }
                panel5.add(panel7);

                //======== panel6 ========
                {
                    panel6.setOpaque(false);
                }
                panel5.add(panel6);
            }
            panel2.add(panel5);

            //======== panel3 ========
            {
                panel3.setOpaque(false);
                panel3.setLayout(new GridLayout());

                //---- label9 ----
                numberLb.setText("FlightNo: "+ FliInfoController.getController().getDetailByFlightNo(fliNo).getFlightNo());
                numberLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                panel3.add(numberLb);

                //---- label12 ----
                typeLb.setText("Flight Type: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getPlane());
                typeLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                panel3.add(typeLb);
                System.out.println(FliInfoController.getController().getDetailByFlightNo(fliNo).getPlane());

                //---- label8 ----
                aviationLb.setText("AviationDep: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getAviationDepartment());
                aviationLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                panel3.add(aviationLb);
            }
            panel2.add(panel3);

            //======== panel4 ========
            {
                panel4.setOpaque(false);
                panel4.setLayout(new GridLayout());

                //======== panel9 ========
                {
                    panel9.setOpaque(false);
                    panel9.setLayout(new GridLayout(2, 0));

                    //---- label13 ----
                    originLb.setText("Origin: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getDeparture());
                    originLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    panel9.add(originLb);

                    //---- label14 ----
                    departuretimeLb.setText("DepartureTime: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getDepartureTime());
                    departuretimeLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    panel9.add(departuretimeLb);
                }
                panel4.add(panel9);

                //======== panel8 ========
                {
                    panel8.setOpaque(false);
                    panel8.setLayout(new GridLayout(2, 0));

                    //---- label15 ----
                    toLb.setText("To: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getArrival());
                    toLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    panel8.add(toLb);

                    //---- label16 ----
                    arrivalTimeLb.setText("ArrivalTime: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getArrivalTime());
                    arrivalTimeLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    panel8.add(arrivalTimeLb);
                }
                panel4.add(panel8);
            }
            panel2.add(panel4);

            //======== panel10 ========
            {
                panel10.setOpaque(false);
                panel10.setLayout(new GridLayout(1, 2));


                //---- label18 ----
                gateLb.setText("Gate: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getGate());
                gateLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                panel10.add(gateLb);

                //---- label17 ----
                counterNoLb.setText("CounterNo: "+FliInfoController.getController().getDetailByFlightNo(fliNo).getCounterNo());
                counterNoLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                panel10.add(counterNoLb);
            }
            panel2.add(panel10);

            //======== panel11 ========
            {
                panel11.setOpaque(false);
                panel11.setLayout(new GridLayout(1, 2));

                //---- next ----
                back.setText("Back");
                back.setFont(UIStyle.TINY_ARIAL_BOLD);
                back.setSize(30,10);
                panel11.add(back);


            }
            panel2.add(panel11);
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 0, 790, 568);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            ((JComponent)contentPane).setMinimumSize(preferredSize);
            ((JComponent)contentPane).setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel7;
    private JPanel panel6;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel9;
    private JPanel panel11;
    private JPanel panel8;
    private JPanel panel10;
    
    private JLabel numberLb;
    private JLabel typeLb;
    private JLabel aviationLb;   
    private JLabel originLb;
    private JLabel departuretimeLb; 
    private JLabel toLb;
    private JLabel arrivalTimeLb;  
    private JLabel gateLb;
    private JLabel counterNoLb;
    
    private JButton back;
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==back){
        this.dispose();
    }
    }
}*/


