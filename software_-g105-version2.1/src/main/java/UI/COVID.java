package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UI.BackgroundPanel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class COVID extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	 * Create the frame.
	 */
	public COVID() {
		setTitle("covid-19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 80, 476, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
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
		
		JLabel lblNewLabel = new JLabel("CHINA");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 19));
		lblNewLabel.setBounds(55, 54, 65, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BRITAIN");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(55, 213, 89, 24);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(55, 257, 483, 111);
		contentPane.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textPane.setText("\u7EA6\u7FF0\u900A\u7ED9\u4E0B\u8BAE\u4F1A\u8BAE\u9662\u7684\u4E00\u4EFD\u58F0\u660E\u4E2D\u5173\u4E8E\u82CF\u683C\u5170\u6700\u65B0\u9632\u75AB\u653F\u7B56\uFF1A\r\n\r\n\u200B1. \u5C06\u4E0D\u518D\u5F3A\u5236\u8981\u6C42\u5728\u516C\u5171\u573A\u6240\u6234\u53E3\u7F69\uFF0C\u4F46\u4F26\u6566\u5E02\u957F\u5DF2\u786E\u8BA4\u5728\u4F26\u6566\u5305\u62EC\u5730\u94C1\u5728\u5185\u7684\u4EA4\u901A\u8FD0\u8F93\u4ECD\u5F3A\u5236\u4F69\u6234\u53E3\u7F69\r\n\r\n\u200B2. \u4E0D\u518D\u8981\u6C42\u4EBA\u4EEC\u5C45\u5BB6\u529E\u516C\uFF0C\u5E76\u5E94\u4E0E\u96C7\u4E3B\u5546\u8BAE\u4ED6\u4EEC\u8FD4\u56DE\u529E\u516C\u5BA4\u529E\u516C\r\n\r\n\u200B3. \u4E2D\u5B66\u751F\u5C06\u4E0D\u518D\u9700\u8981\u5728\u6559\u5BA4\u91CC\u6234\u53E3\u7F69\uFF0C\u5E76\u8868\u793A\u6559\u80B2\u90E8\u5C06\u5F88\u5FEB\u53D6\u6D88\u5173\u4E8E\u5728\u516C\u5171\u533A\u57DF\u4F7F\u7528\u53E3\u7F69\u7684\u8981\u6C42\r\n\r\n\u200B4. \u4E0D\u518D\u5F3A\u5236\u8981\u6C42\u4F7F\u7528\u75AB\u82D7\u901A\u884C\u8BC1\u8FDB\u5165\u573A\u6240\u548C\u6D3B\u52A8\r\n\r\n\u200B5. \u5C06\u653E\u5BBD\u63A2\u8BBF\u62A4\u7406\u9662\u7684\u9650\u5236");
		
		JButton button = new RoundButton("?");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		JButton btnNewButton = new JButton("?");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 27));
		button.setBounds(503, 20, 49, 50);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.setBounds(455, 378, 97, 23);
		contentPane.add(btnNewButton_1);
		table.getColumnModel().getColumn(0).setPreferredWidth(88);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		
		ImageIcon icon;
		Image image1;
		icon=new ImageIcon(getClass().getResource("2.jpeg"));
		image1=icon.getImage();
		//Image image1 = new ImageIcon("E:\\Software Engineering\\AutomaticCheckin\\pic\\2.jpg").getImage();
		contentPane = new BackgroundPanel(image1);
		
	}
}
