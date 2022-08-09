package UI;


import utils.MouseMonitor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * For passengers choosing the login method
 * @Version 3.0
 * @author Yixuan Wang
 */
public class LoginMethod extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel panel3;

    private JPanel titlePl;
    private JButton instruction;
    private JLabel titleLb;
    private JPanel bkLoginPl;
    private JPanel nameLoginPl;
    private JPanel scanLoginPl;
    private JButton bkLoginBt;
    private JButton nameLoginBt;
    private JButton scanLoginBt;
    private JButton backBt;
    
    public LoginMethod() {
        this.setVisible(true);
        initComponents();
        this.setBounds((int)((UIStyle.ScreenWidth - UIStyle.HomeW)/2), (int)(UIStyle.ScreenHeight - UIStyle.HomeH)/2, (int) UIStyle.HomeW, (int) UIStyle.HomeH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void initComponents(){
    	
        Image image = new ImageIcon(UIStyle.logo).getImage();
        this.setIconImage(image);
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        mainPanel = new BackgroundPanel(image1);
        panel3 = new JPanel();

        titlePl = new JPanel();
        instruction = new JButton();
        titleLb = new JLabel();
        bkLoginPl = new JPanel();
        nameLoginPl = new JPanel();
        scanLoginPl = new JPanel();
        bkLoginBt = new JButton("Booking No");
        bkLoginBt.setFont(UIStyle.TINY_ARIAL_BOLD);
        nameLoginBt = new JButton("ID + Surname");
        nameLoginBt.setFont(UIStyle.TINY_ARIAL_BOLD);
        scanLoginBt  = new JButton("Scan IDdocument");
        scanLoginBt.setFont(UIStyle.TINY_ARIAL_BOLD);
        backBt = new JButton();
        instruction.addActionListener(this);
        bkLoginBt.addActionListener(this);
        nameLoginBt.addActionListener(this);
        scanLoginBt.addActionListener(this);
        backBt.addActionListener(this);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== mainPanel ========
        {
            mainPanel.setLayout(new GridLayout(5, 0));

            //======== panel3 ========
            {
                panel3.setOpaque(false);
                panel3.setLayout(new GridLayout(1, 2));
            }
            mainPanel.add(panel3);

            //======== titlePl ========
            {
                titlePl.setOpaque(false);
                titlePl.setLayout(null);

                //---- instruction ----
                instruction.setIcon(new ImageIcon(UIStyle.ques));
                instruction.setContentAreaFilled(false);
                instruction.setOpaque(true);
                titlePl.add(instruction);
                
                instruction.setBounds(550, 25, 70, 65);
                instruction.setOpaque(false);
                
                //---- titleLb ----

                titleLb.setIcon(new ImageIcon(UIStyle.lWay));
                titleLb.setHorizontalAlignment(SwingConstants.CENTER);
                titleLb.setFont(titleLb.getFont().deriveFont(titleLb.getFont().getSize() + 10f));
                titleLb.setForeground(SystemColor.textHighlight);
                titlePl.add(titleLb);
                titleLb.setBounds(0, 0, 700, 115);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < titlePl.getComponentCount(); i++) {
                        Rectangle bounds = titlePl.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = titlePl.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    titlePl.setMinimumSize(preferredSize);
                    titlePl.setPreferredSize(preferredSize);
                }
            }
            mainPanel.add(titlePl);
            bkLoginPl.setLayout(null);
            bkLoginPl.setOpaque(false);
            bkLoginBt.setBounds(310,50,160,45);
            bkLoginBt.setContentAreaFilled(false);
            bkLoginPl.add(bkLoginBt);
            mainPanel.add(bkLoginPl);

            nameLoginPl.setLayout(null);
            nameLoginPl.setOpaque(false);
            nameLoginBt.setBounds(310,25,160,45);
            nameLoginBt.setContentAreaFilled(false);
            nameLoginPl.add(nameLoginBt);
            mainPanel.add(nameLoginPl);

            scanLoginPl.setLayout(null);
            scanLoginPl.setOpaque(false);
            scanLoginBt.setBounds(310,0,160,45);
            scanLoginBt.setContentAreaFilled(false);
            scanLoginPl.add(scanLoginBt);
            backBt.setBounds(680,50,70,30);
            backBt.setIcon(new ImageIcon(UIStyle.back));
            backBt.setContentAreaFilled(false);
            scanLoginPl.add(backBt);
            mainPanel.add(scanLoginPl);

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == instruction) {
        	Instruction ins = new Instruction();
        	ins.setVisible(true);
        }
        if (e.getSource() == bkLoginBt) {
            this.dispose();
            LoginBooking loginBooking = new LoginBooking();
        }
        if (e.getSource() == nameLoginBt) {
            this.dispose();
            LoginName loginName = new LoginName();
        }
        if (e.getSource() == scanLoginBt) {
            this.dispose();
            LoginScan lg = new LoginScan();
        }
        if (e.getSource() == backBt) {
            this.dispose();
            Home home = new Home();
        }
       
    }
}
