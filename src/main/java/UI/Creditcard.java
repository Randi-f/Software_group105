package UI;

import UI.Component.BottomBar;
import UI.Component.Picture;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.1
 * @author: zyc
 * @date: 2022/25
 */

public class Creditcard extends JFrame{
    int payW=900,payH=600;
    boolean check = false;
    public Creditcard() throws InterruptedException {
        this.setVisible(true);
        this.setLayout(new GridLayout(3,1));
        initComponents();
        this.setBounds((int)((UIStyle.ScreenWidth - payW)/2), (int)(UIStyle.ScreenHeight - payH)/2, (int) payW, (int)payH);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() throws InterruptedException {
        setFont(UIStyle.TINY_ARIAL_BOLD);
        JLabel yl = new JLabel(new ImageIcon(UIStyle.yl));
        JLabel ysf = new JLabel(new ImageIcon(UIStyle.ysf));
        JLabel visa = new JLabel(new ImageIcon(UIStyle.visa));
        JLabel AMEX = new JLabel(new ImageIcon(UIStyle.AMEX));
        JLabel DISCOVER = new JLabel(new ImageIcon(UIStyle.discover));
        JLabel card = new JLabel(new ImageIcon(UIStyle.card));

        JPanel pz = new JPanel();
        pz.setLayout(new GridLayout(2,3));
        pz.add(card);
        pz.add(visa);
        pz.add(AMEX);
        pz.add(DISCOVER);
        pz.add(yl);
        pz.add(ysf);

        JLabel instruction = new JLabel("Please insert your credit card");
        instruction.setFont(new Font("Arial",Font.BOLD,16));
        JPanel bt= new JPanel();
        bt.setLayout(new GridLayout(1,2));
        JButton use = new JButton("use a bank card");
        use.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException f) {
                    f.printStackTrace();
                }
                while(true)
                {
                    if(Math.random() * 100 > 0.05){
                        MenuBar.getController().confirmPage("Bill","Scan IDcard");
                        BottomBar.getController().setConfirmPage("Scan IDcard",ScanPanel.confirm);
                        JOptionPane.showMessageDialog(null,"You have successfully paid the bill.");
                        dispose();
                        break;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                }
            }
        });
        JButton cancel = new JButton("cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        bt.add(use);
        bt.add(cancel);

        this.add(pz);
        this.add(instruction);
        this.add(bt);
    }

    public void paychecked(){
        check = true;
    }

    public boolean getCheck(){
        //dispose();
        return check;
    }


}