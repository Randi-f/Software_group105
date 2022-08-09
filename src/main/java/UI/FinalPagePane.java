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
 * @author YUnkai Li, Shihan Fu
 * @version 3.0
 * This is final page FinalPagePanePanel
 * update 5.21
 */

public class FinalPagePane extends JPanel {

	 int foodPaneWidth=UIStyle.foodPaneWidth;
	 int foodPaneHeight=UIStyle.foodPaneHeight;

	 ImageIcon icon;
	 Image img;
	 

	public FinalPagePane(MainFrame mainFrame) {
		
		initComponents();
		this.setVisible(true);
		this.setSize(900,600);
		
		setFont(UIStyle.TINY_ARIAL_BOLD);
		
		icon=new ImageIcon(UIStyle.backgroundImg);
		img=icon.getImage();
		JButton OKBt = new JButton("OK");
		
		OKBt.setBackground(new Color(240, 255, 255));
		OKBt.setFont(new Font("Arial", Font.BOLD, 12));
		add(OKBt);
		OKBt.setBounds(281, 297, 90, 23);
		
		JButton sendFeedbackBt = new JButton("Send Feedback");
		sendFeedbackBt.setBackground(new Color(255, 182, 193));
		sendFeedbackBt.setFont(new Font("Arial", Font.BOLD, 12));
		add(sendFeedbackBt);
		sendFeedbackBt.setBounds(477, 297, 150, 23);
		
		JLabel remindLb = new JLabel("Please take Your Belongings with You");
		add(remindLb);
		remindLb.setFont(new Font("Arial", Font.BOLD, 22));
		remindLb.setBounds(208, 199, 468, 26);						
		
		sendFeedbackBt.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 feedback fb=new feedback();
				 fb.setVisible(true);
			 }
			 });	
		OKBt.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				//Home home = new Home();
			 }
			 });
	}
	
	/**
	 * Create the FinalPagePanePanel of the end of check-in.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
	}
	
	public void initComponents() {
		setLayout(null);
		
		JLabel thankLb = new JLabel("THANK YOU FOR CHECKING IN");
		add(thankLb);
		thankLb.setFont(new Font("Arial", Font.BOLD, 29));
		thankLb.setBounds(218, 121, 469, 38);

		this.setVisible(true);
		
	}
}
