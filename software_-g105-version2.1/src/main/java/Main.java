import UI.MainFrame;
import UI.UIStyle;

import javax.swing.*;

public class Main
{

    public static void main(String[] args) throws Exception {
       Main m = new Main();
       m.initAll();
    }
    public  void initAll() throws Exception {
        new UIStyle();
        JFrame mp = new MainFrame();
    	
        mp.setVisible(true);
        mp.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
    	System.out.println("out");

    }

}
