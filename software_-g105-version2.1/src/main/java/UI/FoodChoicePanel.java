package UI;


import UI.Component.JOrderBt;
import UI.Component.Picture;
import UI.Component.JfoodItem;
import controller.FoodController;
import entity.Food;
import entity.OrderedFood;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.swing.*;

/**
* @author fsh
* date:2022/04/01
 * function: GUI for food choice £¨formed on standard GUI)
 * input:none
 * output:String with the chosen food of the passenger
 * iteration:1
 * version:1.1
 * to be improved: pictures of food, special food choice, popup window
*/
public class FoodChoicePanel extends JPanel implements ActionListener{




	FoodDetailPane foodDetailPane;
	JPanel foodListPane;

FoodOrderPane orderPane;
	String foodchoice;//final food choice
	   int listX=50,lisY=100;
	   int foodPaneWidth=UIStyle.foodPaneWidth;
	   int foodPaneHeight=UIStyle.foodPaneHeight;
	  int detailX=listX+foodPaneWidth+50,detailY=lisY;



	int orderedListX=listX,orderedListY=lisY+foodPaneHeight+50;
	int orderedListWidth=foodPaneWidth*2+50,orderedListHeight=50;





	public FoodChoicePanel() {
	   this.setLayout(null);


		foodListPane=new FoodListPane();

		foodDetailPane= new FoodDetailPane("standard");
		orderPane=new FoodOrderPane();
		FoodController.getController().setOrderPane(orderPane);
		FoodController.getController().setDetailPane(foodDetailPane);

		foodListPane.setBounds(listX, lisY, foodPaneWidth, foodPaneHeight);
		this.add(foodListPane);
		foodDetailPane.setBounds(detailX,detailY,foodPaneWidth,foodPaneHeight);
	   this.add(foodDetailPane);
	   this.add(orderPane);
		JButton backBt = new JButton("RETURN");
		backBt.setBounds(UIStyle.backX, UIStyle.backY, UIStyle.backWidth, UIStyle.backHeight);
		this.add(backBt);

		JLabel titleLb = new JLabel("Food Selection");
		titleLb.setFont(new Font("Dialog", Font.PLAIN, 24));
		titleLb.setBounds(UIStyle.titleX, UIStyle.titleY, UIStyle.titleWidth, UIStyle.titleHeight);
		this.add(titleLb);


   }


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton resource= (JButton) e.getSource();
//		if(resource.getText().equals())

	}
}
