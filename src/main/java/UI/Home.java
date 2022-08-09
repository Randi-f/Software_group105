package UI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * Initial page of the system
 * @Version 3.0
 * @author Yixuan Wang
 */
public class Home extends JFrame implements ActionListener {
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel midPanel;
	private JButton loginBt;
	private JButton epidemic;
	private JButton instruction;
	private JLabel logoLb;
	private JPanel rightPanel;
	private JLabel dateLb;

	public static void main(String[] args){
		new UIStyle();
		Home home= new Home();
	}

	public Home() {
		this.setVisible(true);
		this.setBounds((int)((UIStyle.ScreenWidth - UIStyle.HomeW)/2), (int)(UIStyle.ScreenHeight - UIStyle.HomeH)/2, (int) UIStyle.HomeW, (int) UIStyle.HomeH);

		initComponents();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initComponents() {
		mainPanel = new JPanel();
		panel1 = new JPanel();
		midPanel = new JPanel();
		loginBt = new JButton();
		epidemic = new JButton();
		instruction = new JButton();
		logoLb = new JLabel();
		rightPanel = new JPanel();
		dateLb = new JLabel();
		
		Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
		Image image2 = new ImageIcon(UIStyle.logo).getImage();
		mainPanel = new BackgroundPanel(image1);

		this.setIconImage(image2);

		//======== this ========
		Container contentPane = getContentPane();
		mainPanel.setLayout(new GridLayout(1, 3));


		//======== panel1 ========
		{
			panel1.setLayout(null);
			panel1.setOpaque(false);

		}
		mainPanel.add(panel1);

		//======== midPanel ========
		{
			midPanel.setOpaque(false);
			midPanel.setLayout(null);
			
			//---- loginBt ----
			loginBt.setText("Login");
			loginBt.setFont(UIStyle.TINY_ARIAL_BOLD);
			loginBt.setIcon(new ImageIcon(UIStyle.login));
			loginBt.addActionListener(this);
			loginBt.setContentAreaFilled(false);
			midPanel.add(loginBt);
			loginBt.setBounds(60, 250, 150, 50);

			//---- epidemic ----
			epidemic.setText("Epidemic Info");
			epidemic.setFont(UIStyle.TINY_ARIAL_BOLD);
			epidemic.addActionListener(this);
			epidemic.setIcon(new ImageIcon(UIStyle.info));
			epidemic.setContentAreaFilled(false);
			midPanel.add(epidemic);
			epidemic.setBounds(60, 325, 150, 50);

			//---- instruction ----
			instruction.setText("Instructions");
			instruction.setFont(UIStyle.TINY_ARIAL_BOLD);
			instruction.addActionListener(this);
			instruction.setIcon(new ImageIcon(UIStyle.instr));
			instruction.setContentAreaFilled(false);
			midPanel.add(instruction);
			instruction.setBounds(60, 400, 150, 50);

			//---- logoLb ----
			logoLb.setIcon(new ImageIcon(UIStyle.lHA));
			logoLb.setHorizontalAlignment(SwingConstants.CENTER);
			midPanel.add(logoLb);
			logoLb.setBounds(0, 45, 290, 90);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < midPanel.getComponentCount(); i++) {
					Rectangle bounds = midPanel.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = 50+Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = midPanel.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				midPanel.setMinimumSize(preferredSize);
				midPanel.setPreferredSize(preferredSize);
			}
		}
		mainPanel.add(midPanel);

		//======== rightPanel ========
		{
			rightPanel.setOpaque(false);
			rightPanel.setLayout(null);

			//---- dateLb ----
			Date date = new Date();
			dateLb.setText(String.valueOf(date.getYear()+1900)+"-"+String.valueOf(date.getMonth()+1)+"-"+String.valueOf(date.getDate()));
			dateLb.setHorizontalAlignment(SwingConstants.CENTER);
			rightPanel.add(dateLb);
			dateLb.setBounds(0, 0, 265, 30);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < rightPanel.getComponentCount(); i++) {
					Rectangle bounds = rightPanel.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = rightPanel.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				rightPanel.setMinimumSize(preferredSize);
				rightPanel.setPreferredSize(preferredSize);
			}
		}
		mainPanel.add(rightPanel);
		contentPane.add(mainPanel);
		pack();
		setLocationRelativeTo(getOwner());

	}


	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource()==loginBt){
				this.dispose();
				LoginMethod loginMethod = new LoginMethod();
			}
			else if (e.getSource()==epidemic){
				this.dispose();
				try {
					COVID frame = new COVID();
					frame.setVisible(true);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			else if (e.getSource()==instruction){
                Instruction instruction = new Instruction();
                instruction.getInnerclass();
                
			}
	}
}
