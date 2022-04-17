package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Shihan Fu
 * @version 2.0
 * This is feedback window
 */

public class feedback extends JFrame {
	//feedback frame = new feedback();
	//JFrame frame = new JFrame();
	private JPanel contentPane;
	private JTextField textField_1;
	//frame.add(contentPane);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		feedback fb=new feedback();
		fb.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public feedback() {
		
		setTitle("feedback");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please put in your valuable comments");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 32, 477, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("telNo:");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 235, 65, 22);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 237, 174, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("send ");
		btnNewButton.setBounds(287, 277, 97, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.setBounds(407, 277, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 66, 494, 143);
		contentPane.add(textPane);
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				String feedback = textPane.getText();
				System.out.println(feedback);
			 }
			 });
	}
}
