package UI;



import java.awt.*;
import javax.swing.*;

/**
* @author unknown
*/
public abstract class FrameWithNavi extends JFrame {
   public FrameWithNavi() {
       this.setVisible(true);
       initComponents();
       this.setSize(900,600);
       this.setVisible(true);
   }

   private void initComponents() {
       panel1 = new JPanel();
       panel2 = new JPanel();
       label1 = new JLabel();
       label2 = new JLabel();
       label3 = new JLabel();
       label4 = new JLabel();
       label5 = new JLabel();
       label6 = new JLabel();
       label7 = new JLabel();

       //======== this ========
       Container contentPane = getContentPane();
       contentPane.setLayout(null);

       //======== panel1 ========
       {
           panel1.setOpaque(true);
           panel1.setLayout(new GridLayout(10, 0));
           //---- label1 ----
           label1.setText("Login");
           label1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label1);

           //---- label2 ----
           label2.setText("Flight Choosing");
           label2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label2);

           //---- label3 ----
           label3.setText("Seat Choosing");
           label3.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label3);

           //---- label4 ----
           label4.setText("Meal Choosing");
           label4.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label4);

           //---- label5 ----
           label5.setText("Extra Payment");
           label5.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label5);

           //---- label6 ----
           label6.setText("Confirmation");
           label6.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label6);

           //---- label7 ----
           label7.setText("Print");
           label7.setHorizontalAlignment((int) CENTER_ALIGNMENT);
           panel1.add(label7);
       }
       contentPane.add(panel1);
       panel1.setBounds(0, 0, 100, 568);
       panel1.setBackground(SystemColor.activeCaption);

       //======== panel2 ========
       {
           panel2.setLayout(null);

           {
               // compute preferred size
               Dimension preferredSize = new Dimension();
               for(int i = 0; i < panel2.getComponentCount(); i++) {
                   Rectangle bounds = panel2.getComponent(i).getBounds();
                   preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                   preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
               }
               Insets insets = panel2.getInsets();
               preferredSize.width += insets.right;
               preferredSize.height += insets.bottom;
               panel2.setMinimumSize(preferredSize);
               panel2.setPreferredSize(preferredSize);
           }
       }
       contentPane.add(panel2);
       panel2.setBounds(100, 0, 598, 568);

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

       pack();
       setLocationRelativeTo(getOwner());
   }

   public JPanel panel1;
   public JPanel panel2;
   public JLabel label1;
   public JLabel label2;
   public JLabel label3;
   public JLabel label4;
   public JLabel label5;
   public JLabel label6;
   public JLabel label7;
}
