package backend.bean;

import com.alibaba.fastjson.annotation.JSONField;
import entity.Food;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 21:59
 */
public class  BookingBean {
    @JSONField(name = "bookingNo")
    public  String bookingNo;

    @JSONField(name = "documentID")
    public String documentID;

    @JSONField(name = "seat")
    public entity.Seat seat;

    @JSONField(name = "flightNo")
    public String flightNo;

    @JSONField(name = "food")
    public HashMap<String,Integer> food;



    @JSONField(name = "status")
    public int status; //whether check in or not
    //[]
    public entity.Booking converter(){
        return new entity.Booking(this.bookingNo,this.documentID,this.flightNo,this.status,this.seat,this.food);
    }
}
