package UI;

import UI.Component.BottomBar;
import UI.Component.Picture;
import backend.bean.BookingBean;
import entity.Bank;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.1
 * @author: zyc
 * @date: 2022/25
 */
public class PayBank extends JFrame{
	int payW=900,payH=600;
    boolean check = false;
    public PayBank() {
        this.setVisible(true);
        this.setLayout(new GridLayout(5,1));
        initComponents();
        this.setBounds((int)((UIStyle.ScreenWidth - payW)/2), (int)(UIStyle.ScreenHeight - payH)/2, (int) payW, (int)payH);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    private void initComponents() {
    	setFont(UIStyle.TINY_ARIAL_BOLD);
        JLabel yl = new JLabel(new ImageIcon(UIStyle.yl));
        JLabel ysf = new JLabel(new ImageIcon(UIStyle.ysf));
        JLabel visa = new JLabel(new ImageIcon(UIStyle.visa));
        JLabel AMEX = new JLabel(new ImageIcon(UIStyle.AMEX));
        JLabel DISCOVER = new JLabel(new ImageIcon(UIStyle.discover));
        JLabel card = new JLabel(new ImageIcon(UIStyle.card));
        JLabel wechat = new JLabel(new ImageIcon(UIStyle.wechat));

        JPanel pz = new JPanel();
        pz.setLayout(new GridLayout(2, 3));
        pz.add(card);
        pz.add(visa);
        pz.add(AMEX);
        pz.add(DISCOVER);
        pz.add(yl);
        pz.add(ysf);

        JLabel instruction = new JLabel("Please insert your credit card");
        instruction.setFont(new Font("Arial", Font.BOLD, 8));

        JPanel account = new JPanel();
        JLabel ACC = new JLabel("Account");
        JTextField acc = new JTextField(20);//8
        account.add(ACC);
        account.add(acc);


        JPanel password = new JPanel();
        JLabel PAS = new JLabel("Password");
        JPasswordField pas = new JPasswordField("",10);//6
        password.add(PAS);
        password.add(pas);


        JPanel confirm = new JPanel();
        confirm.setLayout(new GridLayout(1,2));
        JButton con = new JButton("confirm");
        JButton can = new JButton("cancel");
        confirm.add(con);
        confirm.add(can);
        Bank virtual = new Bank();
        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                boolean Accountcheck = false;
                for(i = 0; i < virtual.getLength(); i ++){
                    System.out.println(virtual.getACC(i)+ "and" + acc.getText());

                    if(virtual.getACC(i).equals(acc.getText())){
                        System.out.println(" account accepted");
                        if(virtual.getPAS(i).equals(pas.getText()))
                        {
                            MenuBar.getController().confirmPage("Bill","Scan IDcard");
                            BottomBar.getController().setConfirmPage("Scan IDcard",ScanPanel.confirm);
                            dispose();
                            JOptionPane.showMessageDialog(null,"You have successfully paid the bill.");
                            Accountcheck = true;
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Wrong Password");
                        }
                        Accountcheck = true;
                    }
                }
                if(!Accountcheck){
                    JOptionPane.showMessageDialog(null,"Wrong Account");
                }
            }
        });

        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.add(pz);
        this.add(instruction);
        this.add(account);
        this.add(password);
        this.add(confirm);
    }

    public void paychecked(){
        check = true;
    }

    public boolean getCheck(){
        return check;
    }
}














/*package UI;

import UI.Component.Picture;
import entity.Bank;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.1
 * @author: zyc
 * @date: 2022/8/25
 */
/*
public class PayBank extends JFrame{

    boolean check = false;
    public PayBank() {
        this.setVisible(true);
        this.setLayout(new GridLayout(5,1));
        initComponents();
        this.setSize(900,600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    private void initComponents() {
    	setFont(UIStyle.TINY_ARIAL_BOLD);
        JLabel yl = new JLabel(new ImageIcon(UIStyle.yl));
        JLabel ysf = new JLabel(new ImageIcon(UIStyle.ysf));
        JLabel visa = new JLabel(new ImageIcon(UIStyle.visa));
        JLabel AMEX = new JLabel(new ImageIcon(UIStyle.AMEX));
        JLabel DISCOVER = new JLabel(new ImageIcon(UIStyle.discover));
        JLabel card = new JLabel(new ImageIcon(UIStyle.card));
        JLabel wechat = new JLabel(new ImageIcon(UIStyle.wechat));

        JPanel pz = new JPanel();
        pz.setLayout(new GridLayout(2, 3));
        pz.add(card);
        pz.add(visa);
        pz.add(AMEX);
        pz.add(DISCOVER);
        pz.add(yl);
        pz.add(ysf);

        JLabel instruction = new JLabel("Please insert your credit card");
        instruction.setFont(new Font("Arial", Font.BOLD, 8));

        Bank virtual = new Bank();

        JPanel account = new JPanel();
        JLabel ACC = new JLabel("Account");
        JTextField acc = new JTextField(8);
        account.add(ACC);
        account.add(acc);


        JPanel password = new JPanel();
        JLabel PAS = new JLabel("Password");
        JPasswordField pas = new JPasswordField("",6);
        password.add(PAS);
        password.add(pas);


        JPanel confirm = new JPanel();
        confirm.setLayout(new GridLayout(1,2));
        JButton con = new JButton("confirm");
        JButton can = new JButton("cancel");
        confirm.add(con);
        confirm.add(can);
        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                boolean Accountcheck = false;
                for(i = 0; i < virtual.getLength(); i ++){
                    if(virtual.getACC(i)==acc.getText()){
                        if(virtual.getPAS(i)==pas.getText())
                        {
                            MenuBar.getController().confirmPage("Bill","Tickets");
                            dispose();

                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Wrong Password");
                        }
                        Accountcheck = true;
                    }
                }
                if(!Accountcheck){
                    JOptionPane.showMessageDialog(null,"Wrong Account");
                }
            }
        });
        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.add(pz);
        this.add(instruction);
        this.add(account);
        this.add(password);
        this.add(confirm);
    }

    public void paychecked(){
        check = true;
    }

    public boolean getCheck(){
        return check;
    }
}*/