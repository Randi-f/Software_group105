package UI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.*;
/**
 * @author unknown
 */
public class Home extends JFrame implements ActionListener {

	public static void main(String[] args){
		Home home= new Home();
	}

	public Home() {
		this.setVisible(true);
		this.setSize(800,600);
		initComponents();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initComponents() {

		panel1 = new JPanel();
		panel2 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label1 = new JLabel();
		panel3 = new JPanel();
		label2 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));

		//======== panel1 ========
		{
			panel1.setLayout(null);


		}
		contentPane.add(panel1);

		//======== panel2 ========
		{
			panel2.setLayout(null);

			//---- button1 ----
			button1.setText("text");
			button1.addActionListener(this);
			panel2.add(button1);
			button1.setBounds(60, 250, 150, 50);

			//---- button2 ----
			button2.setText("text");
			button2.addActionListener(this);
			panel2.add(button2);
			button2.setBounds(60, 325, 150, 50);

			//---- button3 ----
			button3.setText("text");
			button3.addActionListener(this);
			panel2.add(button3);
			button3.setBounds(60, 400, 150, 50);

			//---- label1 ----
			label1.setText("Welcome to London Healthrow Airport");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			panel2.add(label1);
			label1.setBounds(0, 45, 265, 30);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel2.getComponentCount(); i++) {
					Rectangle bounds = panel2.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = 50+Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel2.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel2.setMinimumSize(preferredSize);
				panel2.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(panel2);

		//======== panel3 ========
		{
			panel3.setLayout(null);

			//---- label2 ----
			label2.setText("2020-03-28");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			panel3.add(label2);
			label2.setBounds(0, 0, 265, 30);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel3.getComponentCount(); i++) {
					Rectangle bounds = panel3.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel3.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel3.setMinimumSize(preferredSize);
				panel3.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(panel3);
		pack();
		setLocationRelativeTo(getOwner());
	}
	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	private JPanel panel3;
	private JLabel label2;

	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource()==button1){
				System.out.println("hello");
				this.dispose();
				LoginMethod loginMethod = new LoginMethod();
			}
			else if (e.getSource()==button2){
				this.dispose();
			}
			else if (e.getSource()==button3){
				this.dispose();
			}
	}
}
