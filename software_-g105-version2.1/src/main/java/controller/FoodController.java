package controller;

import UI.FoodDetailPane;
import UI.FoodOrderPane;
import backend.bean.FlightBean;
import backend.bean.FoodBean;
import backend.dataIO.DataManager;
import entity.Food;
import entity.OrderedFood;

import java.io.IOException;
import java.util.*;



/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 23:12
 */
public class FoodController {

        Food shownF;
        FoodDetailPane detailPane;
        FoodOrderPane orderPane;
        HashMap<String,Integer> foodCount=new HashMap<>();
        private static FoodController foodController =new FoodController();

       public FoodController(){//set Default Food

        }
        public static FoodController getController(){
                return foodController;
        }

    public HashMap<String, Integer> getFoodCount() {
        return foodCount;
    }
    public void setFoodCount(HashMap<String, Integer> foodCount) {
        this.foodCount = foodCount;
    }

    public FoodOrderPane getOrderPane() {
        return orderPane;
    }

    public void setOrderPane(FoodOrderPane orderPane) {
        this.orderPane = orderPane;
    }

    public ArrayList<Food> getListByType(String type){
        ArrayList<Food> foods= new ArrayList<>();
        try {
            ArrayList<FoodBean> foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                if(foodDB.get(i).type.equals(type)){
                    foods.add(foodDB.get(i).converter());
                }
            }
            return foods;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> getListNamesByType(String type){
        ArrayList<String> foods= new ArrayList<>();
        try {
            ArrayList<FoodBean> foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                if(foodDB.get(i).type.equals(type)){
                    foods.add(foodDB.get(i).name);
                }
            }
            return foods;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashSet<String> getFoodTypes(){
        HashSet<String> types =new HashSet<>();
        ArrayList<FoodBean> foodDB= null;
        try {
            foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                types.add(foodDB.get(i).type);
            }
            return types;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Food getFoodByName(String name)  {
        ArrayList<FoodBean> foodDB= null;
        try {
            foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                if(foodDB.get(i).name.equals(name)){
                    return foodDB.get(i).converter();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        }
        public Food getShownF() {
                return shownF;
        }

    public void setDetailPane(FoodDetailPane detailPane) {
        this.detailPane = detailPane;
    }

    public FoodDetailPane getDetailPane() {
        return detailPane;
    }

    public void setShownByName(String name){
                this.shownF =getFoodByName(name);
        }
    public void addFood(int num){
//                for (int i = 0; i < orderedF.size(); i++) {
//                        if(orderedF.get(i).getName().equals(shownF.getName())){
//                        }else {orderedF.add(new OrderedFood(shownF,num));
//
//                }
                        if(foodCount.containsKey(shownF.getName())){
                        }else
                        {foodCount.put(shownF.getName(),num);
                        }
        }
    public void deleteFood(String name){
        if(foodCount.containsKey(name)){
            foodCount.remove(name);
        }
    }
//        public ArrayList<OrderedFood> getOrderedF() {
//                return orderedF;
//        }
//
//        public void setOrderedF(ArrayList<OrderedFood> orderedF) {
//                this.orderedF = orderedF;
//        }
}
