package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * @version 2.2
 * @author: ywh,zyk,fsh,lyk
 * @date: 2022/4/17
 */
public class MainFrame extends JFrame implements MouseListener {
    private SeatChoicePanel seatChoicePanel;
    private FoodChoicePanel foodChoicePanel;
    
    JPanel navigatePanel, contentPanel,contentPanel_1, contentPanel_2,
            contentPanel_3;
    JPanel contentPanel_6;

    JButton flightMenuBt, seatsMenuBt, foodMenuBt,finalPageMenuBt,jb3;
    JButton ticketMenuLabel;

    CardLayout cards = new CardLayout();
    JSplitPane jsp ;
    
    FlightInfoPane flightInfoPane;
    ticketPane TicketPane;
    FinalPagePane finalPagePane;
    
    public MainFrame() throws Exception {



        seatChoicePanel = new SeatChoicePanel();
        foodChoicePanel=new FoodChoicePanel();
        flightInfoPane =new FlightInfoPane();
        TicketPane=new ticketPane();
        finalPagePane=new FinalPagePane();
        jb3 = new JButton("Choose Food");
        
        navigatePanel = new JPanel(new GridLayout(5, 1));
        contentPanel = new JPanel(cards);
        contentPanel_3 = new JPanel();
        //cards,"SeatChoice",contentPanel  cards,"Flight",contentPanel
        contentPanel.add("Flight",flightInfoPane);
        contentPanel.add("SeatChoice",seatChoicePanel);
        contentPanel.add("FoodChoice",foodChoicePanel);
         contentPanel.add("Tickets",TicketPane);
        contentPanel.add("FinalPage",finalPagePane);
        
        flightMenuBt = new JButton("Flight");
        seatsMenuBt = new JButton("Choose Seat");
        foodMenuBt = new JButton("Choose Food");
        ticketMenuLabel=new JButton("Tickets");
        finalPageMenuBt = new JButton("finalPage");
        
        
        MenuBar.menuBar=new MenuBar(cards,contentPanel);
        MenuBar.getController().addBt("Flight",flightMenuBt);
        MenuBar.getController().addBt("SeatChoice",seatsMenuBt);
        MenuBar.getController().addBt("FoodChoice",foodMenuBt);
        //initial page to show
        MenuBar.getController().changePage("FoodChoice","FoodChoice");
         //zyk
        MenuBar.getController().addBt("Tickets",ticketMenuLabel);
        //fsh
        MenuBar.getController().addBt("FinalPage",finalPageMenuBt);

        //add zyk
        contentPanel_6=  new JPanel();
        contentPanel_6.setBackground(Color.YELLOW);

        flightMenuBt.addMouseListener(this);
        seatsMenuBt.addMouseListener(this);
        foodMenuBt.addMouseListener(this);
        //zyk
        jb3.addMouseListener(this);
         ticketMenuLabel.addMouseListener(this);
        finalPageMenuBt.addMouseListener(this);
        
        navigatePanel.add(flightMenuBt);
        navigatePanel.add(seatsMenuBt);
        navigatePanel.add(foodMenuBt);
        //zyk
        navigatePanel.add(ticketMenuLabel);
        //fsh
        navigatePanel.add(finalPageMenuBt);

        contentPanel.add(contentPanel_3);

//        cards.show(contentPanel, "SeatChoice");
        //divide the windows into halves
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigatePanel,
                contentPanel);
        jsp.setDividerLocation(UIStyle.division);
        jsp.setDividerSize(1);
        this.add(jsp);

//        planeModelPanel= new PlaneModelPanel(cards,this);
//        this.add(planeModelPanel);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
            // 判断用户点击了哪个JLable
            if (e.getSource() == flightMenuBt) {
                MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Flight");
            } else if (e.getSource() == seatsMenuBt) {
                MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "SeatChoice");
//                cards.show(contentPanel, "SeatChoice");
            } else if (e.getSource() == foodMenuBt) {
                MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "FoodChoice");
            }
            else if (e.getSource() == jb3) {
                cards.show(contentPanel, "3");
            }
             else if (e.getSource() == ticketMenuLabel) {
                System.out.println("click tickets");
                MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "Tickets");
            }
            else if(e.getSource() == finalPageMenuBt) {
            	MenuBar.getController().changePage(MenuBar.getController().getCurrentBt(), "FinalPage");
            }

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
