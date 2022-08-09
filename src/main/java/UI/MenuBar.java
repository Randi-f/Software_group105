package UI;


import UI.Component.BottomBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/1 22:20
 * @version 1.1
 * @author: zyc
 * @date: 2022/25
 */
public class MenuBar implements ActionListener {

    CardLayout cards;
    JPanel contentPanel;
    Boolean update = false;

   public static HashMap<String,JButton> menuBts;
    private static HashMap<String,Integer> priority;
    private static HashMap<String,Integer> pageChecked;

    private static ArrayList<String> reverseDisables;
static ArrayList<String> pagesName=new ArrayList<>();


    private static int priorityProgress=0;
    private static String currentBt;


    public static MenuBar menuBar;

    public static MenuBar getController(){
        return menuBar;
    }

    static {

        priority=new HashMap<>();
        priority.put("Flight",0);
        priority.put("SeatChoice",1);
        priority.put("FoodChoice",1);
        priority.put("Bill", 3);
        priority.put("Scan IDcard",4);
        priority.put("Tickets",5);
        priority.put("FinalPage",6);

        //0: unchecked; 1:checked but reviewable; 2:gone forever
        pageChecked=new HashMap<>();
        pageChecked.put("Flight",0);
        pageChecked.put("SeatChoice",0);
        pageChecked.put("FoodChoice",0);
        pageChecked.put("Tickets",0);
        pageChecked.put("Bill",0);
        pageChecked.put("FinalPage",0);
        pageChecked.put("Scan IDcard",0);

        reverseDisables=new ArrayList<>();
        reverseDisables.add("Flight");
        reverseDisables.add("Bill");
        reverseDisables.add("FinalPage");


    }
    public MenuBar(CardLayout cards,JPanel contentPanel){
        menuBts=new HashMap<>();
        this.cards=cards;
        this.contentPanel=contentPanel;
//            this.addBt("ok");

    }
    public void addBt(String name){
        JFrame temp = new JFrame();
        temp.setVisible(true);

        JButton ok= new JButton(name);
        temp.getContentPane().add(ok);

        ok.addActionListener(this);
    }
    public void addBt(String name,JButton newBt){
        menuBts.put(name,newBt);
        pagesName.add(name);
    }

    public boolean changePage(String from,String to){
        if(priorityProgress>=priority.get(to) && pageChecked.get(to)<2){
                this.cards.show(contentPanel,to);
                this.currentBt=to;
                return true;
        }
        System.out.println(to+"gone"+pageChecked.get(to));
        return false;
    }
//    public  boolean changePage(String from,String to) {
//        this.cards.show(contentPanel, to);
//        this.currentBt = to;
////        BottomBar.getController().setConfirmPage(to);
//        return true;
//    }
    public  void changePage(String to){
            this.cards.show(contentPanel, to);
            this.currentBt = to;
//            BottomBar.getController().setConfirmPage(to);
//         changeMode(from,to);

    }


    public void confirmStyle(){
        for(String p : pageChecked.keySet()){
            if(pageChecked.get(p)>0){
                menuBts.get(p).setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }
    }

    public void setUpdate()
    {
        update = true;
    }

    public void confirmPage(String from,String to){
        if(pageChecked.get(from)==0){
            pageChecked.replace(from,1);
            priorityProgress+=1;
        }
        lockPage(from);
//        System.out.println("progress"+priorityProgress);
        changePage(to);
        confirmStyle();
    }
    /**
     * @para
     * once the specific page is confirmed, previous pages have gone forever.
     */
    public void lockPage(String from){
       for (String f:reverseDisables){
           if(f.equals(from)){
               for(String p:pagesName){
                   pageChecked.replace(p,2);
                   if(p.equals(from))break;
               }
               break;
           }
       }
    }

    void changeMode(String from,String to){
        menuBts.get(from).setBorder(BorderFactory.createLoweredBevelBorder());
        menuBts.get(to).setBorder(BorderFactory.createLineBorder(Color.red));
    }




    public void showFinishReminder(){

    }
    public String getCurrentBt(){
        return currentBt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source= (JButton)e.getSource();
        if(source.getText().equals("ok")){
            confirmPage(currentBt,"FinalPage");
        }
    }


}
