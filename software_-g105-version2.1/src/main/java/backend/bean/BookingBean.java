package backend.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 21:59
 */
public class BookingBean {
    @JSONField(name = "bookingNo")
    public  String bookingNo;

//    @JSONField(name = "pa")
//    public Passenger pa;

    @JSONField(name = "seat")
    public entity.Seat seat;

    @JSONField(name = "flightNo")
    public String flightNo;

    @JSONField(name = "foodLoves")
    public ArrayList<entity.Food> foodLoves;

    @JSONField(name = "status")
    public int status; //whether check in or not

    //public entity.Booking converter(){
        //return new entity.Booking(this.bookingNo,this.flightNo,this.status,this.seat,this.foodLoves);
    //}
}
