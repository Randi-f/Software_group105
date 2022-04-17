package controller;



import backend.bean.BookingBean;
import backend.bean.FlightBean;
import backend.dataIO.DataManager;
import entity.Booking;
import entity.Flight;
import entity.Passenger;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @version 2.1
 * @author Yike Zhang
 */

public class FliInfoController {
    private static FliInfoController flightInfoController=new FliInfoController();
    public FliInfoController(){}
    public static FliInfoController getController(){
        return flightInfoController;
    }

    //this is used to set table data
    public TableModel table1Controller(String documentID) throws IOException {

        //test data
        Object[] columnNames = {"FlightNo", "departure","arrival","departTime", "arrTime","state"};
        Object[][] rowData = {
                {"MU0012", "Beijing","Shanghai","2022/1/1 12:00", "2022/1/1 13:30","on time"},
                {"Mu0013", "Shanghai","Beijing","2022/1/1 15:00", "2022/1/1 16:30","delay"},
                {"MU0789","Beijing","Kunming", "2022/1/3 15:00", "2022/1/3 16:30","--"},
                {"MU0232", "Shanghai","Haikou","2022/1/1 10:00", "2022/1/1 12:30","on time"},
                {"Mu0234", "Beijing","Shanghai","2022/1/1 16:00", "2022/1/1 16:30","delay"}
        };

        //real usage
        ArrayList<String>flightNos=getFlightNoBydocumentID(documentID);
        ArrayList<Flight>passengersFlight=getFlightInfoByFlightNo(flightNos);
        Object[][] rowData2=formatConver(passengersFlight);

        //set diseditable
        // int x=columnNames.length;
        //  int y= rowData.length;
        TableModel model = new DefaultTableModel(rowData, columnNames);
        //   model.isCellEditable(x,y);
        // RowSorter sorter = new TableRowSorter(model);
        // model.setRowSorter(sorter);
        //
        return model;
    }
    /*
    Filter info based on keywords
     */

    /**
     * This method is to search flight information through flightNo
     * @param flightNos
     * @return
     */
  public ArrayList<Flight> getFlightInfoByFlightNo(ArrayList<String> flightNos)
   // public ArrayList<Flight> getFlightInfoByFlightNo(String documentID)
    {
      //  ArrayList<String>flightNos=getFlightNoBydocumentID(documentID);
       // ArrayList<String>flightNos=flightNos;
        FlightBean flightBean=new FlightBean();
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flightBean.converter());
        ArrayList<Flight> passengersFlight=new ArrayList<>();
        if(flightNos == null)
            return passengersFlight;
      //  for(Flight i : flights)
        for (int i=0;i<flightNos.size();i++){

       //    if(i.getName().contains(key) || i.getCusId().contains(key))
            if (flights.get(i).getFlightNo()==flightNos.get(i)){
            {
                passengersFlight.add(flights.get(i));
            }
        }
       // return res;
    }
    return passengersFlight;
    }

    /**
     * This method is to get a user's flight information
     * @param documentID
     * @return
     */
    public ArrayList<String> getFlightNoBydocumentID(String documentID) throws IOException {
       // Passenger passenger = null;
       // Object flightNos=new Object();
     /*   for(BookingBean bean : DataManager.getInstance().bookingBeans){
            bks.add(bean.converter());
            System.out.println(bean.foodLoves);
            System.out.println(bean.seat.toString());
//            if(bean.planeId.equals(planeId)){
//                return planeBean;
//            }*/


        ArrayList<String> flightNos=new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
       // BookingBean bookingBean=DataManager.getInstance().bookingBeans;
        BookingBean bookingBean=new BookingBean();
       // ArrayList<BookingBean>bookingBean=DataManager.getInstance().bookingBeans;
       // bookings.add(bookingBean.converter());
       // ArrayList<Booking> bookings=bookingBean.converter();
           // ArrayList<Booking> bookings =DataManager.getInstance().bookingBeans;
        for (int i=0;i<bookings.size();i++){
            if (bookings.get(i).getDocumentID()==documentID){
                //passenger = passengers.get(i);
                flightNos.add(bookings.get(i).getFlightNo());
              //  break;
            }
        }
        return flightNos;
    }

    /**
     * This method is to convert flightInfo into suitable data format
     * @param passengersFlight
     * @return
     */
    public Object[][] formatConver(ArrayList<Flight> passengersFlight){
        Object[][] rowData = null;
        for (int i=0;i<passengersFlight.size();i++) {//hang
            //for(int j=0;j<6;j++){
          //  {"FlightNo", "departure","arrival","departTime", "arrTime","state"};
                rowData[i][0]=passengersFlight.get(i).getFlightNo();
                rowData[i][1]=passengersFlight.get(i).getDeparture();
                rowData[i][2]=passengersFlight.get(i).getArrival();
                rowData[i][3]=passengersFlight.get(i).getDepartureTime();
                rowData[i][4]=passengersFlight.get(i).getArrivalTime();
                rowData[i][5]=passengersFlight.get(i).getState();
         //   }


        }
        return rowData;

    }


}
