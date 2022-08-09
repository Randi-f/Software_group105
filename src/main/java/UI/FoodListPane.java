package UI;

import UI.Component.JSeat;
import UI.Component.JfoodItem;
import controller.FoodController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/8 19:36
 */
public class FoodListPane extends JPanel implements ActionListener {
    JPanel freeListPane;
    JPanel specialListPane;

    JTabbedPane specialTab;
    int listX=50,lisY=100;
    int foodPaneWidth=UIStyle.foodListW;
    int foodPaneHeight=UIStyle.foodPaneHeight;

    ArrayList<String> foodlist=new ArrayList<>();
    HashSet<String> categoryBts =new HashSet<>();

    public FoodListPane(){
        this.setLayout(null);
        arrangeListPane();
        setFont(UIStyle.TINY_ARIAL_BOLD);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JfoodItem resource= (JfoodItem) e.getSource();
        System.out.println(resource.getContents());
        FoodController.getController().setShownByName(resource.getContents());
        FoodController.getController().getDetailPane().setContent(resource.getContents());
//        if(resource.getText().equals())
    }
    public void paintFoodList(JPanel container, ArrayList<String> foods,int boxWidth,int boxHeight,int itemRow, int itemCol)  {
        container.setLayout(null);

        int itemW= boxWidth/itemCol,itemH=boxHeight/itemRow;

        for (int i = 0; i < foods.size(); i++) {
            JfoodItem temp =new JfoodItem(itemW-20,itemH,"",foods.get(i),(i%itemCol)*itemW,(i/itemCol)*itemH,UIStyle.class.getClassLoader().getResource("food/"+foods.get(i)+".png"));
//            temp.(this);
            temp.addActionListener(this);
            container.add(temp);
        }
        container.setPreferredSize(new Dimension(100,foods.size()*itemH+20));

    }



    public void setCategoryPane(){
        HashSet<String> types = FoodController.getController().getFoodTypes();
        ArrayList<String> foods;
        for(String i:types){
            if(!i.equals("free")){
                foods=FoodController.getController().getListNamesByType(i);
                JPanel aPane =new JPanel();
                paintFoodList(aPane,foods,foodPaneWidth,foodPaneHeight,4,1);
                JScrollPane aSPane=new JScrollPane(aPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                specialTab.addTab(i,aSPane);

            }
        }
    }

    private void arrangeListPane() {

        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JTabbedPane tabbedList=new JTabbedPane(JTabbedPane.TOP);
        tabbedList.setBounds(0,0,foodPaneWidth,foodPaneHeight);
        tabbedList.setBackground(Color.cyan);
        this.add(tabbedList);

        freeListPane = new JPanel();
        freeListPane.setBackground(Color.RED);
        foodlist= FoodController.getController().getListNamesByType("free");
        paintFoodList(freeListPane,foodlist,foodPaneWidth,foodPaneHeight,4,1);
        JScrollPane scrollPane = new JScrollPane(freeListPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		this.setToolTipText("123");


        specialListPane=new JPanel();
        specialListPane.setLayout(new BorderLayout());
        specialTab=new JTabbedPane(JTabbedPane.TOP);
//        specialTab.setBounds(0,0,foodPaneWidth-30,foodPaneHeight-5);
        specialTab.setBackground(Color.GREEN);


//        temp.add(scrollPane,BorderLayout.CENTER);
//        scrollPane.setBounds(10, 0, 300, foodPaneHeight-30);

//        categoryPane=new JPanel();
//        categoryPane.setLayout(new FlowLayout());
//        categoryPane.setBackground(Color.RED);

        specialListPane.add(specialTab,BorderLayout.CENTER);
//        setCategoryPane();
        setCategoryPane();

        tabbedList.addTab("free", scrollPane);
        tabbedList.addTab("special", specialTab);




    }

}
