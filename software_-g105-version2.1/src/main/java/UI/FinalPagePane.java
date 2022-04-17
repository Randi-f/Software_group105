package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Shihan Fu, Yunkai Li
 * @version 2.0
 * This is final page pane
 * cannot be added since the x,y location can not be used in panel
 */

public class FinalPagePane extends JPanel {

	 int foodPaneWidth=UIStyle.foodPaneWidth;
	 int foodPaneHeight=UIStyle.foodPaneHeight;

	 ImageIcon icon;
	 Image img;
	 JLabel lblNewLabel_3;

	public FinalPagePane() {
		
		initComponents();
		this.setVisible(true);
		this.setSize(900,600);
		
		
		icon=new ImageIcon(getClass().getResource("2.jpeg"));
		img=icon.getImage();
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		add(btnNewButton);
		btnNewButton.setBounds(281, 297, 90, 23);
		
		JButton btnNewButton_1 = new JButton("Send Feedback");
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		add(btnNewButton_1);
		btnNewButton_1.setBounds(477, 297, 120, 23);
		
		JLabel lblNewLabel_1 = new JLabel("Please take Your Belongings with You");
		add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 22));
		lblNewLabel_1.setBounds(208, 199, 468, 26);
		
		
		
		
		
			//if (time==0) {
				//JOptionPane.showConfirmDialog(null,
	              //   "You haven't choose a flight yet,please try again.", "Please make your choice", JOptionPane.YES_OPTION);
			//}
			
		
		btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 feedback fb=new feedback();
				 fb.setVisible(true);
			 }
			 });	
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				System.exit(0);
			 }
			 });
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
	}
	
/*	public void getTime() {
		int time = 10;
		while(time>=0) {
			lblNewLabel_3.setText("Counting down:"+time + "s");
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			time--;
		}
		
	}
	*/
	public void initComponents() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(569, 29, 305, 54);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANK YOU FOR CHECKING IN!");
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 29));
		lblNewLabel.setBounds(218, 121, 469, 38);

		int time = 10;
		JLabel lblNewLabel_3 = new JLabel("Counting down:"+time + "s");	
		lblNewLabel_3.setBounds(36, 10, 259, 33);
		panel.add(lblNewLabel_3);
	/*	while(time>=0) {
			lblNewLabel_3.setText("Counting down:"+time + "s");
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			time--;
		}
	*/
		
		this.setVisible(true);
		
	}
}
