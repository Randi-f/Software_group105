package UI;


import controller.Login;
import entity.Passenger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * @author unknown
 */
public class LoginScan extends JFrame implements ActionListener {
    public static void main(String[] args){
        LoginScan lo = new LoginScan();
    }
    public LoginScan() {
        this.setVisible(true);
        initComponents();
        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        panel2 = new JPanel();
        panel5 = new JPanel();
        panel7 = new JPanel();
        label10 = new JLabel();
        instrction = new JButton();
        panel6 = new JPanel();
        label11 = new JLabel();
        panel8 = new JPanel();
        label12 = new JLabel();
        panel9 = new JPanel();
        textField1 = new JPasswordField();
        panel10 = new JPanel();
        con = new JButton();
        back = new JButton();

        instrction.addActionListener(this);
        con.addActionListener(this);
        back.addActionListener(this);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(SystemColor.activeCaption);

            panel1.setLayout(new GridLayout(10, 0));

            //---- label1 ----
            label1.setText("Login");
            panel1.add(label1);

            //---- label2 ----
            label2.setText("Flight Choosing");
            panel1.add(label2);

            //---- label3 ----
            label3.setText("Seat Choosing");
            panel1.add(label3);

            //---- label4 ----
            label4.setText("Meal Choosing");
            panel1.add(label4);

            //---- label5 ----
            label5.setText("Extra Payment");
            panel1.add(label5);

            //---- label6 ----
            label6.setText("Confirmation");
            panel1.add(label6);

            //---- label7 ----
            label7.setText("Print");
            panel1.add(label7);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 100, 568);

        //======== panel2 ========
        {
            panel2.setBackground(SystemColor.window);
            panel2.setLayout(new GridLayout(5, 0));

            //======== panel5 ========
            {
                panel5.setLayout(new GridLayout(1, 2));

                //======== panel7 ========
                {
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- label10 ----
                    label10.setText("BookingNo");
                    panel7.add(label10);

                    //---- instrction ----
                    instrction.setIcon(new ImageIcon("E:\\Software Engineering\\AutomaticCheckin\\pic\\question.png"));
                    instrction.setOpaque(false);
                    panel7.add(instrction);
                }
                panel5.add(panel7);

                //======== panel6 ========
                {
                    panel6.setLayout(new FlowLayout(FlowLayout.RIGHT));

                    //---- label11 ----
                    label11.setText("Count Down: XXs");
                    panel6.add(label11);
                }
                panel5.add(panel6);
            }
            panel2.add(panel5);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                //---- label12 ----
                label12.setText("Please put your ID document on the machine");
                label12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
                label12.setForeground(SystemColor.textHighlight);
                panel8.add(label12);
                label12.setBounds(10, 55,550,80);

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
                panel9.setLayout(null);
                textField1.setBounds(250, 30, 275, 35);
                panel9.add(textField1);

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
                panel10.setLayout(null);

                //---- con ----
                con.setText("Confirm");
                panel10.add(con);
                con.setBounds(120,60,120,35);

                //---- back ----
                back.setText("Back");
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
        panel2.setBounds(100,0,780,600);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel7;
    private JLabel label10;
    private JButton instrction;
    private JPanel panel6;
    private JLabel label11;
    private JPanel panel8;
    private JLabel label12;
    private JPanel panel9;
    private JTextField textField1;
    private JPanel panel10;
    private JButton con;
    private JButton back;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==instrction){

        }
        if (e.getSource()==con){
            String doID = textField1.getText();
            Login login = new Login();
            Passenger docuId =  login.scanDocuMentID(doID);
            if (docuId==null){
                JOptionPane.showMessageDialog(null, "Cannot find the passenger!",
                        "Wrong ID Number",2);
            }
            else{
                //进入浏览航班界面
            }
        }
        if (e.getSource()==back){
            this.dispose();
            LoginMethod loginMethod = new LoginMethod();
        }
    }
}
