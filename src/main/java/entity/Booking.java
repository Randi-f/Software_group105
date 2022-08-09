package entity;

/**
 * @version 2.0
 * @author: Yixuan WangWenhan Yang
 * @date: 2022/3/31 19:42
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Booking {
    private  String bookingNo;
//    private Passenger pa;
    //add documentID
    private String documentID;
    private Seat seat;
    private String flightNo;
    private HashMap<String,Integer> food;
    private int status; //whether check in or not

    public Booking(String bookingNo, String documentID,String flightNo, int status,Seat seat,HashMap<String,Integer> food) {
        this.bookingNo = bookingNo;
//        this.pa = pa;Passenger pa,
        this.documentID=documentID;
      this.flightNo=flightNo;
        this.status = status;
        this.food=food;
        this.seat=seat;
    }


    public String getBookingNo() {
        return bookingNo;
    }
    public String getFlightNo(){return flightNo;}
    public String getDocumentID(){return documentID;}

    public Seat getSeat() {
        return seat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }


}
