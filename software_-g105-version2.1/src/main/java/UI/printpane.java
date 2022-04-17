package UI;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class printpane extends JFrame {
    public printpane(boolean B,boolean T,boolean C) {

        initComponents(B, T, C);
    }

  public static void main(String[] args) {
      new printpane(true,true,false);

   }

   private void initComponents(boolean B,boolean T,boolean C) {
  // private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
       // ResourceBundle bundle = ResourceBundle.getBundle("com.company.Boundary.form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label4 = new JLabel();
        panel3 = new JPanel();
        label5 = new JLabel();
        progressBar3 = new JProgressBar();
        panel5 = new JPanel();
        label6 = new JLabel();
        progressBar4 = new JProgressBar();
        panel6 = new JPanel();
        label7 = new JLabel();
        progressBar5 = new JProgressBar();
        buttonBar = new JPanel();
        okButton = new JButton();
      

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new CompoundBorder( new TitledBorder (new EmptyBorder(
            0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", TitledBorder. CENTER, TitledBorder
            . BOTTOM, new Font ("D\u0069al\u006fg" , Font .BOLD ,12 ), Color.
            red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout());

                //======== panel1 ========
                {
                    panel1.setLayout(new GridLayout(4, 0));

                    //======== panel2 ========
                    {
                        panel2.setLayout(new GridLayout(0, 2));

                        //---- label4 ----
                        label4.setText("printpane.label4.text");
                        panel2.add(label4);
                    }
                    panel1.add(panel2);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new GridLayout(0, 2, 0, 5));

                        //---- label5 ----
                        label5.setText("printpane.label5.text");
                        panel3.add(label5);
                        panel3.add(progressBar3);
                    }
                    panel1.add(panel3);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new GridLayout(0, 2));

                        //---- label6 ----
                        label6.setText("printpane.label6.text");
                        panel5.add(label6);
                        panel5.add(progressBar4);
                    }
                    panel1.add(panel5);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new GridLayout(0, 2));

                        //---- label7 ----
                        label7.setText("printpane.label7.text");
                        panel6.add(label7);
                        panel6.add(progressBar5);
                    }
                    panel1.add(panel6);
                }
                contentPanel.add(panel1);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("printpane.okButton.text");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	//finalPage fg = new finalPage();
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
               
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(900, 605);
        setLocationRelativeTo(getOwner());
  
        pack();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
       /* ImageIcon  i = new ImageIcon("src/cat.jpg");//锟斤拷取锟斤拷应路锟斤拷锟铰碉拷图片锟侥硷拷(锟斤拷图片应锟斤拷锟斤拷src锟斤拷)
        i.setImage(i.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));//80锟斤拷100为锟斤拷小 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
        label2.setIcon(i);//锟斤拷锟酵计�
//		l.setSize(20, 20);//锟斤拷锟矫憋拷签锟侥达拷小锟斤拷也锟斤拷锟斤拷谋锟酵计拷拇锟叫�
        panel1.add(label2);//锟斤拷锟斤拷锟斤拷*/
//ProcessBar(progressBar1);
       


 // dialogPane.setVisible(true);
       this.setVisible(true);
        System.out.println(B);
        System.out.println(T);
        System.out.println(C);
        if(B==true){
            Printprogress(progressBar3);
        }
        else {
            label5.setVisible(false);
            progressBar3.setVisible(false);
        };
        if(T==true){
            Printprogress((progressBar4));

        }
        else{
            label6.setVisible(false);
            progressBar4.setVisible(false);
        };
        if(C==true){
            Printprogress((progressBar5));

        }
        else{
            label7.setVisible(false);
            progressBar5.setVisible(false);};

        //dialogPane.setVisible(true);
      // Printprogress(progressBar3);
     //   Printprogress(progressBar4);
     //   Printprogress(progressBar5);
       // this.setVisible(true);

    }
   /* public  void printProcess(){
        System.out.print("锟斤拷锟节硷拷锟斤拷");
        for (int i = 0; i < 80; i++) {
            System.out.print(".");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("锟斤拷锟斤拷锟斤拷锟�:100%");
    }*/


    public void Printprogress (JProgressBar bar){
        /*try
        {
            int i=0;    //锟斤拷锟斤拷锟斤拷
            for(; i<=100; i++)  //锟斤拷0锟斤拷100
            {
               if(i == 100)
                {
                   // jbutton1.setEnabled(true); //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫帮拷钮锟斤拷锟斤拷
                  //  Thread.
                }
                bar.setValue(i);  //锟斤拷锟矫斤拷锟斤拷锟斤拷锟侥碉拷前值
                Thread.sleep(20);      //锟斤拷锟斤拷50锟斤拷锟斤拷
            }
            bar.setIndeterminate(false);
            bar.setString("锟斤拷锟斤拷锟斤拷桑锟�");
        } catch (InterruptedException e) {}*/
        int[] progressValues={6,18,27,39,51,66,81,100};
            for(int i=0;i<progressValues.length;i++)
            {
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                //锟斤拷锟矫斤拷锟斤拷锟斤拷锟斤拷值
                bar.setValue(progressValues[i]);
            }
            bar.setIndeterminate(false);
            bar.setString("锟斤拷锟斤拷锟斤拷桑锟�");
          //  button.setEnabled(true);
        }



  




    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label4;
    private JPanel panel3;
    private JLabel label5;
    private JProgressBar progressBar3;
    private JPanel panel5;
    private JLabel label6;
    private JProgressBar progressBar4;
    private JPanel panel6;
    private JLabel label7;
    private JProgressBar progressBar5;
    private JPanel buttonBar;
    private JButton okButton;
    
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
