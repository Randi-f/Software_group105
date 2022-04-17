package controller;


import entity.Booking;
import entity.Passenger;

import java.util.ArrayList;

public class Login {
    public Passenger scanDocuMentID(String documentID){
        Passenger passenger = null;
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        for (int i=0;i<passengers.size();i++){
            if (passengers.get(i).getDocumentID()==documentID){
                passenger = passengers.get(i);
                break;
            }
        }
        return passenger;
    }
    public Passenger surAndDocu(String documentID,String surname){
        Passenger passenger = null;
        Login login = new Login();
        passenger = login.scanDocuMentID(documentID);
        if (passenger!=null&&passenger.getSurname()==surname){
            return passenger;
        }
        return null;
    }
    public Booking searchBookingNo(String bookingNo){
        Booking booking = null;
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        for (int i=0;i<bookings.size();i++){
            if (bookings.get(i).getBookingNo()==bookingNo){
                booking = bookings.get(i);
                break;
            }
        }
        return booking;
    }

}
