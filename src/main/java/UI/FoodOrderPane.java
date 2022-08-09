package UI;

import UI.Component.BillMini;
import UI.Component.DynamicText;
import controller.FoodController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/9 18:29
 */
public class FoodOrderPane extends JPanel implements ActionListener {
    JPanel list;
    JButton delBt=new JButton("delete");
    
    ArrayList<JButton> orderBts=new ArrayList<>();
    JLabel orderTxt=new JLabel("Order:",JLabel.CENTER);

    BillMini billPane;

    HashMap<String,Integer> foodCount=new HashMap<>();

    String chosen="";
    String p = "(\\D+)\\*";

    int orderItemW=150,orderItemH=40;


    public FoodOrderPane(){

        
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        setFont(UIStyle.TINY_ARIAL_BOLD);
        
        list = new JPanel();
        
        list.setPreferredSize(new Dimension(150,360));
        list.setBackground(Color.WHITE);
//       delBt.setBorder(BorderFactory.createEtchedBorder());
        orderTxt.setPreferredSize(new Dimension(50,30));
        delBt.addActionListener(this);
        delBt.setPreferredSize(new Dimension(50,35));
        this.add(orderTxt);
        this.add(list);
        this.add(delBt);
        orderTxt.setFont(UIStyle.SMALL_ARIAL_BOLD);
        list.setFont(UIStyle.SMALL_ARIAL_BOLD);
        delBt.setFont(UIStyle.TINY_ARIAL_BOLD);
    }

    public BillMini getBillPane() {
        return billPane;
    }

    public void setBillPane(JPanel billPane) {
        this.billPane = (BillMini) billPane;
    }

    public void setOrder(){
        foodCount=FoodController.getController().getFoodCount();
        list.removeAll();

//        for(JButton b :orderBts){
//            if(b.getText())
//        }
        list.setLayout(null);
        int count=0;
        for(String i:foodCount.keySet()){
            JButton tbt= new JButton(i+" * "+foodCount.get(i));
            tbt.setBounds(2,count * orderItemH,orderItemW,orderItemH);
            tbt.addActionListener(this);
            list.add(tbt);
            count=1+count;
        }
//        SwingUtilities.updateComponentTreeUI(this);
//        this.repaint();
        list.setVisible(true);
        list.updateUI();


        billPane.getTotal().setText(FoodController.getController().getTotal()+" $");
//        list.revalidate();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton resource= (JButton) e.getSource();
        if(resource.equals(delBt)){
            if(chosen.length()<1){
                FoodChoicePanel.reminder.WRONG("select your item to delete");
                return;
            }
            FoodController.getController().deleteFood(chosen);
            setOrder();
        }else {
            String info = resource.getText();
            Pattern r = Pattern.compile(p);
            Matcher matcher = r.matcher(info);matcher.find();
            String s=matcher.group();
            this.chosen=s.substring(0,s.length()-2);
        }

    }
}
