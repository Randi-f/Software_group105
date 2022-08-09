package controller;


/*
import backend.bean.BookingBean;
import backend.bean.FlightBean;
import backend.dataIO.DataManager;
import entity.Booking;
import entity.Flight;
import entity.Passenger;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
*/
import backend.bean.BookingBean;
import backend.bean.FlightBean;
import backend.dataIO.DataManager;

import entity.Flight;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * This controller used for flight select and show flight detail operations
 * @version 5.0
 * @author Yike Zhang
 */

public class FliInfoController {
    private static FliInfoController flightInfoController=new FliInfoController();
    private static Flight flight;

    private FliInfoController(){}
    public static FliInfoController getController(){
        return flightInfoController;
    }
    public static Flight getFlight() {
        return flight;
    }
    public void  setFlight(Flight flight) {
         this.flight=flight;
    }

   public static void main(String[] args) throws IOException {
        ArrayList<String>flightNo=FliInfoController.getController().getFlightNoBydocumentID("11111111");
        ArrayList<Flight>passengerFlight=FliInfoController.getController().getFlightInfoByFlightNo(flightNo);
        Object[][] rowData=FliInfoController.getController().formatConver(passengerFlight);
        System.out.println(rowData[0][0]);
    }
    /**
     *  This is used to format table data for scan login/ID+surname login
     * @param number documentID or booking number
     * @param  a login type
     * @return  Table data in the correct format
     */

    public TableModel table1Controller(String number,int a) throws IOException {

        Object[] columnNames = {"FlightNo", "departure","arrival","departTime", "arrTime","state"};
        if(a==1||a==2)
        {
            //for ID+surname/scan login

            ArrayList<String> flightNos = getFlightNoBydocumentID(number);
            ArrayList<Flight> passengersFlight = getFlightInfoByFlightNo(flightNos);
            Object[][] rowData = formatConver(passengersFlight);

            TableModel model = new DefaultTableModel(rowData, columnNames);
            return model;
        }

        else if(a==3){
       //for booking number login
                ArrayList<String> flightNo = getFlightNoByBookingNo(number);
                ArrayList<Flight> flight = getFlightInfoByFlightNo(flightNo);
                Object[][] rowData2 = formatConver(flight);
                TableModel model2 = new DefaultTableModel(rowData2, columnNames);
                return model2;
        }
       TableModel b=new DefaultTableModel(null,columnNames);

        return  b;
    }


    /**
     * This method is used to get flight number  by booking number
     * @param bookingNo user's booking number
     * @return An arrayList used to record booking numbers
     */
    public ArrayList<String>  getFlightNoByBookingNo(String bookingNo) throws IOException {
        ArrayList<String> flightNo=new ArrayList<>();
        for (BookingBean bean : DataManager.getInstance().bookingBeans){
            if(bean.bookingNo.equals(bookingNo)){
                flightNo.add(bean.converter().getFlightNo());
            }
        }
        return flightNo;
    }

    /**
     * This is used to search flight information through flightNo
     * @param flightNos There is no check-in flight number in the user account
     * @return Flight information corresponding to the flight number
     */
  public ArrayList<Flight> getFlightInfoByFlightNo(ArrayList<String> flightNos) throws IOException
    {
        ArrayList<Flight> passengersFlight=new ArrayList<>();
        if(flightNos == null)
            return passengersFlight;
          for (FlightBean bean : DataManager.getInstance().flightBeans)
          {
             for (int i=0;i<flightNos.size();i++)
             {

                if(bean.flightNo.equals(flightNos.get(i)))
                {
                passengersFlight.add(bean.converter());
                }
             }
          }
    return passengersFlight;
    }

    /**
     * This method is used to get a user's flight number by document ID
     * @param documentID user's document ID
     * @return An arraylist to store user's un-checked flight number
     */
    public ArrayList<String> getFlightNoBydocumentID(String documentID) throws IOException {

        ArrayList<String> flightNos=new ArrayList<>();
       // System.out.println(DataManager.getInstance().bookingBeans.size());
        for (BookingBean bean : DataManager.getInstance().bookingBeans){

                  if(bean.documentID.equals(documentID)&&bean.status==0)
                  {

                    flightNos.add(bean.converter().getFlightNo());

                  }
        }
       // System.out.println(flightNos.get(0));
        return flightNos;
    }
/**
 * This is used to get flight detail information by flight number
 * @param fliNo flight number that user had chosen
 * @return flight information
 */
public Flight getDetailByFlightNo(String fliNo) {

    try {
        for(FlightBean bean : DataManager.getInstance().flightBeans)
        {
            if(bean.flightNo.equals(fliNo)){
                this.setFlight(bean.converter());
                return bean.converter();
            }

        }
         } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
    /**
     * This method is to convert flightInfo into suitable data format
     * @param Flight user's flight information
     * @return
     */
    public Object[][] formatConver(ArrayList<Flight> Flight) {
        ArrayList<Flight> passengersFlight = Flight;
        Object[][] rowData = new Object[passengersFlight.size()][6];
        for (int i = 0; i < passengersFlight.size(); i++) {
            rowData[i][0] = passengersFlight.get(i).getFlightNo();
            rowData[i][1] = passengersFlight.get(i).getDeparture();
            rowData[i][2] = passengersFlight.get(i).getArrival();
            rowData[i][3] = passengersFlight.get(i).getDepartureTime();
            rowData[i][4] = passengersFlight.get(i).getArrivalTime();
            //flight state
            int j = passengersFlight.get(i).getState();
            if (j == 1) {
                rowData[i][5] = "delay";
            } else if (j == 0) {
                rowData[i][5] = "on time";
            }
        }
            return rowData;

        }
    
    public static boolean verifyCheck(String flightNo) throws ParseException {
        Flight flight = flightInfoController.getDetailByFlightNo(flightNo);
        System.out.println(flight.getDepartureTime());
        Timestamp departTime=flight.getDepartureTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String DT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(departTime);
        Date dt=df.parse(DT);
        String Str = df.format(dt);
        System.out.println(Str);

        Date currentD = new Date(122,9,8,10,53,35);
        String reStr = df.format(currentD);
        System.out.println(currentD);


        Date end = new Date(currentD.getYear(),currentD.getMonth(),currentD.getDate()+1,currentD.getHours(),
                currentD.getMinutes(),currentD.getSeconds());
        Date begin = new Date(currentD.getYear(),currentD.getMonth(),currentD.getDate(),currentD.getHours()+1,
                currentD.getMinutes(),currentD.getSeconds());
        System.out.println(begin);
        System.out.println(end);
        System.out.println(currentD);
        if (begin.compareTo(dt)<=0&&end.compareTo(dt)>=0){
            return true;
        }
        return false;
    }
    }
