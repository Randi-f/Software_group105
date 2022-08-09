package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
/**
 * @version 3.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class Flight {
    private String flightNo;   
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String departure;
    private String arrival;
    private  String aviationDepartment;
    private  String plane;
    private  String gate;
    private  String counterNo;
    private  ArrayList<Food> onAirMeals;
    private ArrayList<Seat> onAirSeats;
    private int state;

    public Flight(String flightNo, Timestamp departureTime, Timestamp arrivalTime,
                  String departure, String arrival, String aviationDepartment, String plane,
                  String gate, String counterNo, ArrayList<Food> onAirMeals, ArrayList<Seat> onAirSeats,
                  int state) {
        
    	this.flightNo = flightNo;     
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departure = departure;
        this.arrival = arrival;
        this.aviationDepartment = aviationDepartment;
        this.plane = plane;
        this.gate = gate;
        this.counterNo = counterNo;
        this.onAirMeals = onAirMeals;
        this.onAirSeats = onAirSeats;
        this.state = state;
        
    }
    public String getFlightNo(){return flightNo;}
    public String getDeparture(){return departure;}  
    public String getAviationDepartment(){return aviationDepartment;}
    public Timestamp getDepartureTime() { return departureTime; }
    public Timestamp getArrivalTime() { return arrivalTime; }
    public String getGate() {return gate;}
    public String getCounterNo() {return counterNo;}  
    public String getPlane() {return plane;}
    public String getArrival() { return arrival; }
    public int getState(){return state;}


}
