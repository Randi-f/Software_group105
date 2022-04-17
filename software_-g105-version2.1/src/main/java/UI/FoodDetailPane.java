package UI;

import UI.Component.Picture;
import controller.FoodController;
import entity.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/7 22:36
 */
public class FoodDetailPane extends JPanel implements ActionListener{

    int listX=50,lisY=100,foodPaneWidth=UIStyle.foodPaneWidth,foodPaneHeight=UIStyle.foodPaneHeight;
    int detailX=listX+foodPaneWidth+50,detailY=lisY;

    int nameW=100,nameH=20;
    int picSize=300;
    int btW=50,btH=30;

    String nameTxt;
    JPanel outline =new JPanel(null);
    JPanel countPane=new JPanel(),pricePane=new JPanel();
    JLabel nameLb=new JLabel("",JLabel.CENTER),priceLb,portionLb,numLb;
    JLabel numShow= new JLabel("",JLabel.CENTER), numberTxt = new JLabel("number");;
    JLabel priceShow=new  JLabel("",JLabel.CENTER),priceTxt=new  JLabel("Price $");
    JButton addBt,minusBt,plusBt;
    URL pic;
    JLabel picture=new JLabel();
    int num=0;

//    public FoodDetailPane(){
//
//        this.setLayout(null);
//        FoodController.getController().setShownByName("standard");
//        setContent("standard");
//    }
    public FoodDetailPane(String food){
        this.setLayout(null);
        FoodController.getController().setShownByName(food);
        arrangePaneFrame();
        setContent(food);
    }
    public void arrangePaneFrame(){

        pricePane=new JPanel(new GridLayout(1,2));
        pricePane.add(priceTxt);pricePane.add(priceShow);


        plusBt=new JButton("+");
        minusBt=new JButton("-");
        countPane.setLayout(new GridLayout(1,6));
        countPane.add(numberTxt);
        countPane.add(numShow);
        countPane.add(plusBt);countPane.add(minusBt);
        addBt= new JButton("ADD");

        addBt.addActionListener(this);
        minusBt.addActionListener(this);
        plusBt.addActionListener(this);

        nameLb.setBounds((foodPaneWidth-nameW)/2,0,nameW,nameH);
        picture.setBounds((foodPaneWidth-picSize)/2,nameH,picSize,picSize);
        pricePane.setBounds((foodPaneWidth-100)/2,nameH+picSize,100,30);
        countPane.setBounds((foodPaneWidth-250)/2,nameH+picSize+30,200,30);
        addBt.setBounds((foodPaneWidth-100)/2,foodPaneHeight-70,100,50);

        this.add(nameLb);
        this.add(picture);
        this.add(pricePane);
        this.add(countPane);
        this.add(addBt);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }
    public void setContent(String name){
        num=1;
        FoodController.getController().setShownByName(name);
        Food food2show= FoodController.getController().getShownF();
        nameLb.setText(food2show.getName());
        priceShow.setText(String.valueOf(food2show.getPrice()));
        pic = UIStyle.class.getClassLoader().getResource( "food/"+
                food2show.getName()+".png");
//        System.out.println( FoodController.getController().getShownF().getName());
        picture.setIcon(new ImageIcon(pic));
        numShow.setText(""+num);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton resource= (JButton) e.getSource();
        if(resource.equals(addBt)){
            FoodController.getController().addFood(num);
            FoodController.getController().getOrderPane().setOrder();
        }
        else if(resource.equals(minusBt)){
            if(num>0){
                num=num-1;
                numShow.setText(""+num);
            }
        }else if(resource.equals(plusBt)){
            if(num<10){
                num=num+1;
                numShow.setText(""+num);
            }
        }
    }

}
