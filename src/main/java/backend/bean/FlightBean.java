package backend.bean;

import com.alibaba.fastjson.annotation.JSONField;
import entity.Food;
import entity.Seat;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 23:20
 */
public class FlightBean {

    @JSONField(name = "flightNo")
    public String flightNo;

    @JSONField(name = "departureTime")
    public Timestamp departureTime;

    @JSONField(name = "arrivalTime")
    public Timestamp arrivalTime;

    @JSONField(name = "departure")
    public String departure;

    @JSONField(name = "arrival")
    public String arrival;

    @JSONField(name = "aviationDepartment")
    public  String aviationDepartment;

    @JSONField(name = "plane")
    public  String plane;

    @JSONField(name = "gate")
    public  String gate;

    @JSONField(name = "counterNo")
    public  String counterNo;

    @JSONField(name = "onAirMeals")
    public  ArrayList<Food> onAirMeals;

    @JSONField(name = "onAirSeats")
    public ArrayList<Seat> onAirSeats;

    @JSONField(name = "state")
    public int state; //1 normal departure time, 0 delay

    @JSONField(name = "ecoClass")
    public int[][] ecoClass;

    public entity.Flight converter(){
        return new entity.Flight(this.flightNo,this.departureTime,this.arrivalTime,this.departure,this.arrival,
                                this.aviationDepartment,this.plane,this.gate,this.counterNo,onAirMeals,onAirSeats,this.state);
    }
    //{"flightNo":"111","plane": "123","type": "","": "","": "","": "","": "",
    //  "onAirSeats": [],"onAirMeals": [],"": "","": "","": ""
    //}
}
