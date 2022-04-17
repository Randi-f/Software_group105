package entity;

/**
 * @version 2.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
import java.util.ArrayList;

public class Booking {
    private  String bookingNo;
//    private Passenger pa;
    //add documentID
    private String documentID;
    private Seat seat;
    private String flightNo;
    private ArrayList<Food> foodLoves;
    private int status; //whether check in or not

    public Booking(String bookingNo, String documentID,String flightNo, int status,Seat seat,ArrayList<Food> foodLoves) {
        this.bookingNo = bookingNo;
//        this.pa = pa;Passenger pa,
        this.documentID=documentID;
      this.flightNo=flightNo;
        this.status = status;
        this.foodLoves=foodLoves;
        this.seat=seat;
    }


    public String getBookingNo() {
        return bookingNo;
    }
    public String getFlightNo(){return flightNo;}
    public String getDocumentID(){return documentID;}
}
