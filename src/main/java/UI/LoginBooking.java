package UI;


import controller.Login;
import controller.SeatsController;
import entity.Booking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * the GUI for users login with correct and uncheck bookingNo
 * @Version 3.0
 * @author Yixuan Wang
 */
public class LoginBooking extends JFrame implements ActionListener {
    public static void main(String[] args){
        LoginBooking lo = new LoginBooking();
    }
    public LoginBooking() {
        this.setVisible(true);
        initComponents();
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        Image image = new ImageIcon(UIStyle.logo).getImage();
        this.setIconImage(image);
        Image groundImg = new ImageIcon(UIStyle.backgroundImg).getImage();
        
        mainPanel = new BackgroundPanel(groundImg);
        panel5 = new JPanel();
        panel7 = new JPanel();
        instrction = new JButton();
        panel6 = new JPanel();
        panel8 = new JPanel();
        inputNotify = new JLabel();
        panel9 = new JPanel();
        inputNo = new JTextField();
        panel10 = new JPanel();
        con = new JButton();
        back = new JButton();
        instrction.addActionListener(this);
        con.addActionListener(this);
        back.addActionListener(this);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);



        //======== mainPanel ========
        {
            mainPanel.setLayout(new GridLayout(5, 0));

            //======== panel5 ========
            {
                panel5.setOpaque(false);
                panel5.setLayout(new GridLayout(1, 2));

                //======== panel7 ========
                {
                    panel7.setOpaque(false);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));


                    //---- instrction ----
                    instrction.setIcon(new ImageIcon(UIStyle.instr));
                    instrction.setContentAreaFilled(false);
                    panel7.add(instrction);
                }
                panel5.add(panel7);

                //======== panel6 ========
                {
                    panel6.setOpaque(false);
                    panel6.setLayout(new FlowLayout(FlowLayout.RIGHT));

                }
                panel5.add(panel6);
            }
            mainPanel.add(panel5);

            //======== panel8 ========
            {
                panel8.setOpaque(false);
                panel8.setLayout(null);

                //---- inputNotify ----
                inputNotify.setText("Please enter the Booking No: ");              
                inputNotify.setFont(new Font("Arial", Font.PLAIN, 30));
                inputNotify.setForeground(SystemColor.textHighlight);
                panel8.add(inputNotify);
                inputNotify.setBounds(10, 55,450,80);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(panel8);

            //======== panel9 ========
            {
                panel9.setOpaque(false);
                panel9.setLayout(null);
                inputNo.setBounds(250, 30, 275, 35);
                panel9.add(inputNo);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel9.getComponentCount(); i++) {
                        Rectangle bounds = panel9.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel9.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel9.setMinimumSize(preferredSize);
                    panel9.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(panel9);

            //======== panel10 ========
            {
                panel10.setOpaque(false);
                panel10.setLayout(null);

                //---- con ----
                con.setText("Confirm");
                con.setFont(UIStyle.TINY_ARIAL_BOLD);
                con.setIcon(new ImageIcon(UIStyle.confirm));
                con.setContentAreaFilled(false);
                panel10.add(con);
                con.setBounds(120,60,120,35);

                //---- back ----
                back.setText("Back");
                back.setFont(UIStyle.TINY_ARIAL_BOLD);
                back.setIcon(new ImageIcon(UIStyle.back1));
                back.setContentAreaFilled(false);
                panel10.add(back);
                back.setBounds(550, 60,100,35);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel10.getComponentCount(); i++) {
                        Rectangle bounds = panel10.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel10.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel10.setMinimumSize(preferredSize);
                    panel10.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(panel10);
        }
        contentPane.add(mainPanel);
        mainPanel.setBounds(0, 0, 598, 568);

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
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        mainPanel.setBounds(0,0,790,600);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel mainPanel;
    private JPanel panel5;
    private JPanel panel7;
    private JButton instrction;
    private JPanel panel6;
    private JPanel panel8;
    private JLabel inputNotify;
    private JPanel panel9;
    private JTextField inputNo;
    private JPanel panel10;
    private JButton con;
    private JButton back;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==instrction){
            	Instruction instruction = new Instruction();

        }
        if (e.getSource()==con){
            String bookNo = inputNo.getText();

            Booking booking =  Login.searchBookingNo(bookNo);
            if (booking==null){
                JOptionPane.showMessageDialog(null, "No flight "+bookNo+", please check your booking No.",
                        "Wrong Booking Number",2);
            }
            else if (booking.getStatus()==1){
                JOptionPane.showMessageDialog(null, "The flight "+bookNo+" has been checked in!",
                        "Wrong Booking Number",2);
            }
            else{
            	if (booking.getBookingNo().equals("Not time")){
                    JOptionPane.showMessageDialog(null, "The booking "+bookNo+" is not available to be checked in now!",
                            "Wrong Booking Number",2);
                }
            	else {
            		MainFrame mainFrame = new MainFrame();
            		this.dispose();
            		SeatsController.getController().getSeatsPanel().setContent();
            	}
            	
                
                
            }
        }
        if (e.getSource()==back){
            this.dispose();
            LoginMethod loginMethod = new LoginMethod();
        }
    }
}
