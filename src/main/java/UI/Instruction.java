package UI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * brief instrutions about the procees using the system
 * @version 1.0
 * @author Yixuan Wang, Shihan Fu
 */
public class Instruction extends JFrame implements ActionListener {
	
    public static void main(String[] args){
        Instruction lo = new Instruction();
    }
    
    public Instruction() {
        //this.setVisible(true);
        initComponents();
        this.setSize(800,600);
    }

    public void initComponents(){
        Image image = new ImageIcon(UIStyle.logo).getImage();
        this.setIconImage(image);
        Image image1 = new ImageIcon(UIStyle.instruction).getImage();
        panel2 = new BackgroundPanel(image1);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);


        panel2.setLayout(null);
        contentPane.add(panel2);
        panel2.setBounds(0, 0, 598, 568);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        panel2.setBounds(0,0,790,600);
        
        JTextPane instructionTextPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 34, 452, 246);
		scrollPane.setViewportView(instructionTextPane);
		instructionTextPane.setEditable(false);
		instructionTextPane.setText("1. Home Page\r\nYou can choose login, read COVID information or read the instructions of the system at Home Page.\r\n\r\n2. Login system\r\nThere are three different ways for you to login: use BookingNo, ID + Surname or  Scan ID document.\r\n\r\n3. Main Page\r\n3.1  Choose the Flight that you want to check-in\r\n  After entering Flight page, there is a list indicating all the flights you have reserved. If you want to check-in one flight, you need to click relevant row. \r\n3.2 Seat\r\n On the left side of the page, there are five icons revealing five sorts of seats (available, unavailable, chosen, emergency seat, bigger legroom). On the right side, there is an image of seats in the plane, at this moment, you should click one seat that meets your own interest.\r\n3.3 Food\r\nAfter choosing your seat, you need to choose your food. On the left side, there are two sheets indicating different foods. There are free and special for you. You can choose something fits your own flavour. If you choose something special, then you need to pay for them. There is a bar of menu you have ordered on the right side, you are also able to modify it through that bar.\r\n3.4 Ticket\r\nAll the information will be displayed here. You can choose tick box \u201Cboarding pass\u201D, \u201Cbag tag\u201D or \u201Ccounter ticket\u201D for printing.\r\n3.5 Final\r\nAfter final confirm that you have receivedd all the things you need for check-in, the system will return to Home Page automatically.\r\nHave a nice journey!");
		contentPane.add(instructionTextPane);
        
        pack();
        setLocationRelativeTo(getOwner());

    }
    
    public void getInnerclass() {
    	Instruction_Home hm = new Instruction_Home();
    	hm.setVisible(true);
    }

    private JPanel panel2;

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
    public class Instruction_Home extends JFrame {

    	private JPanel instructionPanel;


    	/**
    	 * Create the frame for instructions of the whole system at Home page.
    	 */
    	public Instruction_Home() {
    		setFont(UIStyle.TINY_ARIAL_BOLD);
    		setTitle("instructions");
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		setBounds(100, 100, 540, 360);
    		instructionPanel = new JPanel();
    		instructionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    		setContentPane(instructionPanel);
    		instructionPanel.setLayout(null);
    		
    		JScrollPane scrollPane = new JScrollPane();
    		scrollPane.setBounds(35, 34, 452, 246);
    		instructionPanel.add(scrollPane);
    		
    		JTextPane instructionTextPane = new JTextPane();
    		scrollPane.setViewportView(instructionTextPane);
    		instructionTextPane.setEditable(false);
    		instructionTextPane.setText("1. Home Page\r\nYou can choose login, read COVID information or read the instructions of the system at Home Page.\r\n\r\n2. Login system\r\nThere are three different ways for you to login: use BookingNo, ID + Surname or  Scan ID document.\r\n\r\n3. Main Page\r\n3.1  Choose the Flight that you want to check-in\r\n  After entering Flight page, there is a list indicating all the flights you have reserved. If you want to check-in one flight, you need to click relevant row. \r\n3.2 Seat\r\n On the left side of the page, there are five icons revealing five sorts of seats (available, unavailable, chosen, emergency seat, bigger legroom). On the right side, there is an image of seats in the plane, at this moment, you should click one seat that meets your own interest.\r\n3.3 Food\r\nAfter choosing your seat, you need to choose your food. On the left side, there are two sheets indicating different foods. There are free and special for you. You can choose something fits your own flavour. If you choose something special, then you need to pay for them. There is a bar of menu you have ordered on the right side, you are also able to modify it through that bar.\r\n3.4 Ticket\r\nAll the information will be displayed here. You can choose tick box \u201Cboarding pass\u201D, \u201Cbag tag\u201D or \u201Ccounter ticket\u201D for printing.\r\n3.5 Final\r\nAfter final confirm that you have receivedd all the things you need for check-in, the system will return to Home Page automatically.\r\nHave a nice journey!");
    		
    		JButton returnBt = new JButton("return");
    		returnBt.addActionListener(new ActionListener() {
    			 public void actionPerformed(ActionEvent e) {
    				 dispose();

    			 }
    			 });	
    		returnBt.setBounds(206, 290, 97, 23);
    		instructionPanel.add(returnBt);
    	}
}}
