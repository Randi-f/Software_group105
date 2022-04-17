package controller;

import UI.Component.JSeat;
import backend.dataIO.FlightManager;
import entity.Plane;
import entity.Seat;

import java.io.IOException;
import java.util.ArrayList;
/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class SeatsController {
    private static SeatsController seatscontroller =new SeatsController();
    JSeat jSeat;
    Seat seat=new Seat();
    private  int[][] ecoBoard;
    Plane plane;



    public int[][] getBoard(String type) {
        if("economy".equals(type)){return ecoBoard;}
        return null;
    }

    private SeatsController(){}

     public static SeatsController getController(){
          return seatscontroller;
     }

    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat s){this.seat=s;}

    public  JSeat getJSeat() {
          return jSeat;
     }
     public  void setJSeat(JSeat jseat) {
          this.jSeat = jseat;
          this.seat.setState(jSeat.getState());
          this.seat.setCol(jSeat.getYm());
          this.seat.setRow(jSeat.getXm());
          this.seat.setType(jSeat.getType());
         System.out.println(seat.getCol()+" "+seat.getCol());

     }


    public  void loadBoard(String type) throws IOException {
        int col=0;
        if(type.equals("economy")){
            for(int c:plane.econCol)col=c+col;
            ecoBoard=new int[plane.econRow][col];
            System.out.println("R:"+plane.econRow+" C:"+col);
            Seat s;
            ArrayList<Seat> seats = FlightController.getFlight().onAirSeats;
            for (int i = 0; i < seats.size(); i++) {
                s=seats.get(i);
                System.out.println(s.getRow()+" "+s.getCol());
                ecoBoard[s.getRow()-1][s.getCol()-1]=s.getState();
            }

        }

    }

     public Plane getPlaneById(String id) throws IOException {
         plane = FlightManager.getPlaneById(id).converter();
        return plane;
     }



}
