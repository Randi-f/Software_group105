/*
 * Created by JFormDesigner on Sat Mar 26 23:52:49 CST 2022
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.*;


public class ticketPane extends JPanel {
    
    public ticketPane() {

        initComponents();
        this.setSize(900,600);

    }

    private void Preview(ActionEvent e) throws ParseException {
        previewPanel pp=new previewPanel();
        pp.setVisible(true);

    }

    /**
     * This is used to get which ticket to print and show print progress
     * @param e click next button
     */
    private void Next(ActionEvent e) {

       /*boolean BoardingPass=checkBox1.isSelected();
       boolean Tag=checkBox2.isSelected();
       boolean CounteTticket=checkBox3.isSelected();
        String text = "boarding pass:"+checkBox1.isSelected()+"\ntag:"+checkBox2.isSelected()+"\ncounter ticket:"+checkBox3.isSelected();
        String title;
        title=" print information";
        int x = JOptionPane.showConfirmDialog(null,
                text, title, JOptionPane.OK_CANCEL_OPTION); //ok 0 cancel 2
        if (x == 0) {//click ok
            System.out.println("ok");
            ProgressPane p=new ProgressPane(BoardingPass,Tag,CounteTticket);
            p.setVisible(true);
        } else if (x == 2) {//click cancel
            System.out.println("cancel");
        }*/
        String BoardingPass;
        String Tag;
        String CounteTticket;
        if(checkBox1.isSelected()){BoardingPass="Yes";}
        else{BoardingPass="No";}
        if(checkBox2.isSelected()){Tag ="Yes";}
        else{Tag ="No";}
        if(checkBox3.isSelected()){CounteTticket="Yes";}
        else{CounteTticket="No";}


        String text = "boarding pass:"+BoardingPass+"\ntag:"+Tag+"\ncounter ticket:"+CounteTticket;
        String title;
        title=" print information";
        int x = JOptionPane.showConfirmDialog(null,
                text, title, JOptionPane.OK_CANCEL_OPTION); //ok 0 cancel 2
        if (x == 0) {//click ok
            System.out.println("ok");
            ProgressPane p=new ProgressPane(checkBox1.isSelected(),checkBox2.isSelected(),checkBox3.isSelected());
            p.setVisible(true);
        } else if (x == 2) {//click cancel
            System.out.println("cancel");
        }


    }

    

    /**
     * This is used to show instruction
     * @param e click instruction button
     */
    private void Instr(ActionEvent e){
        JOptionPane.showMessageDialog(null, " Please select the tickets you want to print and then click the Next button." +
                " You can click the Preview button to view the ticket preview ", " Instruction", JOptionPane.INFORMATION_MESSAGE);
    }



    @SuppressWarnings("deprecation")
	protected void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        titleLb = new JLabel();
        panel2 = new JPanel();
        ticketimageLb = new JLabel();
        tagimageLb = new JLabel();
        counterimageLb = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        panel3 = new JPanel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        buttonBar = new JPanel();
        nextBt = new JButton();
        cancelButton = new JButton();
        previewButton=new JButton();
        instrButton=new JButton();
        Image image1 = new ImageIcon(UIStyle.backgroundImg).getImage();
       contentPanel= new BackgroundPanel(image1);

        //======== this ========
        this.setLayout(new BorderLayout());


        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());
            dialogPane.setOpaque(false);

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout(3, 0));

                //======== panel1 ========
                {
                    panel1.setLayout(null);
                    panel1.setOpaque(false);
                    //---- label1 ----
                    label1.setText(" ");
                    panel1.add(label1);
                    //----instrbutton----
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
                    panel1.add(instrButton);
                    //---- label2 ----
                    titleLb.setText("Please choose the tickets to print");                    
                    titleLb.setFont(new Font("Arial",Font.PLAIN,33));
                    titleLb.setForeground(Color.black);
                    titleLb.setBounds(10,10,600,50);
                    panel1.add(titleLb);
                }
                contentPanel.add(panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(0, 3));
                    panel2.setOpaque(false);

                    //---- label3 ----
                    ticketimageLb.setIcon(new ImageIcon(UIStyle.ticket02));
                    ticketimageLb.setHorizontalAlignment(SwingConstants.CENTER);
                    ticketimageLb.setFont(ticketimageLb.getFont().deriveFont(ticketimageLb.getFont().getSize() + 10f));
                    ticketimageLb.setForeground(SystemColor.textHighlight);
                    panel2.add(ticketimageLb);
                    //---- label3 ----
                    tagimageLb.setIcon(new ImageIcon(UIStyle.tag));
                    tagimageLb.setHorizontalAlignment(SwingConstants.CENTER);
                    tagimageLb.setFont(tagimageLb.getFont().deriveFont(tagimageLb.getFont().getSize() + 10f));
                    tagimageLb.setForeground(SystemColor.textHighlight);
                    panel2.add(tagimageLb);
                    //---- label3 ----
                    counterimageLb.setIcon(new ImageIcon(UIStyle.counter));
                    counterimageLb.setHorizontalAlignment(SwingConstants.CENTER);
                    counterimageLb.setFont(counterimageLb.getFont().deriveFont(counterimageLb.getFont().getSize() + 10f));
                    counterimageLb.setForeground(SystemColor.textHighlight);
                    panel2.add(counterimageLb);

                    //======== scrollPane1 ========
                    {

                        //---- textArea1 ----
                        textArea1.setEditable(false);
                        scrollPane1.setViewportView(textArea1);

                    }
                }
                contentPanel.add(panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout(0, 3));
                    panel3.setOpaque(false);

                    //---- checkBox1 ----
                    checkBox1.setText("boarding pass");
                    checkBox1.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                    checkBox1.setSelected(true);
                    checkBox1.setEnabled(false);
                  //  checkBox1.setDisabledIcon(checkBox1);
                    panel3.add(checkBox1);

                    //---- checkBox2 ----
                    checkBox2.setText("bag tag");
                    checkBox2.setFont(UIStyle.NORMAL_ARIAL_BOLD);
                    panel3.add(checkBox2);

                    //---- checkBox3 ----
                    checkBox3.setText("counter ticket");
                    checkBox3.setFont(UIStyle.NORMAL_ARIAL_BOLD);
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
                //---previewButton---
                previewButton.setText("Preview");
                previewButton.setFont(UIStyle.TINY_ARIAL_BOLD);
                previewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Preview(e);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                buttonBar.setOpaque(false);
                buttonBar.add(previewButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));


                //---- okButton ----
                nextBt.setText("Next");
                nextBt.setFont(UIStyle.TINY_ARIAL_BOLD);
                nextBt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Next(e);
                    }
                });
//                buttonBar.add(nextBt, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
//                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
//                    new Insets(0, 0, 0, 5), 0, 0));
//

            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        //
        this.add(dialogPane, BorderLayout.CENTER);
        setSize(900, 600);




        this.setVisible(true);



    }


    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JLabel titleLb;
    private JPanel panel2;
    private JLabel ticketimageLb;
    private JLabel tagimageLb;
    private JLabel counterimageLb;

    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel panel3;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JPanel buttonBar;
    public static JButton nextBt;
    private JButton cancelButton;
    private JButton previewButton;
    private JButton instrButton;

    public JButton getNextBt() {
        return nextBt;
    }



}
