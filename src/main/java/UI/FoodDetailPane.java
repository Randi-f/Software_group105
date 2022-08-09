package UI;

import UI.Component.Picture;
import controller.BookingController;
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

    int nameW=100,nameH=40;
    int picSize=300;
    int btW=50,btH=30;

    String nameTxt;
    JPanel outline =new JPanel(null);
    JPanel countPane=new JPanel(),pricePane=new JPanel();
    JLabel nameLb=new JLabel("",JLabel.CENTER),priceLb,portionLb,numLb;
    JLabel numShow= new JLabel("",JLabel.CENTER), numberTxt = new JLabel("portion:");;
    JLabel priceShow=new  JLabel("",JLabel.CENTER),priceTxt=new  JLabel("price($)");
    JButton addBt,minusBt,plusBt;
    URL picPath;
    JPanel pictureP=new JPanel();
    Picture picture;
    int num=0;


    public FoodDetailPane(String food){
        this.setLayout(null);
        FoodController.getController().setShownByName(food);
        arrangePaneFrame();
        setContent(food);
        
        numShow.setFont(UIStyle.SMALL_ARIAL_BOLD);
        priceShow.setFont(UIStyle.SMALL_ARIAL_BOLD);
    }
    public void arrangePaneFrame(){

        pricePane=new JPanel(new GridLayout(1,2));
        pricePane.add(priceTxt);pricePane.add(priceShow);

        plusBt=new JButton("+");
        plusBt.setFont(UIStyle.TINY_ARIAL_BOLD);
        minusBt=new JButton("-");
        minusBt.setFont(UIStyle.TINY_ARIAL_BOLD);
        countPane.setLayout(new GridLayout(1,6));
        countPane.add(numberTxt);
        countPane.add(numShow);
        countPane.add(plusBt);countPane.add(minusBt);
        addBt= new JButton("ADD");
        addBt.setFont(UIStyle.TINY_ARIAL_BOLD);
        addBt.addActionListener(this);
        minusBt.addActionListener(this);
        plusBt.addActionListener(this);

        nameLb.setBounds((foodPaneWidth-nameW)/2,0,nameW,nameH);
        pictureP.setBounds((foodPaneWidth-picSize)/2,nameH,picSize,picSize);
        pictureP.setLayout(null);
        picPath = UIStyle.class.getClassLoader().getResource( "food/standard.png");
        picture=new Picture(picPath,picSize,picSize);
        picture.setBounds(0,0,picSize,picSize);
        pictureP.add(picture);
        int margin=10;
        int pricePw=120,priceH=50;
        pricePane.setBounds(margin,nameH+picSize,pricePw,priceH);
        countPane.setBounds(margin+pricePw+margin,nameH+picSize,200,priceH);
        addBt.setBounds((foodPaneWidth-60)/2,nameH+picSize+priceH,60,40);

        this.add(nameLb);
        this.add(pictureP);
        this.add(pricePane);
        this.add(countPane);
        this.add(addBt);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }
    
    public void setContent(String name){
        num=1;
        
        FoodController.getController().setShownByName(name);
        Food food2show= FoodController.getController().getshowChosenFood();
        
        nameTxt=food2show.getName();
        nameLb.setText(nameTxt);
        priceShow.setText(String.valueOf(food2show.getPrice()));
        picPath = UIStyle.class.getClassLoader().getResource( "food/"+food2show.getName()+".png");
        picture.setPath(picPath);
        picture.repaint();
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
                if(FoodController.getController().getshowChosenFood().getType().equals("free")){
                    return;
                }
                num=num-1;
                numShow.setText(""+num);
            }
        }else if(resource.equals(plusBt)){
            if(num<10){
                if(FoodController.getController().getshowChosenFood().getType().equals("free")){
                    FoodChoicePanel.reminder.WRONG("only one portion of free food are provided!");
                    return;
                }
                num=num+1;
                numShow.setText(""+num);
            }
        }
    }

}
