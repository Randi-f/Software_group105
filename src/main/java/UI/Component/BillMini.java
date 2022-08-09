package UI.Component;

import UI.UIStyle;
import controller.FoodController;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;

/**
 * unified bill component to show the cost
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/1 12:20
 */
public class BillMini extends JPanel{

    JLabel total=new JLabel("0 $");
    int costPaneW=100,costPaneH=60;

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public BillMini(int type){
        if(type==1)
            arrangeSeatCost();
        else if(type==2)
            arrangeFoodCost();
    }

    public void arrangeFoodCost(){
       this.setLayout(null);
        this.setBackground(Color.cyan);
        DynamicText billMark = new DynamicText(5, 0, "left", Color.WHITE, Color.BLACK, "Bill", costPaneW/2, costPaneH/2, UIStyle.NORMAL_ARIAL_BOLD);
        this.add(billMark);
        total.setBounds(costPaneW/2+10,costPaneH/2,costPaneW/2,costPaneH/2);
        this.add(total);
        total.setText(FoodController.getController().getTotal()+"  $");
    }

    public void arrangeSeatCost(){
        this.setLayout(null);
        this.setBackground(Color.cyan);
        DynamicText billMark = new DynamicText(5, 0, "left", Color.WHITE, Color.BLACK, "Bill", costPaneW/2, costPaneH/2, UIStyle.NORMAL_ARIAL_BOLD);
        this.add(billMark);
        total.setBounds(costPaneW/2+10,costPaneH/2,costPaneW/2,costPaneH/2);
        this.add(total);
        SeatsController.getController().setPriceShow(total);

    }
}
