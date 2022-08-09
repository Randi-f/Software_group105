package UI.Component;

import UI.FlightInfoPane;
import UI.FoodChoicePanel;
import UI.MenuBar;
import UI.SeatChoicePanel;
import UI.UIStyle;
import utils.MouseMonitor;
import utils.ThreadHandler;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/28 09:29
 */
public class BottomBar extends JPanel {
    public static BottomBar bottomBar;
    public static HashMap<String,JButton> confirmBts=new HashMap<>();
    public static BottomBar getController(){
        return bottomBar;
    }
    public BottomBar(){
        initComponent();
    }
    int funsW=200,funsH=60;
    public  JButton confirmBt=new JButton("JJ");
    public  JButton cancelBt=new JButton("CANCEL");
    public  JPanel  functionP=new JPanel();
    public JLabel timerLb=new JLabel("");
    public void initComponent(){
        this.setPreferredSize(new Dimension(UIStyle.width,UIStyle.bottomH));
        this.setLayout(null);
        functionP.setBounds(UIStyle.width-200,10,funsW,funsH);
        this.add(functionP);
//        cancelBt=FlightInfoPane.cancelButton;
        functionP.add(cancelBt);
        this.add(timerLb);
        timerLb.setBounds(10,10,100,40);

    }

    public JLabel getTimerLb() {
        return timerLb;
    }

    public void updateConfirm(String to){
        if(confirmBts.containsKey(to)){
            functionP.removeAll();
            functionP.repaint();
            confirmBt=confirmBts.get(to);
            functionP.add(FlightInfoPane.cancelButton);
            functionP.add(confirmBt);
            functionP.updateUI();
        }else System.out.println("no page to confirm "+to );

    }

    public void setConfirmPage(String to, JButton confirm){
        if(confirm!=null){
            if(!confirmBts.containsKey(to)){
                confirmBts.put(to,confirm);
            }
            updateConfirm(to);
        }
    }

}
