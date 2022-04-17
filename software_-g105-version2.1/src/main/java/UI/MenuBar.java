package UI;

import controller.FlightController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/1 22:20
 */
public class MenuBar {

    CardLayout cards;
    JPanel contentPanel;

        private static HashMap<String,JButton> menuBts;

        private String currentBt;

        public static MenuBar menuBar;

        public static MenuBar getController(){
            return menuBar;
        }

        public MenuBar(CardLayout cards,JPanel contentPanel){
            menuBts=new HashMap<>();
            this.cards=cards;
            this.contentPanel=contentPanel;

        }

        public void addBt(String name,JButton newBt){
            menuBts.put(name,newBt);
        }

        public void changePage(String from,String to){
         this.cards.show(contentPanel,to);
         this.currentBt=to;
         changeMode(from,to);

        }

    void changeMode(String from,String to){
            menuBts.get(from).setBorder(BorderFactory.createLoweredBevelBorder());
            menuBts.get(to).setBorder(BorderFactory.createLineBorder(Color.red));

    }
    public String getCurrentBt(){
            return currentBt;
    }





}
