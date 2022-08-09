package UI;

import UI.Component.BottomBar;
import UI.Component.Picture;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @version 1.1
 * @author: zyc
 * @date: 2022/25
 */
public class wechatGUI extends JFrame{
	int payW=900,payH=800;
	boolean check = false;

	public wechatGUI() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		initComponents();
		this.setBounds((int)((UIStyle.ScreenWidth - payW)/2), (int)(UIStyle.ScreenHeight - payH)/2, (int) payW, (int)payH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	
	private void initComponents() {

		JLabel QR = new JLabel(new ImageIcon(UIStyle.QRcode));
		JPanel p1 = new JPanel();
		p1.add(QR);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3,1));
		JLabel instruction = new JLabel("Please confirm after completion of payment");
		instruction.setFont(new Font("Arial",Font.BOLD,6));
		JButton confirm = new JButton("confirm");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuBar.getController().confirmPage("Bill","Scan IDcard");
				BottomBar.getController().setConfirmPage("Scan IDcard",ScanPanel.confirm);
			}
		});
		JButton cancel = new JButton("cancel");
		cancel.setFont(UIStyle.TINY_ARIAL_BOLD);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		p2.add(instruction);
		p2.add(confirm);
		p2.add(cancel);
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.EAST);
	}

	public void paychecked(){
		check = true;
	}

	public boolean getCheck(){
		//dispose();
		return check;
	}

}
