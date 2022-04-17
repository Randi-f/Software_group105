package backend.bean;


import com.alibaba.fastjson.annotation.JSONField;
import entity.Food;
import entity.Seat;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 21:47
 */
public class PassengerBean {
    @JSONField(name = "documentID")
    public String documentID;

    @JSONField(name = "surname")
    public String surname;

    @JSONField(name = "favSeat")
    public Seat favSeatBean;

    @JSONField(name = "favFood")
    public ArrayList<Food> favFoodBean;

    @JSONField(name = "credit")
    public int credit;

    public entity.Passenger converter(){
        return new entity.Passenger(this.documentID,this.surname,favSeatBean,favFoodBean,this.credit);
    }
}
