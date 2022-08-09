package UI;
import UI.Component.BottomBar;
import controller.BookingController;
import controller.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

/**
 * the GUI for users final verifying their identity
 * @Version 2.0
 * @author Yixuan Wang
 */

public class ScanPanel extends JPanel implements KeyListener,ActionListener{
   
	 public static JButton confirm=new JButton("CONFIRM");
	
	
	public ScanPanel() {
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        panel2 = new BackgroundPanel(image1);
        panel5 = new JPanel();
        panel7 = new JPanel();
        panel6 = new JPanel();
        panel8 = new JPanel();
        inputNotify = new JLabel();
        panel9 = new JPanel();
        inID = new JPasswordField();
        panel10 = new JPanel();

        //======== this ========
        this.setLayout(null);



        //======== panel2 ========
        {
            panel2.setBackground(SystemColor.window);
            panel2.setLayout(new GridLayout(5, 0));
                 //======== panel5 ========
            {
                panel5.setLayout(new GridLayout(1, 2));
                panel5.setOpaque(false);
                //======== panel7 ========
                {
                    panel7.setOpaque(false);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
                }
                panel5.add(panel7);

                //======== panel6 ========
                {
                    panel6.setOpaque(false);
                    panel6.setLayout(new FlowLayout(FlowLayout.RIGHT));

                }
                panel5.add(panel6);
            }
            panel2.add(panel5);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                panel8.setOpaque(false);
                //---- input ----
                inputNotify.setText("Please put your ID document on the machine");
                inputNotify.setFont(new Font("Arial", Font.PLAIN, 25));
                inputNotify.setForeground(SystemColor.textHighlight);
                panel8.add(inputNotify);
                inputNotify.setBounds(30, 55,550,80);

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
            panel2.add(panel8);

            //======== panel9 ========
            {
                panel9.setOpaque(false);
                panel9.setLayout(null);
                inID.setBounds(350, 30, 275, 35);
                String pNo;
                pNo = Login.pNo;
                if (Math.random()>0.9){
                    inID.setText("rgiuy763");
                }
                else {
                    inID.setText(pNo);
                }
                inID.addKeyListener(this);
                confirm.addActionListener(this);
                panel9.add(inID);


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
            panel2.add(panel9);

            //======== panel10 ========
            {
                panel10.setOpaque(false);
                panel10.setLayout(null);

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
            panel2.add(panel10);
        }
        this.add(panel2);
        panel2.setBounds(100, 0, 598, 568);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < this.getComponentCount(); i++) {
                Rectangle bounds = this.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = this.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            this.setMinimumSize(preferredSize);
            this.setPreferredSize(preferredSize);
        }
        panel2.setBounds(0,0,UIStyle.width,UIStyle.height);

    }


    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel7;
    private JPanel panel6;
    private JPanel panel8;
    private JLabel inputNotify;
    private JPanel panel9;
    private JTextField inID;
    private JPanel panel10;
    @Override
    public void actionPerformed(ActionEvent e) {
        jump();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void jump(){
        if (inID.getText().equals( Login.pNo)){
            MenuBar.getController().confirmPage("Scan IDcard", "Tickets");
            BottomBar.getController().setConfirmPage("Tickets",ticketPane.nextBt);
            BookingController.getController().checkinAll();
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid ID card!","Wrong Message",2);
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

