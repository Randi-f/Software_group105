package UI;



import controller.FlightController;
import controller.Login;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This panel is used for preview flight ticket information
 * @author zyk
 * @version 5.0
 */
public class previewPanel extends JFrame  {
    public static void main(String[] args) throws ParseException {
        previewPanel p=new previewPanel();
        p.setVisible(true);
    }
    public previewPanel() throws ParseException {
        this.setVisible(true);
        this.setBounds((int)((UIStyle.ScreenWidth - 1200)/2), (int)(UIStyle.ScreenHeight - 600)/2, (int) 1200, (int)600);
        initComponents();
        this.pack();
    }

    private void initComponents() throws ParseException {
        setBackground(new Color(189, 233, 255));
        JPanel panel = new JPanel();

        panel.setBackground(new Color(189, 233, 255));
        panel.setPreferredSize(new Dimension(1200,600));
        add(panel);
        panel.setLayout(null);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        //Set panel size, color, and layout
        panel1.setBounds(100,150,600,360);
        panel1.setBackground(new Color(189, 233, 255));
        panel1.setLayout(null);
        panel.add(panel1);

        //Set panel size, color, and layout
        panel2.setBounds(710,150,350,360);
        panel2.setBackground(new Color(189, 233, 255));
        panel2.setLayout(null);
        panel.add(panel2);

        //Set panel size, color, and layout
        panel3.setBounds(0,50,600,280);
        panel3.setBackground(new Color(255,255,255));
        panel3.setLayout(null);
        panel1.add(panel3);

        //Set panel size, color, and layout
        panel4.setBounds(0,50,350,280);
        panel4.setBackground(new Color(255,255,255));
        panel4.setLayout(null);
        panel2.add(panel4);



        JLabel label1 = new JLabel("PLEASE CLICK NEXT TO PRINT YOUR BOARDING PASS ");
        JLabel label2 = new JLabel("ACCORDING TO THE FIGURE BELOW ");
        JLabel label3 = new JLabel("BOARDING PASS");
        JLabel label4 = new JLabel("BOARDING PASS ");
        JLabel label5 = new JLabel("HAVE A NICE TRIP");
        JLabel label11 = new JLabel("ENGINE ROOM TYPE");
        JLabel label12 = new JLabel("FROM");
        JLabel label13 = new JLabel("TO");
        JLabel label14 = new JLabel("SEAT");
        JLabel label15 = new JLabel("GATE");
        JLabel label16 = new JLabel("Depart TIME");

        JLabel label17 = new JLabel(SeatsController.getController().getSeat().getType());
        JLabel label18 = new JLabel(FlightController.getFlight().departure);
        JLabel label19 = new JLabel(FlightController.getFlight().arrival);
        int x=SeatsController.getController().getSeat().getCol();
        String col = null;
        // converted number to letter
        if(x==1){col="A";}
        else if(x==2){col="B";}
        else if(x==3){col="C";}
        else if(x==4){col="D";}
        else if(x==5){col="E";}
        else if(x==6){col="F";}
        else if(x==7){col="G";}
        else if(x==8){col="H";}
        else if(x==9){col="I";}
        else if(x==10){col="J";}
        else if(x==11){col="K";}
        else if(x==12){col="E";}

        JLabel label110 = new JLabel(SeatsController.getController().getSeat().getRow() +" "+col);
        int num = 1 + (int)(Math.random() * (90));


        JLabel label111 = new JLabel(String.valueOf(num));
        //convert timestamp format to date format
        Timestamp departTime=FlightController.getFlight().departureTime;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String DT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(departTime);
        Date dt=df.parse(DT);
        String Str = df.format(dt);
        System.out.println(Str);
        //Calculate boarding time
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.HOUR,-1);//Minus an hour
        Date dt1=rightNow.getTime();
        String reStr = df.format(dt1);
        System.out.println(reStr);


         JLabel label112 = new JLabel(Str);

         JLabel label21 = new JLabel("SEAT");
        JLabel label22 = new JLabel("GATE");
        JLabel label23 = new JLabel("BOARDING TIME");


         JLabel label24 = new JLabel(SeatsController.getController().getSeat().getRow() +" "+col);
         JLabel label25 = new JLabel(String.valueOf(num));
         JLabel label26 = new JLabel(reStr);

         JLabel icon1 = new JLabel();
        ImageIcon image1 = new ImageIcon(UIStyle.barcode1);
        image1.setImage(image1.getImage().getScaledInstance(120, 260,Image.SCALE_DEFAULT));
        icon1.setIcon(image1);
        icon1.setBounds(0,-350,1000,1000);
        panel3.add(icon1);

        JLabel icon2 = new JLabel();
        ImageIcon image2 = new ImageIcon(UIStyle.barcode2);
        image2.setImage(image2.getImage().getScaledInstance(180, 40,Image.SCALE_DEFAULT ));
        icon2.setIcon(image2);
        icon2.setIcon(image2);
        icon2.setBounds(80,-250,1000,1000);
        panel4.add(icon2);

        label1.setFont(new Font(Font.DIALOG,Font.PLAIN,33));//Set the text font
        label1.setForeground(Color.white);//set text color
        label2.setFont(new Font(Font.DIALOG,Font.PLAIN,33));
        label2.setForeground(Color.white);
        label3.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        label3.setForeground(Color.white);
        label4.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        label4.setForeground(Color.white);
        label5.setFont(new Font(Font.DIALOG,Font.BOLD,16));
        label5.setForeground(Color.white);


        label11.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label11.setForeground(Color.black);
        label12.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label12.setForeground(Color.black);
        label13.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label13.setForeground(Color.black);
        label14.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label14.setForeground(Color.black);
        label15.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label15.setForeground(Color.black);
        label16.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label16.setForeground(Color.black);


        label17.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        label17.setForeground(Color.black);
        label18.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        label18.setForeground(Color.black);
        label19.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        label19.setForeground(Color.black);
        label110.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        label110.setForeground(Color.black);
        label111.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        label111.setForeground(Color.black);
        label112.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        label112.setForeground(Color.black);


        label21.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label21.setForeground(Color.black);
        label22.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label22.setForeground(Color.black);
        label23.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        label23.setForeground(Color.black);
        label24.setFont(new Font(Font.DIALOG,Font.BOLD,36));
        label24.setForeground(Color.black);
        label25.setFont(new Font(Font.DIALOG,Font.BOLD,36));
        label25.setForeground(Color.black);
        label26.setFont(new Font(Font.DIALOG,Font.BOLD,10));
        label26.setForeground(Color.black);


        //Set the label size position and add the label
        label1.setBounds(80,0,1000,100);
        panel.add(label1);
        label2.setBounds(80,50,1000,100);
        panel.add(label2);
        label3.setBounds(30,-20,1000,100);
        panel1.add(label3);
        label4.setBounds(70,-20,1000,100);
        panel2.add(label4);
        label5.setBounds(100,295,1000,100);
        panel2.add(label5);

        label11.setBounds(130,-20,1000,100);
        panel3.add(label11);
        label12.setBounds(130,60,1000,100);
        panel3.add(label12);
        label13.setBounds(130,140,1000,100);
        panel3.add(label13);
        label14.setBounds(400,-20,1000,100);
        panel3.add(label14);
        label15.setBounds(400,60,1000,100);
        panel3.add(label15);
        label16.setBounds(400,140,1000,100);
        panel3.add(label16);



        label17.setBounds(140,20,1000,100);
        panel3.add(label17);
        label18.setBounds(140,100,1000,100);
        panel3.add(label18);
        label19.setBounds(140,180,1000,100);
        panel3.add(label19);
        label110.setBounds(410,20,1000,100);
        panel3.add(label110);
        label111.setBounds(410,100,1000,100);
        panel3.add(label111);
        label112.setBounds(410,180,1000,100);
        panel3.add(label112);


        label21.setBounds(20,-30,1000,100);
        panel4.add(label21);
        label22.setBounds(20,40,1000,100);
        panel4.add(label22);
        label23.setBounds(20,110,1000,100);
        panel4.add(label23);
        label24.setBounds(130,0,1000,100);
        panel4.add(label24);
        label25.setBounds(130,70,1000,100);
        panel4.add(label25);
        label26.setBounds(130,150,1000,100);
        panel4.add(label26);

    }


}


