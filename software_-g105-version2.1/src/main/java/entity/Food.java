package entity;

import backend.bean.FoodBean;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:43
 */
public class Food {
    String name;
    String introduction;
    String type;
    int price;
    String state;

    public String getName() {
        return name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getState() {
        return state;
    }

    public Food(){

    }

    public Food(String name, String introduction, String type, int price, String state) {
        this.name = name;
        this.introduction = introduction;
        this.type = type;
        this.price = price;
        this.state = state;
    }


}
