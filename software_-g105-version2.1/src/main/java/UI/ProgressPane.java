package UI;
/**
 * this is to show print progress
 * @auther Yike Zhang
 * @version 2.0
 */

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class ProgressPane extends JFrame {

    public static void main(String args[]) {
        ProgressPane frame = new ProgressPane(true,true,true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public ProgressPane(boolean B,boolean T,boolean C) {
        super();
        boolean b=B;
        boolean t=T;
        boolean c=C;
        getContentPane().setLayout(new GridBagLayout());
        setTitle("Print Progress");
        setBounds(100, 100, 500, 375);
        setBounds(100, 100, 266, 132);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 69, 69));
        label.setFont(new Font("", Font.BOLD, 10));
        label.setText("Welcome to print your tickets£¡");
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        getContentPane().add(label, gridBagConstraints);

        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
      //  progressBar.setIndeterminate(true);
        progressBar.setString("print......");
        final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
        gridBagConstraints_1.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints_1.gridy = 1;
        gridBagConstraints_1.gridx = 0;
        getContentPane().add(progressBar, gridBagConstraints_1);

        final JButton button = new JButton();
        button.setText("OK");
        button.setEnabled(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  System.exit(0);
               // getContentPane().dispose();
               // frame.
               // System.out.println(this.getClass());
               // printpane p=new printpane(b,t,c);
                MenuBar.getController().changePage("SeatChoice","SeatChoice");
                //finalPage f=new finalPage();
            }
        });
        final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
        gridBagConstraints_2.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints_2.gridy = 2;
        gridBagConstraints_2.gridx = 1;
        getContentPane().add(button, gridBagConstraints_2);
        new Progress(progressBar, button).start();
    }

    class Progress extends Thread {
        private final int[] progressValue = {6, 10,18, 27, 39, 51, 66, 81,
                100};
        private JProgressBar progressBar;
        private JButton button;

        public Progress(JProgressBar progressBar, JButton button) {
            this.progressBar = progressBar;
            this.button = button;
        }

        public void run() {

            for (int i = 0; i < progressValue.length; i++) {
                try {
                    Thread.sleep(500);// sleep 500 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setValue(progressValue[i]);//set progress
            }
           progressBar.setIndeterminate(false);
            progressBar.setString("Finished!");
            button.setEnabled(true);// set button enable
        }
    }
}
