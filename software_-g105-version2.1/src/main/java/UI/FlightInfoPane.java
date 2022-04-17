package UI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import controller.*;
import entity.Flight;

/**
 * @author Zhang Yike
 * @version 2.0
 * This is flight information pane
 *CardLayout cards,String name,JPanel contentPanel
 */
public class FlightInfoPane extends Panel {
//public class FlightInfoPane extends JFrame {
    /*ywh
    CardLayout cards;
    JPanel contentPanel;*/
//    public FlightInfoPane() {
//        initComponents();
//    }
    public FlightInfoPane() throws IOException {
//        contentPanel.add(name,this);
//        this.cards=cards;
//        this.contentPanel=contentPanel;
        initComponents();
        this.setSize(900,600);
      //  this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws IOException {
        new FlightInfoPane();
    }

//this is for table clicked
/*
}*/

  private void ok(ActionEvent e) {
        // TODO add your code here
      //  String value;
        //Object ob;
      try{
        System.out.println("click ok");
        int index1 = table1.getSelectedRow();
        System.out.println(index1);
        //fliInfoController.toString()
       // int[] selRow=table1.
      //TableModel tm=table1.getModel();
      //  for(int i=0;i<3;i++){
        Object ob=table1.getValueAt(index1,0);
        String value=String.valueOf(ob);

        //if(value)
            System.out.println(value);//}
       // System.out.println(value);
        String text = "Do you want to choose flight "+value+"?";
        String title;
        title="Select flight";
        int x = JOptionPane.showConfirmDialog(null,
                text, title, JOptionPane.OK_CANCEL_OPTION); //ok 0 cancel 2
        
       // int x=0;
        if (x == 0) {
            System.out.println("ok");
            //step to next page
            //ywh
            //fsh
     

//step to ywh's page  use foodchoice for temporary

           // printpane P=new printpane(true,true,true);
            //P.setVisible(true);
        } else if (x == 2) {
            System.out.println("cancel");
           // x.setDefaultCloseOperation(JOptionPane.DISPOSE_ON_CLOSE);
          //  JOptionPane.
            return;

        }}
      catch (Exception e1){


          JOptionPane.showConfirmDialog(null,
                  "You haven't choose a flight yet,please try again.", "Please make your choice", JOptionPane.YES_OPTION); //ok 0 cancel 2

    }}

    private void cancel(ActionEvent e) {
        // TODO add your code here
        System.out.println("click cancel");
       // this.dispose();
        //back to previous page
      //  finalPage fp=new finalPage();
    }

    private void initComponents() throws IOException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        //ResourceBundle bundle = ResourceBundle.getBundle("D:\\Java\\software_-g105-main\\src\\main\\java\\UI\\form");
        dialogPane = new JPanel();
        thisl = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel( );
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel4 = new JPanel();
        label3 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        panel5=new JPanel();
        comboBox1=new JComboBox();
        queryButton=new JButton();
        label4=new JLabel();
        textField1=new JTextField();


        //======== this ========
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);
//        Container this = getContentPane();
        this.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
           /* dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
            awt.Font.BOLD,12),java.awt.Color.red),dialogPane. getBorder()))
            ;dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;*/
            dialogPane.setLayout(new BorderLayout());

            //======== thisl ========
            {
                thisl.setLayout(new GridLayout(3, 0));

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout());

                    //---- label2 ----
                    
                    //label2.setText(bundle.getString("FlightInfo.label2.text"));
                    label2.setText("Flight Information(Please choose your flightNo from table and click next)");
                    panel2.add(label2);
                }
                thisl.add(panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout());

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                        //---- table1 ----
                        table1.setGridColor(Color.gray);

                        scrollPane1.setViewportView(table1);
                    }
                    panel3.add(scrollPane1);
                }
                thisl.add(panel3);

                //======== panel4 ========
                {
                   // panel4.setLayout(new GridLayout(2,3));
                    panel4.setLayout(new BorderLayout());

                    //======panel5======
                    panel5.setLayout(new GridLayout(0,2));
                    //---label4---
                    label4.setText("Please choose type you want to query");
                    panel4.add(label4,BorderLayout.NORTH);
                    //---comboBox1---
                    comboBox1.addItem("search");
                    comboBox1.addItem("see all");
                    //comboBox1.addItem("booking number");
                    panel4.add(comboBox1,BorderLayout.WEST);
                   // comboBox1.addItem();
                    //---textField1---
                    //textField1.setText("hello");
                    panel4.add(textField1,BorderLayout.CENTER);
                    //---queryButton---
                    queryButton.setText("Query");
                    /*queryButton.addActionListener(new ActionListener() {

                    });*/
                    //Dimension preferredSize = new Dimension(4,10);
                  //  queryButton.setPreferredSize(preferredSize);
                    panel4.add(queryButton,BorderLayout.EAST);

                    //---- label3 ----
                    //label3.setText(bundle.getString("FlightInfo.label3.text"));
                    label3.setText("================You can search your flight information here=================");
                    panel4.add(label3,BorderLayout.NORTH);
                }
                thisl.add(panel4);
            }
            dialogPane.add(thisl, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                //okButton.setText(bundle.getString("FlightInfo.okButton.text"));
                okButton.setText("Next");
                okButton.addActionListener(e -> ok(e));
              //  okButton.addActionListener((ActionListener) this);
                /*okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	foodChoice fd = new foodChoice();
                     cards.show(contentPanel,"SeatChoice"); //ywh
           				fd.setVisible(true);
                        //ok(e);
                    }
                });*/
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                //cancelButton.setText(bundle.getString("FlightInfo.cancelButton.text"));
                cancelButton.setText("Cancel");
             //   cancelButton.addActionListener((ActionListener) this);
                cancelButton.addActionListener(e -> cancel(e));
               /*cancelButton.addActionListener(new ActionListener() {
       			 public void actionPerformed(ActionEvent e) {
       				foodChoice fd = new foodChoice();
       				fd.setVisible(true);
       			 }
       			 });*/
                
                /*
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancel(e);
                    }
                });*/
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        this.add(dialogPane, BorderLayout.CENTER);
        setSize(UIStyle.width-UIStyle.division-UIStyle.flightGraphWidth,UIStyle.flightGraphHeight);
//        this.setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
       // my code can write here
//         fliInfoController=new FliInfoController.getController()();
        table1=new JTable(FliInfoController.getController().table1Controller("12345"));
        TableRowSorter sorter=new TableRowSorter(FliInfoController.getController().table1Controller("12345"));
        table1.setRowSorter(sorter);
        //------queryButtonActionListioner---------
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                FliInfoController fliInfoController=new FliInfoController();
                if(comboBox1.getSelectedItem()=="search"){
                    // if(textField1.get)
                    if("".equals(textField1.getText())){
                        //  fliInfoController.filterByKeyword();
                        JOptionPane.showConfirmDialog(null,
                                "please enter flight number", "Warning", JOptionPane.OK_OPTION); //ok 0 cancel 2

                        // System.out.println("fno"+textField1.getText());
                    }
                    else{
                        String des=textField1.getText();
                       // DefaultRowSorter<Object, Object> sorter = null;
                        sorter.setRowFilter(RowFilter.regexFilter(des));
                     //   scrollPane1.setViewportView(table1);
                                  /*  ArrayList<String>flightNo=new ArrayList<>();
                                    flightNo.add(textField1.getText());
                                    FliInfoController f=new FliInfoController();
                                  ArrayList<Flight>flights=  f.getFlightInfoByFlightNo(flightNo);
                                    ArrayList<String>flightNos=getFlightNoBydocumentID(documentID);
                                    ArrayList<Flight>passengersFlight=getFlightInfoByFlightNo(flightNos);
                                    Object[][] rowData2=formatConver(passengersFlight);
                                  TableModel mmodel=f.formatConver(flights);*/




                        //  JOptionPane.showConfirmDialog(null,
                        //        "please enter flight number", "Warning", JOptionPane.OK_OPTION); //ok 0 cancel 2

                    }

                }
                else if(comboBox1.getSelectedItem()=="see all"){
                    try {
                        table1=new JTable(FliInfoController.getController().table1Controller("12345"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    TableRowSorter sorter= null;
                    try {
                        sorter = new TableRowSorter(FliInfoController.getController().table1Controller("12345"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    table1.setRowSorter(sorter);
                    scrollPane1.setViewportView(table1);

                }
              //  else if(comboBox1.getSelectedItem()=="booking number"){

               // }

            }
        });
        //String des="Beijing";
       // sorter.setRowFilter(RowFilter.regexFilter(des));
        scrollPane1.setViewportView(table1);


        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel thisl;
    private JPanel panel2;
    private JLabel label2;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel4;
    private  JPanel panel5;
    private JLabel label3;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JComboBox comboBox1;
    private JButton queryButton;
    private JLabel label4;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    //set color for state û�ɹ���
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table1, value, isSelected, hasFocus, row, column);
            if(table1.getValueAt(row, column).equals("on time") && cell.isBackgroundSet()) {
                cell.setForeground(Color.GREEN);
            }
            else if(table1.getValueAt(row, column).equals("delay") && cell.isBackgroundSet()){
                cell.setForeground(Color.RED);
            }
            else {
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    };





    //this is actionlinsener
//FliInfoController fliInfoController=new FliInfoController();
 //   table1=new JTable(12);


}
