package UI;



import controller.Login;
import entity.Passenger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * the GUI for users login with correct name and DocumentID
 * @Version 3.0
 * @author Yixuan Wang
 */
public class LoginName extends JFrame implements ActionListener {
    public LoginName() {
        this.setVisible(true);
        initComponents();
        this.setSize(800,600);
    }

    private void initComponents() {
    	setFont(UIStyle.TINY_ARIAL_BOLD);
        Image image = new ImageIcon(UIStyle.logo).getImage();
        this.setIconImage(image);
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        panel2 = new BackgroundPanel(image1);
        panel5 = new JPanel();
        panel7 = new JPanel();
        label10 = new JLabel();
        instruction = new JButton();
        panel6 = new JPanel();
        panel8 = new JPanel();
        inputNotify = new JLabel();
        panel9 = new JPanel();
        inSurname = new JTextField();
        inID = new JPasswordField();
        surnameNoti = new JLabel();
        IDNoti = new JLabel();
        panel10 = new JPanel();
        con = new JButton();
        back = new JButton();
        con.addActionListener(this);
        back.addActionListener(this);
        instruction.addActionListener(this);
        
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);



        //======== panel2 ========
        {
            panel2.setBackground(SystemColor.window);
            panel2.setLayout(new GridLayout(5, 0));

            //======== panel5 ========
            {
                panel5.setOpaque(false);
                panel5.setLayout(new GridLayout(1, 2));

                //======== panel7 ========
                {
                    panel7.setOpaque(false);
                    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));


                    //---- instruction ----
                    instruction.setIcon(new ImageIcon(UIStyle.instr));
                    instruction.setContentAreaFilled(false);
                    panel7.add(instruction);
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
                inputNotify.setText("Please enter your surname and ID number");
                inputNotify.setFont(new Font("Arial", Font.PLAIN, 26));
                inputNotify.setForeground(SystemColor.textHighlight);
                panel8.add(inputNotify);
                inputNotify.setBounds(10, 20,550,80);

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
                panel9.add(inSurname);
                inSurname.setBounds(370, 25, 175, inSurname.getPreferredSize().height);
                panel9.add(inID);
                inID.setBounds(370, 65, 170, inID.getPreferredSize().height);

                //---- surnameNoti ----
                surnameNoti.setText("Surname");
                surnameNoti.setFont(UIStyle.TINY_ARIAL_BOLD);
                surnameNoti.setForeground(SystemColor.textHighlight);
                panel9.add(surnameNoti);
                surnameNoti.setBounds(250,25,200,30);

                //---- IDNoti ----
                IDNoti.setText("ID number");
                IDNoti.setFont(UIStyle.TINY_ARIAL_BOLD);
                IDNoti.setForeground(SystemColor.textHighlight);
                panel9.add(IDNoti);
                IDNoti.setBounds(250,65,200,30);

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
                con.setIcon(new ImageIcon(UIStyle.confirm));
                con.setContentAreaFilled(false);
                panel10.add(con);
                con.setBounds(120,60,120,35);

                //---- back ----
                back.setText("Back");
                panel10.add(back);
                back.setIcon(new ImageIcon(UIStyle.back1));
                back.setContentAreaFilled(false);
                back.setBounds(550,60,120,35);

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
        panel2.setBounds(0, 0, 598, 568);

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
    private JLabel label10;
    private JButton instruction;
    private JPanel panel6;
    private JPanel panel8;
    private JLabel inputNotify;
    private JPanel panel9;
    private JTextField inSurname;
    private JTextField inID;
    private JLabel surnameNoti;
    private JLabel IDNoti;
    private JPanel panel10;
    private JButton con;
    private JButton back;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==instruction){
            Instruction instruction = new Instruction();
        }
        if (e.getSource()==con){
            int a = 1;
            String doID = inID.getText();
            String name = inSurname.getText();
            Login login = new Login();
            Passenger docuId =  login.surAndDocu(doID,name);
            if (docuId==null){
                JOptionPane.showMessageDialog(null, "Cannot find the passenger!",
                        "Wrong Name or ID Number",2);
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
