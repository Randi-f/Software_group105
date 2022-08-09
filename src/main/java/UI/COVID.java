package UI;
/**
 * @author Shihan Fu, Yixuan Wang
 * @version 3.0
 * This is COVID frame
 * update 5.21
 */

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UI.BackgroundPanel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class COVID extends JFrame implements ActionListener {

	private JPanel COVIDPanel;
	private JTable COVIDtable;
	public JButton ReturnBT;
	public JButton button;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					COVID frame = new COVID();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Show information about COVID
	 */
	public COVID() {
		setTitle("covid-19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 444);
		COVIDPanel = new JPanel();
		COVIDPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(COVIDPanel);
		COVIDPanel.setLayout(null);
		
		JScrollPane COVIDscrollPane = new JScrollPane();
		COVIDscrollPane.setBounds(57, 80, 476, 113);
		COVIDPanel.add(COVIDscrollPane);
		
		COVIDtable = new JTable();
		setFont(UIStyle.TINY_ARIAL_BOLD);
		COVIDscrollPane.setViewportView(COVIDtable);
		COVIDtable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Beijing", "010-12345"},
				{"Tianjin", "022-12345"},
				{"Hebei", "0311-66165958"},
				{"Shanxi", "0351-12345"},
				{"LiaoNing", "024-12345"},
				{"JiLin", "0431-12320"},
				{"HeilongJiang", "0451-12345"},
				{"Shanghai", "021-12320"},
				{"Jiangsu", "025-12320"},
				{"FuJian", null},
				{null, null},
			},
			new String[] {
				"city", "Tel"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel CHINALb = new JLabel("CHINA");
		CHINALb.setBounds(55, 54, 65, 15);
		COVIDPanel.add(CHINALb);
		
		JLabel BRITAINLb = new JLabel("BRITAIN");
		BRITAINLb.setBounds(55, 213, 89, 24);
		COVIDPanel.add(BRITAINLb);
		
		JScrollPane COVIDscrP = new JScrollPane();
		COVIDscrP.setBounds(55, 257, 483, 111);
		COVIDPanel.add(COVIDscrP);
		
		JTextPane textPane = new JTextPane();
		COVIDscrP.setViewportView(textPane);
		textPane.setText("Johnson's statement to the house of Commons on Scotland's latest epidemic prevention policy:\n1. Masks will no longer be mandatory in public places, but the mayor of London has confirmed that masks are still mandatory for transportation in London, including the subway\n2. People are no longer required to work from home and should negotiate with employers that they return to the offic\n3. Middle school students will no longer need to wear masks in the classroom, and said the Ministry of education will soon cancel the requirement to use masks in public areas\n4. It is no longer mandatory to use vaccine passes to enter places and activities\n5. Restrictions on visiting nursing homes will be relaxed");
		
		
		JButton button = new JButton();
		button.setIcon(new ImageIcon(UIStyle.instr));
		button.setBounds(503, 20, 49, 50);
		COVIDPanel.add(button);
		
		ReturnBT = new JButton("return");
		ReturnBT.setBounds(455, 378, 97, 23);
		ReturnBT.addActionListener(this);
		COVIDPanel.add(ReturnBT);
		COVIDtable.getColumnModel().getColumn(0).setPreferredWidth(88);
		COVIDtable.getColumnModel().getColumn(1).setPreferredWidth(96);
		
		Image icon;
		icon=new ImageIcon(UIStyle.backgroundImg).getImage();
		COVIDPanel = new BackgroundPanel(icon);
		
	}
	
	@Override
	/**
	 * if return button is pushed, retrun to HOME page
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ReturnBT){
			this.dispose();
			Home home = new Home();
		}

	}
}
