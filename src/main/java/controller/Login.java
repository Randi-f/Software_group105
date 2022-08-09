package controller;


import backend.bean.PassengerBean;
import backend.dataIO.DataManager;
import entity.Booking;
import entity.Passenger;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Contains verification for three login methods
 * @Version 4.3
 * @author Yixuan Wang
 */

public class Login{
    public static int type=0;//login method, 1 scan, 2 name, 3 bookingNo
    public static String bNo;//record the succeed login booking No
    public static String pNo;//record the succeed login passenger ID
    /**
     * Get the correct passenger by input ID
     * @param documentID input ID
     * @return the searched result from a list of passengers
     */
    public static Passenger scanDocuMentID(String documentID){
        Passenger passenger = null;
        ArrayList<PassengerBean> passengers=new ArrayList<>();
        try {
            passengers = DataManager.getInstance().passengerBeans;
            for (int i=0;i<passengers.size();i++){
                if (passengers.get(i).documentID.equals(documentID)){
                    passenger = passengers.get(i).converter();
                    type = 1;
                    pNo = documentID;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return passenger;
    }
    /**
     * Get the correct passenger by input ID and surname
     * @param documentID input ID
     * @param surname input surname
     * @return the searched result from a list of passengers
     */
    public static Passenger surAndDocu(String documentID,String surname){
        Passenger passenger = null;
        Login login = new Login();
        passenger = login.scanDocuMentID(documentID);
        if (passenger!=null&&passenger.getSurname().equals(surname)){
            type = 2;
            pNo = documentID;
            return passenger;
        }
        return null;
    }
    /**
     * Get the correct booking by input bookingNo
     * @param bookingNo input booking number
     * @return the searched result from a list of bookings
     */
    public static Booking searchBookingNo(String bookingNo){
        type = 3;
        Booking bk=BookingController.getController().getBookingsByNo(bookingNo);



        if(bk!=null){
            bNo = bookingNo;
            pNo = BookingController.getController().getBooking().getDocumentID();
        }


        System.out.println("login"+pNo);
        System.out.println(bNo+"======");
        return bk;

    }

}

