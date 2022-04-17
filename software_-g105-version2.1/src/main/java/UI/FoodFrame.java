package UI;

//暂时没有用上
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FoodFrame extends JFrame {

    public JPanel p1 =new JPanel();
    public JPanel p2 =new JPanel();
    public JScrollPane p3 = new JScrollPane();
    public JCheckBox a = new JCheckBox("EGG FRIED RICE");
    public JCheckBox b = new JCheckBox("STEAK");
    public JCheckBox c = new JCheckBox("WINE");
    public JButton d = new JButton("CONFIRM");

    double price = 0;

    public FoodFrame(){
        this.setTitle("CHOOSE YOUR fav");
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout (1,2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createFrame(){
        p1.setSize(250,250);
        p1.setLayout(new GridLayout (4,1));

        JLabel instruction1 = new JLabel("Pick ur dish:");
        instruction1.setFont(new Font("Arial",Font.BOLD,20));
        instruction1.setHorizontalAlignment(SwingConstants.CENTER);


        p1.add(instruction1);
        //p1.add(p3);
        //p3.add(a);
        //p3.add(b);
        //p3.add(c);
        p1.add(a);
        p1.add(b);
        p1.add(c);

        /*a.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                price += 100;
            }

        });
        b.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                price += 5;
            }

        });
        c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                price += 10;
            }

        });*/

        p2.setSize(250,100);
        p2.setLayout(new GridLayout (1,1));
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("PRICE IS "+ getPrice());
            }
        });
        p2.add(d);

        this.add(p1);
        this.add(p2);
    }

    double getPrice(){
        price = 0;
        if(a.isSelected()){ price += 100;}
        if(b.isSelected()){ price += 5;}
        if(c.isSelected()){ price += 10;}
        return price;
    }
}
