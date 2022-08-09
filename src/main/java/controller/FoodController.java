package controller;

import UI.FoodChoicePanel;
import UI.FoodDetailPane;
import UI.FoodOrderPane;
import UI.MenuBar;
import backend.bean.FlightBean;
import backend.bean.FoodBean;
import backend.dataIO.DataManager;
import entity.Food;


import java.io.IOException;
import java.util.*;


/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 23:12
 */
public class FoodController {

    Food showChosenFood;
    Food freeChosen;
    FoodDetailPane detailPane;
    FoodOrderPane orderPane;
    HashMap<String, Integer> foodCount = new HashMap<>();
    int total = 0;
    
    private static FoodController foodController = new FoodController();

    public FoodController() {//set Default Food

    }

    public static FoodController getController() {
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Food> getListByType(String type) {
        ArrayList<Food> foods = new ArrayList<>();
        try {
            ArrayList<FoodBean> foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                if (foodDB.get(i).type.equals(type)) {
                    foods.add(foodDB.get(i).converter());
                }
            }
            return foods;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to get a list of food name by the type
     *
     * @param type food type
     * @return An arrayList of food name
     */
    public ArrayList<String> getListNamesByType(String type) {
        ArrayList<String> foods = new ArrayList<>();
        try {
            ArrayList<FoodBean> foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                if (foodDB.get(i).type.equals(type)) {
                    foods.add(foodDB.get(i).name);
                }
            }
            return foods;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to get a list of food types
     *
     * @return An arrayList of food types
     */
    public HashSet<String> getFoodTypes() {
        HashSet<String> types = new HashSet<>();
        ArrayList<FoodBean> foodDB = null;
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

    /**
     * This method is used to get food name by the name
     *
     * @param name food name
     * @return food
     */
    public Food getFoodByName(String name) {
        ArrayList<FoodBean> foodDB = null;
        try {
            foodDB = DataManager.getInstance().foodBean;
            for (int i = 0; i < foodDB.size(); i++) {
                if (foodDB.get(i).name.equals(name)) {
                    return foodDB.get(i).converter();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Food getshowChosenFood() {
        return showChosenFood;
    }

    public void setDetailPane(FoodDetailPane detailPane) {
        this.detailPane = detailPane;
    }

    public FoodDetailPane getDetailPane() {
        return detailPane;
    }

    /**
     * This method is used to keep current food in the controller by name
     *
     * @param name food name
     */
    public void setShownByName(String name) {
        this.showChosenFood = getFoodByName(name);
    }

    public void addFood(int num) {
        String name = showChosenFood.getName();
        if (foodCount.containsKey(name)) {
            FoodChoicePanel.reminder.WRONG("you have selected " + name + "!");
        } else {
            if (checkFree()) {
                foodCount.put(name, num);
                this.total += showChosenFood.getPrice() * num;
            } else {
                FoodChoicePanel.reminder.WRONG("you can only have one kind of free food");
            }

        }
    }

    public void deleteFood(String name) {
        if (foodCount.containsKey(name)) {
            this.total -= foodCount.get(name) * this.getFoodByName(name).getPrice();
            foodCount.remove(name);
        }
    }

    public boolean checkFree() {
        for (String name : foodCount.keySet()) {
            if (getFoodByName(name).getType().equals(showChosenFood.getType()) && showChosenFood.getType().equals("free")) {
                return false;
            }
        }
        return true;
    }
//        public ArrayList<OrderedFood> getOrderedF() {
//                return orderedF;
//        }
//
//        public void setOrderedF(ArrayList<OrderedFood> orderedF) {
//                this.orderedF = orderedF;
//        }
}
