package UI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wechatGUI extends JFrame{
	
	public wechatGUI() {
	       this.setVisible(true);
	       initComponents();
	       this.setSize(900,600);
	       this.setVisible(true);
	   }
	private void initComponents() {
		
		JFrame k = new JFrame("PAY!PAY!");
	    k.setVisible(true);
	    k.setSize(700,700);
	    //k.setLocation(500,200);
	    JLabel jl1 =new JLabel(new ImageIcon("C:\\Users\\lenovo\\Desktop\\AA.jpg"));
	    jl1.setBounds(212, 10, 97, 203);
	    //panel2.add(lblNewLabel_1);
	    
	    k.add(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Desktop\\AA.jpg")));
	    k.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JButton jb = new JButton("ok");
	    jb.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame("next page");
			 }
			 });
	    k.add(jb);
	    pack();
	}
	
}
