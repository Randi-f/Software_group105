package UI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginMethod extends FrameWithNavi implements ActionListener {
    public static void main(String[] args){
        LoginMethod loginMethod = new LoginMethod();
    }
    public LoginMethod(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel3 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        panel4 = new JPanel();
        button1 = new JButton();
        label10 = new JLabel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        bNo = new JButton("Booking No");
        name = new JButton("ID + Surname");
        scan  = new JButton("Scan IDdocument");
        back = new JButton("Back");
        button1.addActionListener(this);
        bNo.addActionListener(this);
        name.addActionListener(this);
        scan.addActionListener(this);
        back.addActionListener(this);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(5, 0));

            //======== panel3 ========
            {
                panel3.setLayout(new GridLayout(1, 2));

                //---- label8 ----
                label8.setText("Check In");
                label8.setVerticalAlignment(SwingConstants.TOP);
                panel3.add(label8);

                //---- label9 ----
                label9.setText("Count Down: XXs");
                label9.setVerticalAlignment(SwingConstants.TOP);
                label9.setHorizontalAlignment(SwingConstants.CENTER);
                panel3.add(label9);
            }
            panel2.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //---- button1 ----
                button1.setIcon(new ImageIcon("E:\\Software Engineering\\AutomaticCheckin\\pic\\ques.png"));
                button1.setOpaque(false);
                panel4.add(button1);
                button1.setBounds(550, 25, 70, 65);

                //---- label10 ----
                label10.setText("Please Select One Way to Login");
                label10.setHorizontalAlignment(SwingConstants.CENTER);
                label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 10f));
                label10.setForeground(SystemColor.textHighlight);
                panel4.add(label10);
                label10.setBounds(0, 0, 700, 115);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            panel2.add(panel4);
            panel5.setLayout(null);
            bNo.setBounds(310,50,160,45);
            panel5.add(bNo);
            panel2.add(panel5);

            panel6.setLayout(null);
            name.setBounds(310,25,160,45);
            panel6.add(name);
            panel2.add(panel6);

            panel7.setLayout(null);
            scan.setBounds(310,0,160,45);
            panel7.add(scan);
            back.setBounds(680,50,70,30);
            panel7.add(back);
            panel2.add(panel7);

        }
        panel2.setBounds(100, 0, 800, 568);

    }

    private JPanel panel3;
    private JLabel label8;
    private JLabel label9;
    private JPanel panel4;
    private JButton button1;
    private JLabel label10;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JButton bNo;
    private JButton name;
    private JButton scan;
    private JButton back;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){

        }
        if (e.getSource()==bNo){
            this.dispose();
            LoginBooking loginBooking = new LoginBooking();
        }
        if (e.getSource()==name){
        	
            this.dispose();
            LoginName loginName = new LoginName();
        }
        if (e.getSource()==scan){
            this.dispose();
            LoginScan lg = new LoginScan();
        }
        if (e.getSource()==back){
            this.dispose();
            Home home = new Home();
        }
    }
}
