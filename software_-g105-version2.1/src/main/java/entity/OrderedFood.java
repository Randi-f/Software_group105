package entity;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/7 19:33
 */
public class OrderedFood extends Food{
    int num;
    Food foodinfo;
    public OrderedFood(String name, String introduction, String type, int price, String state,int num){
        super(name,introduction,type,price,state);
        this.num=num;
    }
    public OrderedFood(Food food,int num){
        super(food.getName(),food.getIntroduction(),food.type,food.getPrice(),food.getState());
        this.foodinfo=food;
        this.num=num;
    }
}
