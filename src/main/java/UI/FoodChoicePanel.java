package UI;


import UI.Component.*;
import controller.FoodController;
import entity.Food;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
* @author fsh
* date:2022/04/01
 * function: GUI for food choice formed on standard GUI)
 * input:none
 * output:String with the chosen food of the passenger
 * iteration:1
 * version:1.1
 * to be improved: pictures of food, special food choice, popup window
*/
public class FoodChoicePanel extends JPanel implements ActionListener{


	private JPanel outerP,foodPane;
	FoodDetailPane foodDetailPane;
	JPanel foodListPane;
	JPanel totalPane;
	FoodOrderPane orderPane;

	public static JButton  confirm = new JButton("CONFIRM");
	String foodChoice;//final food choice

	 int paneGap=30;
	 int ordersW=170;
	   int foodPaneWidth=UIStyle.foodPaneWidth;
	   int foodPaneHeight=UIStyle.foodPaneHeight;
	  int listX=(UIStyle.contentW-2*foodPaneWidth+paneGap-ordersW)/2-30,lisY=80;
	  int detailX=listX+UIStyle.foodListW+paneGap,detailY=lisY-20;

	public static MyReminder reminder;


	int orderedListX=listX,orderedListY=lisY+foodPaneHeight+50;
	int orderedListWidth=foodPaneWidth*2+50,orderedListHeight=50;


	private JLabel titleLb=new JLabel();


	public FoodChoicePanel() {

		foodPane=new JPanel(null);
		foodPane.setOpaque(false);
		reminder=new MyReminder(foodPane);
		Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
		outerP = new BackgroundPanel(image1);
		outerP.setLayout(new BorderLayout());
		this.setLayout(new BorderLayout());
		this.add(outerP,BorderLayout.CENTER);
		outerP.setBorder(new EmptyBorder(12, 12, 12, 12));
		outerP.add(foodPane,BorderLayout.CENTER);

	    confirm.setFont(UIStyle.TINY_ARIAL_BOLD);
		foodListPane=new FoodListPane();

		foodDetailPane= new FoodDetailPane("standard");
		foodDetailPane.setFont(UIStyle.NORMAL_ARIAL_BOLD);
		orderPane=new FoodOrderPane();
		orderPane.setBounds(detailX+foodPaneWidth+paneGap,lisY,ordersW,foodPaneHeight);
		orderPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//		confirm.setBounds(detailX+foodPaneWidth+paneGap,detailY+500,ordersW,30);
		totalPane=new  BillMini(2);
		totalPane.setBounds((UIStyle.contentW-UIStyle.billW)/2,detailY+UIStyle.foodPaneHeight+20,UIStyle.billW,UIStyle.billH);

		orderPane.setBillPane(totalPane);
		orderPane.setOrder();

		FoodController.getController().setOrderPane(orderPane);
		FoodController.getController().setDetailPane(foodDetailPane);
        

		foodListPane.setBounds(listX, lisY, UIStyle.foodListW, foodPaneHeight);
		foodPane.add(foodListPane);
		foodDetailPane.setBounds(detailX,detailY,foodPaneWidth,foodPaneHeight);
	   foodPane.add(foodDetailPane);
	   foodPane.add(orderPane);
		foodPane.add(totalPane);
		foodPane.add(confirm);


//		JButton backBt = new JButton("RETURN");
//		backBt.setFont(UIStyle.TINY_ARIAL_BOLD);
//		backBt.setBounds(UIStyle.backX, UIStyle.backY, UIStyle.backWidth, UIStyle.backHeight);
//		foodPane.add(backBt);






		instrButton.setText("Instructions");
		instrButton.setFont(UIStyle.TINY_ARIAL_BOLD);
		instrButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Instr(e);
			}
		});
		instrButton.setIcon(new ImageIcon(UIStyle.instr));
		instrButton.setContentAreaFilled(false);
		instrButton.setBounds(750,10,150,50);

		titleLb.setText("Please Customize Food");
		titleLb.setFont(new Font("Arial",Font.PLAIN,33));
		titleLb.setForeground(Color.black);
		titleLb.setBounds(10,10,600,50);
		foodPane.add(instrButton);
		foodPane.add(titleLb);
   }

	private JButton instrButton=new JButton();

	/**
	 * This is used to show instruction
	 * @param e click instruction button
	 */
	private void Instr(ActionEvent e){
		JOptionPane.showMessageDialog(null, " Please select the tickets you want to print and then click the Next button." +
				" You can click the Preview button to view the ticket preview ", " Instruction", JOptionPane.INFORMATION_MESSAGE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton resource= (JButton) e.getSource();


	}
}
