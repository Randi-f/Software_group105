package UI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import controller.*;
import UI.Component.BottomBar;
import utils.ThreadHandler;


/**
 * <p>This is flight information pane,used to show flight basic information,
 * user can query a flight by keyword ,
 * see flight detail information and select flight</p>
 * @author Zhang Yike
 * @version 5.0
 *
 */
public class FlightInfoPane extends Panel {
    private JPanel outerP;
    private JPanel mainP;
    private JPanel titleP;
    private JPanel midP;
    private JPanel queryP;
    private JPanel buttonBar;
    
    private JScrollPane tableScroll;
    
    private JLabel titleLb;
    private JTable flightTable;    
    private JLabel queryHintTxtLb;
    private JLabel queryLb;
    
    private JTextField queryTxtField;
    
    private JComboBox searchBox;
    
    private JButton nextBt;
    public static JButton cancelButton;
    private JButton queryButton;   
    private JButton instrButton;
    
    public FlightInfoPane(MainFrame mainframe) throws IOException {
        System.out.println("hello flignt");
        int a=Login.type;
        System.out.println("begin Flight Info : pNo-"+Login.pNo);
        System.out.println("begin Flight Info : bNo-"+Login.bNo);
        if(a==1||a==2)
            initComponents(Login.pNo,a,mainframe);
        else if(a==3)
            initComponents(Login.bNo,a,mainframe);
        this.setSize(900,600);
    }

    public JButton getNextBt() {
        return nextBt;
    }
    
    /**
     * This is used to select a flight to check in
     * @param e click confirm button
     */

    private void ok(ActionEvent e) {

        try{
            int index1 = flightTable.getSelectedRow();
            System.out.println(index1);
            Object ob=flightTable.getValueAt(index1,0);
            String value=String.valueOf(ob);
            
            if(!FliInfoController.verifyCheck(value)){
                JOptionPane.showConfirmDialog(null,"It is not check-in time, please change another flight!", "Notice", JOptionPane.OK_CANCEL_OPTION); //ok 0 cancel 2
            }
            else{
            //System.out.println(value);//}
            String text = "Do you want to choose flight "+value+"?";
            String title;
            title="Select flight";
            int x = JOptionPane.showConfirmDialog(null,
                    text, title, JOptionPane.OK_CANCEL_OPTION); //ok 0 cancel 2

            // click ok
            if (x == 0) {
                System.out.println("ok");

                FlightController.getController().setFlightByFlightNo(value);//input bkNo,set flight,
                //after a certain flight and booking, initialize the choices
                BookingController.getController().setBookingByID_No(Login.pNo,value);
                SeatsController.getController().getSeatsPanel().setContent();
                if(FlightController.getController().isFlightGotten()==false){
                    FlightController.getController().setFlightGotten(true);
                }
                MenuBar.getController().confirmPage("Flight","SeatChoice");
                BottomBar.getController().setConfirmPage("SeatChoice",SeatChoicePanel.confirm);
            }
            //click cancel
            else if (x == 2) {
                System.out.println("cancel");
                return;

            }}}
        catch (IndexOutOfBoundsException | IOException | ParseException e1){
            System.out.println(e1);

            JOptionPane.showConfirmDialog(null,
                    "You haven't choose a flight yet,please try again.", "Please make your choice", JOptionPane.YES_OPTION); //ok 0 cancel 2

        }}

    /**
     * This is used to cancel when select a flight
     * @param e click cancel
     */
    private void cancel(ActionEvent e) {
    	
        System.out.println("click cancel");
        
    }

    /**
     * This is used to show instruction when user click instruction
     * @param e click instruction
     */
    private void Instr(ActionEvent e){
        JOptionPane.showMessageDialog(null, " 1. Please click table to see flight information" +
                "  2.Please click table header to sort flight" +
                "  3.Please choose one flight and click Next to choose your flight  ", " Instruction", JOptionPane.INFORMATION_MESSAGE);
    }

    private void initComponents(String number,int a, MainFrame mainframe) throws IOException {

        outerP = new JPanel();
        mainP = new JPanel();
        titleP = new JPanel();
        titleLb = new JLabel( );
        midP = new JPanel();
        tableScroll = new JScrollPane();
        flightTable = new JTable();
        queryP = new JPanel();
        queryHintTxtLb = new JLabel();
        buttonBar = new JPanel();
        nextBt = new JButton();
        cancelButton = new JButton();

        searchBox=new JComboBox();
        queryButton=new JButton();
        queryLb =new JLabel();
        queryTxtField=new JTextField();
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
        outerP = new BackgroundPanel(image1);
        instrButton=new JButton();



        //======== this ========
        this.setLayout(new BorderLayout());

        //======== outerP ========
        {
            outerP.setBorder(new EmptyBorder(12, 12, 12, 12));
            outerP.setLayout(new BorderLayout());
//            outerP.setOpaque(false);

            //======== mainP ========
            {
                mainP.setLayout(new GridLayout(3, 0));
                mainP.setOpaque(false);

                //======== titleP ========
                {
                    titleP.setLayout(null);
                    titleP.setOpaque(false);

                    //---- label2 ----
                    titleLb.setText("Please choose your flight");
                    titleLb.setFont(new Font("Arial",Font.PLAIN,33));//Setting the text font
                    titleLb.setForeground(Color.black);
                    titleLb.setBounds(10,10,600,50);
                    titleP.add(titleLb);
                    //---instrButton---
                    instrButton.setText("Instructions");
                    instrButton.setFont(UIStyle.TINY_ARIAL_BOLD);
                    instrButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Instr(e);
                        }
                    });
                    instrButton.setIcon(new ImageIcon(UIStyle.instr));
                    instrButton.setContentAreaFilled(false);
                    instrButton.setBounds(750,10,150,50);
                    titleP.add(instrButton);
                }
                mainP.add(titleP);

                //======== midP ========
                {
                    midP.setLayout(new GridLayout());
                    midP.setOpaque(false);

                    //======== tableScroll ========
                    {
                        tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                        //---- flightTable ----
                        flightTable.setGridColor(Color.gray);

                        tableScroll.setViewportView(flightTable);
                    }
                    midP.add(tableScroll);
                }
                mainP.add(midP);

                //======== queryP ========
                {
                    // queryP.setLayout(new GridLayout(2,3));
                    // queryP.setLayout(new BorderLayout());
                    queryP.setLayout(null);
                    queryP.setOpaque(false);

                    //---label4---
                    queryLb.setText("Please choose type you want to query");
                    queryLb.setFont(UIStyle.SMALL_ARIAL_BOLD);
                    // queryP.add(label4,BorderLayout.NORTH);
                    queryLb.setBounds(10,100,250,30);
                    queryP.add(queryLb);
                    //---searchBox---
                    searchBox.addItem("search");
                    searchBox.addItem("see all");
                    //searchBox.addItem("booking number");
                    searchBox.setBounds(360,100,120,30);

                    queryP.add(searchBox);
                    queryTxtField.setBounds(510,100,200,30);
                    // queryP.add(queryTxtField,BorderLayout.CENTER);
                    queryP.add(queryTxtField);
                    //---queryButton---
                    queryButton.setText("Query");
                    queryButton.setFont(UIStyle.TINY_ARIAL_BOLD);
                    queryButton.setBounds(800,100,100,30);
                    queryP.add(queryButton);
                    // queryP.add(queryButton,BorderLayout.EAST);

                    //---- label3 ----
                    queryHintTxtLb.setText("================You can search your flight information by keyword here=================");
                    queryHintTxtLb.setFont(UIStyle.TINY_ARIAL_BOLD);
                    queryHintTxtLb.setBounds(10,10,800,30);
                    queryP.add(queryHintTxtLb,BorderLayout.NORTH);
                }
                mainP.add(queryP);
            }
            outerP.add(mainP, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                buttonBar.setOpaque(false);
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                nextBt.setText("Next");
                nextBt.setFont(UIStyle.TINY_ARIAL_BOLD);
                nextBt.addActionListener(e -> ok(e));
                buttonBar.add(nextBt, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.setFont(UIStyle.TINY_ARIAL_BOLD);
                //cancelButton.addActionListener(e -> cancel(e));
                cancelButton.addActionListener(new ActionListener() {
       			 public void actionPerformed(ActionEvent e) {
       				 mainframe.dispose();
                     ThreadHandler.shutTimer();
       				LoginMethod lg = new LoginMethod();

       			 }
       			 });	
//                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 0, 0), 0, 0));
            }
//            outerP.add(buttonBar, BorderLayout.SOUTH);
        }
        this.add(outerP, BorderLayout.CENTER);
        setSize(UIStyle.width-UIStyle.division-UIStyle.flightGraphWidth,UIStyle.flightGraphHeight);
        flightTable=new JTable(FliInfoController.getController().table1Controller(number,a));
        TableRowSorter sorter=new TableRowSorter(FliInfoController.getController().table1Controller(number,a));
        flightTable.setRowSorter(sorter);
        flightTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //jTable1MouseClicked(evt);
                int index2 = flightTable.getSelectedRow();
                Object ob=flightTable.getValueAt(index2,0);
                System.out.println(ob);
                String value=String.valueOf(ob);
                System.out.println(value);
                FlightDetail flightDetail=new FlightDetail(value);
            }
        });

        //------queryButtonActionListioner---------
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchBox.getSelectedItem()=="search"){
                    if("".equals(queryTxtField.getText())){
                        JOptionPane.showConfirmDialog(null,
                                "Please enter the keyword you want to search", "Warning", JOptionPane.OK_OPTION); //ok 0 cancel 2
                    }
                    else{
                        String des=queryTxtField.getText();
                        sorter.setRowFilter(RowFilter.regexFilter(des));
                    }

                }
                else if(searchBox.getSelectedItem()=="see all"){
                    try {
                        flightTable=new JTable(FliInfoController.getController().table1Controller(number,a));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    TableRowSorter sorter= null;
                    try {
                        sorter = new TableRowSorter(FliInfoController.getController().table1Controller(number,a));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    flightTable.setRowSorter(sorter);
                    tableScroll.setViewportView(flightTable);

                }

            }
        });
        tableScroll.setViewportView(flightTable);


        this.setVisible(true);
    }




    //set color for state
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(flightTable, value, isSelected, hasFocus, row, column);
            if(flightTable.getValueAt(row, column).equals("on time") && cell.isBackgroundSet()) {
                cell.setForeground(Color.GREEN);
            }
            else if(flightTable.getValueAt(row, column).equals("delay") && cell.isBackgroundSet()){
                cell.setForeground(Color.RED);
            }
            else {
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    };








}


