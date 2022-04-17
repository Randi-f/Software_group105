package UI;
import javax.swing.*;
import java.awt.*;

public class QRcode extends JFrame{
    public QRcode(){
        this.setSize(660,660);
        this.setLocation(400,80);
        this.add(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Desktop\\AA.jpg")));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
