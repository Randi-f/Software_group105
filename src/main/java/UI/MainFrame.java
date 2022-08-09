package UI;

import controller.Login;
import utils.MouseMonitor;
import utils.ThreadHandler;
import UI.Component.BottomBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * @version 5.1
 * @author: ywh,zyk,fsh,lyk,wyx,zyc
 * @date: 2022/5/21
 */
public class MainFrame extends JFrame implements MouseListener, ActionListener {
    private SeatChoicePanel seatChoicePanel;
    private FoodChoicePanel foodChoicePanel;
    private static BillPane billPanel;

    JPanel navigatePanel, contentPanel, scanPanel;
    JButton flightMenuBt, seatsMenuBt, foodMenuBt,finalPageMenuBt,scanMenuBt;
    JButton billPageBt;
    JButton ticketMenuLabel;

    CardLayout cards = new CardLayout();
    JSplitPane jsp ;

    FlightInfoPane flightInfoPane;
    ticketPane TicketPane;
    FinalPagePane finalPagePane;

    public MainFrame() {
        new UIStyle();
        this.setVisible(true);
        this.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
        this.setFont(UIStyle.TINY_ARIAL_BOLD);


        Image image = new ImageIcon(UIStyle.logo).getImage();
        this.setIconImage(image);
        try {
            flightInfoPane =new FlightInfoPane(this);
            seatChoicePanel = new SeatChoicePanel();
            scanPanel = new ScanPanel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        foodChoicePanel=new FoodChoicePanel();

        TicketPane=new ticketPane();
        finalPagePane=new FinalPagePane(this);
        billPanel = new BillPane();

        navigatePanel = new JPanel(new GridLayout(7, 1));
        scanMenuBt = new JButton("IDcard");
        scanMenuBt.setFont(UIStyle.TINY_ARIAL_BOLD);
    
        scanMenuBt.addMouseListener(this);
        contentPanel = new JPanel(cards);

        contentPanel.add("Flight",flightInfoPane);
        contentPanel.add("SeatChoice",seatChoicePanel);
        contentPanel.add("FoodChoice",foodChoicePanel);      
        contentPanel.add("Scan IDcard",scanPanel);
        contentPanel.add("Tickets",TicketPane);
        contentPanel.add("FinalPage",finalPagePane);
        contentPanel.add("Bill", billPanel);

        flightMenuBt = new JButton("Flight");
        seatsMenuBt = new JButton("Seat");
        foodMenuBt = new JButton("Food");
        ticketMenuLabel=new JButton("Tickets");
        finalPageMenuBt = new JButton("Final");
        billPageBt = new JButton("Bill");


        MenuBar.menuBar=new MenuBar(cards,contentPanel);
        BottomBar.bottomBar=new BottomBar();
        MenuBar.getController().addBt("Flight",flightMenuBt);
        MenuBar.getController().addBt("SeatChoice",seatsMenuBt);
        MenuBar.getController().addBt("FoodChoice",foodMenuBt);
        MenuBar.getController().addBt("Bill", billPageBt);
        MenuBar.getController().addBt("Scan IDcard",scanMenuBt);
        MenuBar.getController().addBt("Tickets",ticketMenuLabel);
        MenuBar.getController().addBt("FinalPage",finalPageMenuBt);

        flightMenuBt.setIcon(new ImageIcon(UIStyle.flight));
        flightMenuBt.setContentAreaFilled(false);
        foodMenuBt.setIcon(new ImageIcon(UIStyle.food));
        foodMenuBt.setContentAreaFilled(false);
        seatsMenuBt.setIcon(new ImageIcon(UIStyle.seat));
        seatsMenuBt.setContentAreaFilled(false);
        ticketMenuLabel.setIcon(new ImageIcon(UIStyle.ticket));
        ticketMenuLabel.setContentAreaFilled(false);    
        scanMenuBt.setIcon(new ImageIcon(UIStyle.scan));
        scanMenuBt.setContentAreaFilled(false);
        billPageBt.setIcon((new ImageIcon(UIStyle.bill)));
        billPageBt.setContentAreaFilled(false);
        finalPageMenuBt.setIcon(new ImageIcon(UIStyle.success));
        finalPageMenuBt.setContentAreaFilled(false);




        //zyk
        flightMenuBt.addMouseListener(this);
        seatsMenuBt.addMouseListener(this);
        foodMenuBt.addMouseListener(this);
        ticketMenuLabel.addMouseListener(this);
        scanMenuBt.addMouseListener(this);
        finalPageMenuBt.addMouseListener(this);
        billPageBt.addMouseListener(this);
        
        foodChoicePanel.confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                billPanel.createPanel();
                MenuBar.getController().confirmPage("FoodChoice","Bill");
                BottomBar.getController().setConfirmPage("Bill",billPanel.getXy());
            }
        });


        navigatePanel.add(flightMenuBt);
        navigatePanel.add(seatsMenuBt);
        navigatePanel.add(foodMenuBt);
        navigatePanel.add(billPageBt);
        navigatePanel.add(scanMenuBt);
        navigatePanel.add(ticketMenuLabel);
        navigatePanel.add(finalPageMenuBt);

        //divide the windows into halves
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigatePanel,
                contentPanel);
        jsp.setDividerLocation(UIStyle.division);
        jsp.setDividerSize(1);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(jsp,BorderLayout.CENTER);;
        
        this.getContentPane().add(BottomBar.getController(),BorderLayout.SOUTH);
        MenuBar.getController().changePage("Flight");
        BottomBar.getController().setConfirmPage("Flight",flightInfoPane.getNextBt());
//        BottomBar.getController().setConfirmPage("SeatChoice",flightInfoPane.nextBt);
        ThreadHandler.newTimerThread(UIStyle.timer,BottomBar.getController().getTimerLb(),this);
        this.addMouseListener(new MouseMonitor());
        
        
        //this.add(jsp);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean res=false;
        if (e.getSource() == flightMenuBt) {
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Flight");
            if(res)BottomBar.getController().updateConfirm("Flight");
        } else if (e.getSource() == seatsMenuBt) {
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "SeatChoice");
            if(res)BottomBar.getController().updateConfirm("SeatChoice");
        } else if (e.getSource() == foodMenuBt) {
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "FoodChoice");
            if(res)BottomBar.getController().updateConfirm("FoodChoice");
        }
        else if (e.getSource()==scanMenuBt){
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Scan IDcard");
            if(res)BottomBar.getController().updateConfirm("Scan IDcard");
        }
        else if(e.getSource() == billPageBt){
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Bill");
            if(res)BottomBar.getController().updateConfirm("Bill");
        }
        else if (e.getSource() == ticketMenuLabel) {
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Tickets");
            if(res)BottomBar.getController().updateConfirm("Tickets");
        }
        else if(e.getSource() == finalPageMenuBt) {
            res=MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "FinalPage");
            if(res)BottomBar.getController().updateConfirm("FinalPage");
        }

    }
    /*
    public void mouseClicked(MouseEvent e) {
    	boolean res=false;
        if (e.getSource() == flightMenuBt) {
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Flight");
        } else if (e.getSource() == seatsMenuBt) {
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "SeatChoice");
            
        } else if (e.getSource() == foodMenuBt) {
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "FoodChoice");
        }
        else if (e.getSource()==scanMenuBt){
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Scan IDcard");
        }
        else if(e.getSource() == billPageBt){
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Pay the bill");
        }
        else if (e.getSource() == ticketMenuLabel) {
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Tickets");
        }
        else if(e.getSource() == finalPageMenuBt) {
            MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "FinalPage");
        }
        else if(e.getSource() == foodChoicePanel.confirm){
            billPanel.createPanel();
        }

    }*/

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


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


