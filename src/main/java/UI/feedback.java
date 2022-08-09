package UI;
/**
 * @author Shihan Fu
 * @version 3.0
 * This is Feedback frame
 * update 5.21
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import javax.swing.*;




public class feedback extends JFrame {	
	private JPanel feedbackPanel;
	private JTextField commentsTextField;
	JButton sendBt = new JButton("send ");
	JButton cancelBt = new JButton("cancel");
	JTextPane commentTextPane = new JTextPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		feedback fb=new feedback();
		fb.setVisible(true);
	}
   int feedW=528,feedH=347;
	/**
	 * Create the frame for passenger to send feedback.
	 */
	public feedback() {
		setFont(UIStyle.TINY_ARIAL_BOLD);
		setTitle("feedback");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)((UIStyle.ScreenWidth - feedW)/2), (int)(UIStyle.ScreenHeight - feedH)/2, (int) feedW, (int)feedH);

		feedbackPanel = new JPanel();
		feedbackPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(feedbackPanel);
		feedbackPanel.setLayout(null);
		
		JLabel commentsLb = new JLabel("Please put in your valuable comments");
		commentsLb.setBounds(10, 32, 477, 24);
		feedbackPanel.add(commentsLb);
		
		JLabel telNoLb = new JLabel("telNo:");
		telNoLb.setBounds(10, 235, 65, 22);
		feedbackPanel.add(telNoLb);
		
		commentsTextField = new JTextField();
		commentsTextField.setBounds(85, 237, 174, 21);
		feedbackPanel.add(commentsTextField);
		commentsTextField.setColumns(10);
		
		
		sendBt.setBounds(287, 277, 97, 23);
		feedbackPanel.add(sendBt);

		cancelBt.setBounds(407, 277, 97, 23);
		feedbackPanel.add(cancelBt);
		
		
		commentTextPane.setBounds(10, 66, 494, 143);
		feedbackPanel.add(commentTextPane);
		
		sendBt.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				String feedback = commentTextPane.getText();
				String telNo = commentsTextField.getText();
				SendFeedback(feedback+"_"+telNo+";");
				System.out.println(feedback);
				setVisible(false);
			 }
			 });
		cancelBt.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setVisible(false);
			 }
			 });
	}
	
	public void SendFeedback(String Tel_Feedback) {
		try {
			//String content = "a dog will be write in file";
			File file = new File("./data/feedback.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(Tel_Feedback);
			bw.close();
			System.out.println("finish");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	
	}
   

	
}
