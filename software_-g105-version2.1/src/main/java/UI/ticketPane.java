/*
 * Created by JFormDesigner on Sat Mar 26 23:52:49 CST 2022
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.*;

/**
 * @author zyk
 * @version 2.1
 */
//public class ticketPane extends JFrame  {
public class ticketPane extends JPanel{
    
    public ticketPane() {

        initComponents();
        this.setSize(900,600);
       // this.setVisible(true);
    }

    public static void main(String[] args) {
        new ticketPane();
    }


    private void Next(ActionEvent e) {
        // TODO add your code here
        //ticketpaneController tpCon =new ticketpaneController();
        //tpCon.clickNext();
    //  new MessageDialog("print information");
       boolean BoardingPass=checkBox1.isSelected();
       boolean Tag=checkBox2.isSelected();
       boolean CounteTticket=checkBox3.isSelected();
        String text = "boarding pass:"+checkBox1.isSelected()+"\ntag:"+checkBox2.isSelected()+"\ncounter ticket:"+checkBox3.isSelected();
        String title;
        title=" print information";
        int x = JOptionPane.showConfirmDialog(null,
                text, title, JOptionPane.OK_CANCEL_OPTION); //ok 0 cancel 2
        if (x == 0) {
            System.out.println("ok");
           //printpane P= new printpane();
          // P.setVisible(true);
           // this.dispose();
           // printpane p=new printpane(BoardingPass,Tag,CounteTticket);
           // p.setVisible(true);
            ProgressPane p=new ProgressPane(BoardingPass,Tag,CounteTticket);
            p.setVisible(true);
           // p.Printprogress();
           // new printpane(BoardingPass,Tag,CounteTticket).show();

           // new printpane().initComponents(true,true,true)
        } else if (x == 2) {
            System.out.println("cancel");
        }

    }
    private void Cancel(ActionEvent e){
      //  this.dispose();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        //ResourceBundle bundle = ResourceBundle.getBundle("com.company.Boundary.form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        panel3 = new JPanel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
       // this.setResizable(false);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // Container contentPane = getContentPane();
       // Container contentPane=new Container();
      // contentPane.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        /*   dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );*/
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout(3, 0));

                //======== panel1 ========
                {
                    panel1.setLayout(new GridLayout(2, 0));

                    //---- label1 ----
                    label1.setText(" ");
                    panel1.add(label1);

                    //---- label2 ----
                    label2.setText("Please choose the tickets to print");
                    panel1.add(label2);
                }
                contentPanel.add(panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(2, 0));

                    //---- label3 ----
                    label3.setText("ticket information here");
                    panel2.add(label3);

                    //======== scrollPane1 ========
                    {

                        //---- textArea1 ----
                        textArea1.setEditable(false);
                        scrollPane1.setViewportView(textArea1);
                    }
                    panel2.add(scrollPane1);
                }
                contentPanel.add(panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout(0, 3));

                    //---- checkBox1 ----
                    checkBox1.setText("boarding pass");
                    checkBox1.setSelected(true);

                  //  checkBox1.setDisabledIcon(checkBox1);
                    panel3.add(checkBox1);

                    //---- checkBox2 ----
                    checkBox2.setText("bag tag");
                    panel3.add(checkBox2);

                    //---- checkBox3 ----
                    checkBox3.setText("counter ticket");
                    panel3.add(checkBox3);
                }
                contentPanel.add(panel3);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("Next");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Next(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                                               @Override
                                               public void actionPerformed(ActionEvent e) {
                                                   Cancel(e);
                                               }
                                           });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        //
        this.add(dialogPane, BorderLayout.CENTER);
        setSize(900, 605);
        //setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        String fNo="MU0012";
        String departTime="2022/1/1 12:00:00";
        String arrTime="2022/1/1 14:00";
        String departure="Kunming";
        String arrival="Shanghai";
        String name="Xiaoming";
        String seat="32A";

 textArea1.append("\nFlight number:"+fNo+
         "\nTime:"+departTime+"--"+arrTime+
         "\nDeparture:"+departure+"\tArrival:"+arrival+
         "\nName:"+name+
         "\nSeat:"+seat);



 this.setVisible(true);


        //==========add image???
      //  Image i=new ImageIcon("image/cat.jpg").getImage();
     /*   ImageIcon logoIcon = new ImageIcon(new ImageIcon("image/cat.jpg").getImage().getScaledInstance(30, 25,Image.SCALE_SMOOTH));
        label4.setIcon(logoIcon);
        panel2.add(label4,2);*/
        /* checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBox1.isSelected()==true){
                    System.out.println("barding pass");
                }
            }
        });*/


        //澶嶉�夋鐩戝惉鍣�
       // checkBox1=(CheckBox) findViewById(R.id.cb_one);
       /* checkBox1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 鑾峰彇浜嬩欢婧愶紙鍗冲閫夋鏈韩锛�
                JCheckBox checkBox = (JCheckBox) e.getSource();
                System.out.println(checkBox.getText() + " 鏄惁閫変腑: " + checkBox.isSelected());
            }
        });
        checkBox2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 鑾峰彇浜嬩欢婧愶紙鍗冲閫夋鏈韩锛�
                JCheckBox checkBox = (JCheckBox) e.getSource();
                System.out.println(checkBox.getText() + " 鏄惁閫変腑: " + checkBox.isSelected());
            }
        });*/

    }

  //  private void setResizable(boolean b) {
   // }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel panel3;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
