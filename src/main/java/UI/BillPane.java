package UI;

import UI.Component.BottomBar;
import backend.bean.FoodBean;
import backend.dataIO.DataManager;
import controller.FoodController;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import UI.Component.Picture;
/**
 * @version 2.1
 * @author: zyc
 * @date: 2022/5/28
 */



public class BillPane extends JPanel {
    //public JPanel p1 = new JPanel();
    //public JPanel p2 = new JPanel();
    boolean check = false;

    public BillPane() {
        this.setSize(700, 400);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        //createFrame();
    }

    public void createPanel(){
        if(!check){
            createFrame();
        }
        else{
            this.removeAll();
            this.repaint();
            createFrame();
            //this.revalidate();
        }
        check = true;
    }
    JButton xy;

    public void createFrame(){
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setSize(250,250);
        p1.setLayout(new GridLayout (5,1));
        int foodcost = FoodController.getController().getTotal();
        int seatcost = getSeatCost();
        int cost = foodcost + seatcost;

        JLabel instruction1 = new JLabel("Total price:      "+ cost  );
        instruction1.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel instruction2 = new JLabel("Extra Food :      "+ foodcost );
        instruction2.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction2.setHorizontalAlignment(SwingConstants.CENTER);

        Object[][] tableFood=new Object[6][4];
        HashMap<String,Integer> foodCount= FoodController.getController().getFoodCount();
        ArrayList<FoodBean> foodDB= null;
        try {
            foodDB = DataManager.getInstance().foodBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = 0;
        for (String i : foodCount.keySet()) {
            tableFood[a][0] = i;
            tableFood[a][2] = foodCount.get(i);
            for (int j = 0; j < foodDB.size(); j++) {
                if(foodDB.get(j).name.equals(i)){
                    tableFood[a][1] = foodDB.get(j).price;
                    tableFood[a][3] = foodDB.get(j).price * foodCount.get(i);
                }
            }
            a++;
        }
        String[] name={"Food","unit price","quantity"," price"};
        JTable foodtable =new JTable(tableFood, name);
        JScrollPane scroll = new JScrollPane(foodtable);


        JLabel instruction3 = new JLabel("Extra Seat :      "+ SeatsController.getController().getCost());
        instruction3.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel instruction4 = new JLabel("Please pay the bill" );
        instruction4.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction4.setHorizontalAlignment(SwingConstants.CENTER);

        p1.add(instruction4);
        p1.add(instruction3);
        p1.add(instruction2);
        p1.add(scroll);
        p1.add(instruction1);


        this.add(p1);

        p2.setLayout(new GridLayout (8,1));
        JLabel instruction5 = new JLabel("Choose your payment method");
        instruction1.setFont(UIStyle.TINY_ARIAL_BOLD);

        JLabel yl = new JLabel(new ImageIcon(UIStyle.yl));
        JLabel ysf = new JLabel(new ImageIcon(UIStyle.ysf));
        JLabel visa = new JLabel(new ImageIcon(UIStyle.visa));
        JLabel AMEX = new JLabel(new ImageIcon(UIStyle.AMEX));
        JLabel DISCOVER = new JLabel(new ImageIcon(UIStyle.discover));
        JLabel card = new JLabel(new ImageIcon(UIStyle.card));
        JLabel wechat = new JLabel(new ImageIcon(UIStyle.wechat));


        JPanel px = new JPanel();
        px.add(wechat);
        JPanel py = new JPanel();
        py.setLayout(new GridLayout(1,2));
        py.add(yl);
        py.add(ysf);
        JPanel pz = new JPanel();
        pz.setLayout(new GridLayout(2,2));
        pz.add(card);
        pz.add(visa);
        pz.add(AMEX);
        pz.add(DISCOVER);

        JButton x = new JButton("scan to pay");
        x.setFont(UIStyle.TINY_ARIAL_BOLD);
        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cost != 0){
                    wechatGUI we = new wechatGUI();
                }
                else{
                    JOptionPane.showMessageDialog(null,"You don't need to pay the bill");
                }
            }
        });
        JButton y = new JButton("credit card");
        y.setFont(UIStyle.TINY_ARIAL_BOLD);
        y.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Creditcard we = new Creditcard();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        JButton z = new JButton("bank account");
        z.setFont(UIStyle.TINY_ARIAL_BOLD);
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cost != 0){
                    PayBank we = new PayBank();
                }
                else{
                    JOptionPane.showMessageDialog(null,"You don't need to pay the bill");
                }
            }
        });
        xy= new JButton("Confirm");
        xy.setFont(UIStyle.TINY_ARIAL_BOLD);
        xy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cost == 0){
                    MenuBar.getController().confirmPage("Bill","Scan IDcard");
                    BottomBar.getController().setConfirmPage("Scan IDcard",ScanPanel.confirm);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please pay the bill first.");
                }
            }
        });
        p2.add(instruction5);
        p2.add(px);
        p2.add(x);
        p2.add(py);
        p2.add(y);
        p2.add(pz);
        p2.add(z);
        p2.add(xy);
        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.EAST);
    }

    public JButton getXy() {
        return xy;
    }

    public int getSeatCost(){
        return SeatsController.getController().getCost();
    }

    public int getFoodCost(){
        HashMap<String,Integer> foodCount= FoodController.getController().getFoodCount();
        ArrayList<FoodBean> foodDB= null;
        try {
            foodDB = DataManager.getInstance().foodBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int cost = 0;
        for (String i : foodCount.keySet()) {
            for (int j = 0; j < foodDB.size(); j++) {
                if(foodDB.get(j).name.equals(i)){
                    cost += foodCount.get(i) * foodDB.get(j).price;
                }
            }
        }
        return cost;
    }
}

/*
public class BillPane extends JPanel {
    public JPanel p1 = new JPanel();
    public JPanel p2 = new JPanel();
    boolean check = false;

    public BillPane() {
        this.setSize(700, 400);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        //createFrame();
    }


    public void createPanel(){
        if(!check){
            createFrame();
        }
        check = true;
    }

    public void createFrame(){
        p1.setSize(250,250);
        p1.setLayout(new GridLayout (5,1));
        int foodcost = FoodController.getController().getTotal();
        int seatcost = getSeatCost();
        int cost = foodcost + seatcost;

        JLabel instruction1 = new JLabel("Total price:      "+ cost  );
        instruction1.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel instruction2 = new JLabel("Extra Food :      "+ foodcost );
        instruction2.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction2.setHorizontalAlignment(SwingConstants.CENTER);

        Object[][] tableFood=new Object[6][4];
        HashMap<String,Integer> foodCount= FoodController.getController().getFoodCount();
        ArrayList<FoodBean> foodDB= null;
        try {
            foodDB = DataManager.getInstance().foodBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = 0;
        for (String i : foodCount.keySet()) {
            tableFood[a][0] = i;
            tableFood[a][2] = foodCount.get(i);
            for (int j = 0; j < foodDB.size(); j++) {
                if(foodDB.get(j).name.equals(i)){
                    tableFood[a][1] = foodDB.get(j).price;
                    tableFood[a][3] = foodDB.get(j).price * foodCount.get(i);
                }
            }
            a++;
        }
        String[] name={"Food","unit price","quantity"," price"};

        JTable foodtable =new JTable(tableFood, name);
        JScrollPane scroll = new JScrollPane(foodtable);


        JLabel instruction3 = new JLabel("Extra Seat :      "+ SeatsController.getController().getCost());
        instruction3.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel instruction4 = new JLabel("Please pay the bill" );
        instruction4.setFont(UIStyle.TINY_ARIAL_BOLD);
        instruction4.setHorizontalAlignment(SwingConstants.CENTER);

        p1.add(instruction4);
        p1.add(instruction3);
        p1.add(instruction2);
        p1.add(scroll);
        p1.add(instruction1);


        this.add(p1);

        p2.setLayout(new GridLayout (8,1));
        JLabel instruction5 = new JLabel("Choose your payment method");
        instruction1.setFont(UIStyle.TINY_ARIAL_BOLD);

        JLabel yl = new JLabel(new ImageIcon(UIStyle.yl));
        JLabel ysf = new JLabel(new ImageIcon(UIStyle.ysf));
        JLabel visa = new JLabel(new ImageIcon(UIStyle.visa));
        JLabel AMEX = new JLabel(new ImageIcon(UIStyle.AMEX));
        JLabel DISCOVER = new JLabel(new ImageIcon(UIStyle.discover));
        JLabel card = new JLabel(new ImageIcon(UIStyle.card));
        JLabel wechat = new JLabel(new ImageIcon(UIStyle.wechat));


        JPanel px = new JPanel();
        px.add(wechat);
        JPanel py = new JPanel();
        py.setLayout(new GridLayout(1,2));
        py.add(yl);
        py.add(ysf);
        JPanel pz = new JPanel();
        pz.setLayout(new GridLayout(2,2));
        pz.add(card);
        pz.add(visa);
        pz.add(AMEX);
        pz.add(DISCOVER);

        JButton x = new JButton("scan to pay");
        x.setFont(UIStyle.TINY_ARIAL_BOLD);
        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wechatGUI we = new wechatGUI();
            }
        });
        JButton y = new JButton("credit card");
        y.setFont(UIStyle.TINY_ARIAL_BOLD);
        y.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Creditcard we = new Creditcard();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        JButton z = new JButton("bank account");
        z.setFont(UIStyle.TINY_ARIAL_BOLD);
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(cost != 0){
                    PayBank we = new PayBank();
                }
                else{
                    JOptionPane.showMessageDialog(null,"You don't need to pay the bill");
                }

            }
        });
        JButton xy= new JButton("Confirm");
        xy.setFont(UIStyle.TINY_ARIAL_BOLD);
        xy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cost == 0){
                    MenuBar.getController().confirmPage("Bill","Scan IDcard");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please pay the bill first.");
                }
            }
        });
        p2.add(instruction5);
        p2.add(px);
        p2.add(x);
        p2.add(py);
        p2.add(y);
        p2.add(pz);
        p2.add(z);
        p2.add(xy);
        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.EAST);
    }


    public int getSeatCost(){
        return SeatsController.getController().getCost();
    }

    public int getFoodCost(){
        HashMap<String,Integer> foodCount= FoodController.getController().getFoodCount();
        ArrayList<FoodBean> foodDB= null;
        try {
            foodDB = DataManager.getInstance().foodBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int cost = 0;
        for (String i : foodCount.keySet()) {
            for (int j = 0; j < foodDB.size(); j++) {
                if(foodDB.get(j).name.equals(i)){
                    cost += foodCount.get(i) * foodDB.get(j).price;
                }
            }
        }
        return cost;
    }
}*/
