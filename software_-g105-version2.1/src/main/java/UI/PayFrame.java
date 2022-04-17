package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayFrame extends JFrame {

    public JPanel p1 =new JPanel();
    public JPanel p2 =new JPanel();
    public JButton a = new JButton("Wechat");
    public JButton b = new JButton("UnionPay");
    public JButton c = new JButton("VISA");

    double price;
    //Container contentPane = getContentPane();
    public PayFrame(double Price){
        this.price = Price;
        this.setTitle("PAY FOR IT");
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout (1,2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        createFrame();
    }

    public void createFrame(){
        p1.setSize(250,250);
        p1.setLayout(new GridLayout (2,1));

        JLabel instruction1 = new JLabel("The total price is:" + price);
        instruction1.setFont(new Font("Arial",Font.BOLD,18));
        instruction1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel instruction2 = new JLabel("Please select your payment method");
        instruction2.setFont(new Font("Arial",Font.BOLD,18));
        instruction2.setHorizontalAlignment(SwingConstants.CENTER);

        p1.add(instruction1);
        p1.add(instruction2);

        p2.setSize(250,250);
        p2.setLayout(new GridLayout (3,1));
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	wechatGUI we = new wechatGUI();
               
                
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame k = new JFrame("PAY!PAY!");
                k.setVisible(true);
                k.setSize(700,700);
                //k.setLocation(500,200);
                k.add(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Desktop\\AA.jpg")));
                k.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              
            }

        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame k = new JFrame("PAY!PAY!");
                k.setVisible(true);
                k.setSize(700,700);
                //k.setLocation(500,200);
                k.add(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Desktop\\AA.jpg")));
                k.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });

        p2.add(a);
        p2.add(b);
        p2.add(c);

        this.add(p1);
        this.add(p2);
    }

}
