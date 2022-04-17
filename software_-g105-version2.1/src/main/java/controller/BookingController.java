package controller;

import backend.bean.BookingBean;
import backend.dataIO.DataManager;
import entity.Booking;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 23:11
 */
public class BookingController {
    private static BookingController bookingController=new BookingController();
    private BookingController(){}
    public static BookingController getController(){
        return bookingController;
    }

    public  ArrayList<Booking> getBooking() throws IOException {
        ArrayList<Booking> bks = new ArrayList<Booking>();

        for(BookingBean bean : DataManager.getInstance().bookingBeans){
           // bks.add(bean.converter());
            System.out.println(bean.foodLoves);
            System.out.println(bean.seat.toString());
//            if(bean.planeId.equals(planeId)){
//                return planeBean;
//            }
        }
        return bks;
    }

}
