package UI;


import controller.Login;
import entity.Passenger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
/**
 * the GUI for users login with scanning DocumentID
 * @Version 3.0
 * @author Yixuan Wang
 */
public class LoginScan extends JFrame implements ActionListener {
    public static void main(String[] args){
        LoginScan lo = new LoginScan();
    }
    public LoginScan() {
        this.setVisible(true);
        initComponents();
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        setFont(UIStyle.TINY_ARIAL_BOLD);
        Image image = new ImageIcon(UIStyle.logo).getImage();
        this.setIconImage(image);
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        panel2 = new BackgroundPanel(image1);
        panel5 = new JPanel();
        panel7 = new JPanel();
        instrction = new JButton();
        panel6 = new JPanel();
        panel8 = new JPanel();
        inputNotify = new JLabel();
        panel9 = new JPanel();
        inID = new JPasswordField();
        panel10 = new JPanel();
        con = new JButton();
        back = new JButton();

        instrction.addActionListener(this);
        con.addActionListener(this);
        back.addActionListener(this);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);



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


                    //---- instrction ----
                    instrction.setIcon(new ImageIcon(UIStyle.ques));
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
            panel2.add(panel5);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                panel8.setOpaque(false);
                //---- inputNotify ----
                inputNotify.setText("Please put your ID document on the machine");
                inputNotify.setFont(new Font("Arial", Font.PLAIN, 25));
                inputNotify.setForeground(SystemColor.textHighlight);
                panel8.add(inputNotify);
                inputNotify.setBounds(10, 55,550,80);

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
                inID.setBounds(250, 30, 275, 35);
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
                panel10.add(back);
                back.setIcon(new ImageIcon(UIStyle.back1));
                back.setContentAreaFilled(false);
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
            panel2.add(panel10);
        }
        contentPane.add(panel2);
        panel2.setBounds(100, 0, 598, 568);

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
        panel2.setBounds(0,0,790,600);
        pack();
        setLocationRelativeTo(getOwner());
    }


    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel7;
    private JButton instrction;
    private JPanel panel6;
    private JPanel panel8;
    private JLabel inputNotify;
    private JPanel panel9;
    private JTextField inID;
    private JPanel panel10;
    private JButton con;
    private JButton back;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==instrction){
            Instruction instruction = new Instruction();
        }
        if (e.getSource()==con){

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (Math.random()>0.1){
                inID.setText("E32016978");
            }
            else{
                inID.setText("E32016971");
            }
            String doID = inID.getText();
            Login login = new Login();
            Passenger docuId =  login.scanDocuMentID(doID);
            System.out.println(doID);
            if (docuId==null){
                JOptionPane.showMessageDialog(null, "Cannot find the passenger!",
                        "Wrong ID Number",2);
            }
            else{
            	MainFrame mainFrame = new MainFrame();
                this.dispose();
            }
        }
        if (e.getSource()==back){
            this.dispose();
            LoginMethod loginMethod = new LoginMethod();
        }
    }
}
