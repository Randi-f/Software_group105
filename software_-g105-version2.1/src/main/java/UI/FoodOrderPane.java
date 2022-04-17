package UI;

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
    JLabel txt=new JLabel("Order:",JLabel.CENTER);
    HashMap<String,Integer> foodCount=new HashMap<>();

    String chosen;
    String p = "(\\D+)\\*";
    public FoodOrderPane(){
        list = new JPanel();

        this.setBounds(UIStyle.titleX,UIStyle.titleY+UIStyle.foodPaneHeight+100,UIStyle.foodPaneWidth*2,50);
        this.setLayout(new FlowLayout());
        setOrder();
        txt.setPreferredSize(new Dimension(50,50));
//       delBt.setBorder(BorderFactory.createEtchedBorder());

        delBt.addActionListener(this);
        this.add(txt);
        this.add(list);
        this.add(delBt);



    }

    public void setOrder(){
        foodCount=FoodController.getController().getFoodCount();
        list.removeAll();

//        for(JButton b :orderBts){
//            if(b.getText())
//        }
        list.setLayout(new GridLayout(1,foodCount.size()));
        for(String i:foodCount.keySet()){
            JButton tbt= new JButton(i+" * "+foodCount.get(i));
            tbt.addActionListener(this);
            list.add(tbt);
        }
//        SwingUtilities.updateComponentTreeUI(this);
//        this.repaint();
        list.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton resource= (JButton) e.getSource();
        if(resource.equals(delBt)){
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
