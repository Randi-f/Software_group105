package controller;

import backend.bean.BookingBean;
import backend.dataIO.DataManager;
import entity.Booking;
import entity.Seat;

import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;

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
    public Booking booking;

    public String bkNo="";

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setBookingByID_No(String docId,String flightNo){
        try {
            for (BookingBean bean : DataManager.getInstance().bookingBeans){
                if(bean.flightNo.equals(flightNo) && bean.documentID.equals(docId)){
                    setBooking(bean.converter());
                    System.out.println("bk Info get: "+bean.bookingNo);
                    bkNo=bean.bookingNo;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkinAll(){
        try {BookingBean bkb=null;
            int bkSize=DataManager.getInstance().bookingBeans.size();
            for (int i = 0; i < bkSize; i++) {
                bkb=DataManager.getInstance().bookingBeans.get(i);
                 if(bkb.bookingNo.equals(bkNo)){
                     bkb.status=1;
                     bkb.seat=SeatsController.getController().getSeat();
                     bkb.food=FoodController.getController().getFoodCount();
                     DataManager.getInstance().commit();
                     break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  Booking getBookingsByNo(String id) {
//      ArrayList<Booking> bks = new ArrayList<Booking>();
      try {
          for(BookingBean bean : DataManager.getInstance().bookingBeans){
              if(bean.bookingNo.equals(id)){
                  this.setBooking(bean.converter());
                  FlightController.getController().setFlightByFlightNo(bean.flightNo);
                  if (!FliInfoController.verifyCheck(bean.flightNo)){
                      bean.bookingNo = "Not time";
                  }
                  return bean.converter();
              }
  //            if(bean.planeId.equals(planeId)){
  //                return planeBean;
  //            }
          }
      } catch (IOException | ParseException e) {
          e.printStackTrace();
      }
      return null;
  }


}
