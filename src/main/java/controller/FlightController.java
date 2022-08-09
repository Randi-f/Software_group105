package controller;

import backend.bean.FlightBean;
import backend.bean.PlaneBean;
import backend.dataIO.DataManager;
import entity.Seat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/4/1 13:55
 */
public class FlightController {

    private static ArrayList<FlightBean> flights;
    private static FlightBean flight;
    private static FlightController flightController;
    private boolean flightGotten=false;

    static {
        try {
            flightController = new FlightController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FlightBean> getFlights() {
        return flights;
    }

    public static FlightBean getFlight() {
        return flight;
    }

    private FlightController() throws IOException {

    }

    public boolean isFlightGotten() {
        return flightGotten;
    }

    public void setFlightGotten(boolean flightGotten) {
        this.flightGotten = flightGotten;
//        SeatsController.getController().getSeatsPanel().setContent();
//        SeatsController.getController().getSeatsPanel().changeCard("economy");

    }

    public static FlightController getController(){
        return flightController;
    }
    public static ArrayList<Seat> getSeatsByFlightId(String id) throws IOException {
        ArrayList<FlightBean> flightBeans = DataManager.getInstance().flightBeans;
        for(int i=0;i<flightBeans.size();i++){
            if(flightBeans.get(i).flightNo.equals(id)){
                if(flightBeans.get(i).onAirSeats.size()>0){
                    return flightBeans.get(i).onAirSeats;
                }
//                System.out.println();
            }
        }
        return null;
    }
    public static void updateSeatOnFlight(Seat seat) throws IOException {
//        if(DataManager.getInstance().flightBeans)
        int seatSize=flight.onAirSeats.size();
        Seat temp;
        if(seatSize==0)FlightController.createSeatsOnFlight();
        for (int i = 0; i < seatSize; i++) {
            temp = flight.onAirSeats.get(i);
            if((temp.getType().equals(seat.getType()))&&(temp.getCol()==seat.getCol())&&
                    (temp.getRow()==seat.getRow())){
                flight.onAirSeats.remove(i);
                flight.onAirSeats.add(seat);
                break;
            }
        }
//        DataManager.getInstance().commit();
    }
    public void setFlightByFlightNo(String flightNo) throws IOException {
        ArrayList<FlightBean> flightBeans = DataManager.getInstance().flightBeans;
        for(int i=0;i<flightBeans.size();i++){
            if(flightBeans.get(i).flightNo.equals(flightNo)){
                flight=flightBeans.get(i);
                System.out.println("set flight: "+flight.flightNo);
                System.out.println("get plane: "+ flight.plane);
                break;
//                System.out.println();
            }
        }


    }

    public static void getFlightsBy(){

    }


    public static void createSeatsOnFlight() throws IOException {
        if(flight.onAirSeats.size()==0){
            PlaneBean planeBean= PlaneController.getPlaneById(flight.plane);
            int x=0;
            int y=0;
            int col=0;
            if(planeBean.econRow!=0){
                for(int c:planeBean.econCol)col=c+col;
                for(int i=0;i<planeBean.econRow;i++){
                    for (int j = 0; j < col; j++) {
                        flight.onAirSeats.add(new Seat("economy","normal",i+1,j+1,0));
                    }
                }
            }
            if(planeBean.firRow!=0){
                col=0;
                for(int c:planeBean.firCol)col=c+col;
                for(int i=0;i<planeBean.firRow;i++){
                    for (int j = 0; j < col; j++) {
                        flight.onAirSeats.add(new Seat("first","normal",i+1,j+1,0));
                    }
                }
            }
            if(planeBean.clubRow!=0){
                col=0;
                for(int c:planeBean.clubCol)col=c+col;
                for(int i=0;i<planeBean.clubRow;i++){
                    for (int j = 0; j < col; j++) {
                        flight.onAirSeats.add(new Seat("club","normal",i+1,j+1,0));
                    }
                }
            }

        }
    }

}
