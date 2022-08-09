package controller;

import UI.Component.*;
import UI.Component.JSeat;
import UI.SeatChoicePanel;
import UI.SeatsPanel;

import entity.Booking;
import entity.Plane;
import entity.Seat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class SeatsController {
    private static SeatsController seatscontroller = new SeatsController();
    JSeat jSeat;
    SeatsPanel seatsPanel;
    Seat seat = new Seat();
    //    public static HashMap<Integer,String> num2char=new HashMap<>();
    private int[][] ecoBoard;
    private int[][] clubBoard;
    private int[][] firBoard;
    Plane plane;
    private ArrayList<Integer> window = new ArrayList<>();
    private ArrayList<Integer> emergency = new ArrayList<>();
    private ArrayList<Integer> legroom = new ArrayList<>();
    int cost = 0;
    String special = "normal";
    String currentClass = "economy";
    JLabel priceShow;
    InputText seatShow;
    InputText seatTypeShow;

    boolean shownReminder = false;

    public static HashMap<String, Integer> classPrice = new HashMap<>();


//    public InputText getSeatTypeShow() {
//        return seatTypeShow;
//    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public void setSeatTypeShow(InputText seatTypeShow) {
        this.seatTypeShow = seatTypeShow;
    }

    public SeatsPanel getSeatsPanel() {
        return seatsPanel;
    }

    public void setSeatsPanel(SeatsPanel seatsPanel) {
        this.seatsPanel = seatsPanel;

    }

    public int[][] getBoard(String type) {
        if ("economy".equals(type)) {
            return ecoBoard;
        } else if ("club".equals(type)) {
            return clubBoard;
        } else if ("first".equals(type)) {
            return firBoard;
        }
        return null;
    }
//
//    public void changeClass(String type){
//        this.seatsPanel.setContent(type);
//    }

    static {
        classPrice.put("first", 200);
        classPrice.put("club", 100);
        classPrice.put("economy", 20);
    }

    private SeatsController() {

    }

    public static SeatsController getController() {
        return seatscontroller;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat s) {
        this.seat = s;
    }

    public void setSeatShow(InputText seatShow) {
        this.seatShow = seatShow;
    }

    public void setPriceShow(JLabel price) {
        this.priceShow = price;
    }

    public void setSeatShowTxt() {
        this.seatShow.setText(special + " " + String.valueOf(this.seat.getRow()) + (char) ("A".getBytes()[0] + this.seat.getCol() - 1));
        this.priceShow.setText(cost + " $");
        this.seatTypeShow.setText(seat.getType());
    }

    public JSeat getJSeat() {
        return jSeat;
    }

    public void setJSeat(JSeat jseat) {
        this.jSeat = jseat;
        this.seat.setState(1);
        this.seat.setCol(jSeat.getYm());
        this.seat.setRow(jSeat.getXm());
        this.seat.setType(jSeat.getType());
        this.seat.setSpecial(jseat.special);
    }

    public void setDefault() {
        if (jSeat == null) {
            String defaultClass = BookingController.getController().getBooking().getSeat().getType();
            if (defaultClass != "") SeatsController.getController().getSeatsPanel().changeCard(defaultClass);
            SeatChoicePanel.classFilter.classCheck(defaultClass);
            for (JSeat j : seatsPanel.jseats) {
                if (j.getType().equals(defaultClass) && j.getState() == 0 && j.special.equals("normal")) {
                    setJSeat(j);
                    j.setState(2);
                    j.repaint();
                    setCost();
                    setSeatShowTxt();
                    break;
                }
            }
        }

    }

    /**
     * after click the Jseat, excute functions:
     *
     * @param j
     */
    public boolean changeJSeat(JSeat j) {
        Booking bk = BookingController.getController().getBooking();
        if (getJSeat() == null) {
            setJSeat(j);
            return true;
        } else if (getJSeat() != j) {
            getJSeat().setState(0);//repaint previous chosen seat
            seat.setState(0);
            getJSeat().repaint();
            setJSeat(j);
            if (!j.getType().equals(bk.getSeat().getType())) {
                SeatsPanel.reminder.popup("your class are upgraded to " + j.getType(), Color.GREEN);
                return false;
            }
            return true;

        } else {
        }
        return false;
    }

    public void setSpecialSeat() {
        if (legroom.size() < 1) {
            legroom = plane.getPositionConfig().get("legroom");
            window = plane.getPositionConfig().get("window");
            emergency = plane.getPositionConfig().get("emergency");
        }
    }


    public String getExtraSeatType(int row, int col, String type) {
        setSpecialSeat();
        int colTotal = 0;
        if (type.equals("economy")) {
            for (int c : plane.getEconCol()) colTotal = c + colTotal;
            int cols1 = plane.getEconCol().get(0);
            int cols2 = plane.getEconCol().get(plane.getEconCol().size() - 1);
            for (int em : emergency) {
                if (em == row && (cols1 >= col || (col <= colTotal && col > colTotal - cols2))) {
                    return "emergency";
                }
            }
            for (int leg : legroom) {
                if (leg == row) {
                    return "legroom";
                }
            }
//        for(int win:window){
//            if(win==col){
//                return "window";
//            }
//        }
            return "normal";
        } else return "normal";

    }


    public void loadBoard() throws IOException {
        int col = 0;

        FlightController.createSeatsOnFlight();
        ArrayList<Seat> seats = FlightController.getFlight().onAirSeats;
        Seat s = null;
        for (int c : plane.getEconCol()) col = c + col;
        ecoBoard = new int[plane.getEconRow()][col];
        System.out.println("economy: R:" + plane.getEconRow() + " C:" + col);

        col = 0;
        for (int c : plane.getClubCol()) col = c + col;
        clubBoard = new int[plane.getClubRow()][col];
        System.out.println("club: R:" + plane.getClubRow() + " C:" + col);

        col = 0;
        for (int c : plane.getFirCol()) col = c + col;
        firBoard = new int[plane.getFirRow()][col];
        System.out.println("first R:" + plane.getFirRow() + " C:" + col);
        for (int i = 0; i < seats.size(); i++) {
            s = seats.get(i);
            if (s.getType().equals("economy")) {
                ecoBoard[s.getRow() - 1][s.getCol() - 1] = s.getState();
            } else if (s.getType().equals("club")) {
                clubBoard[s.getRow() - 1][s.getCol() - 1] = s.getState();
            } else if (s.getType().equals("first")) {
                firBoard[s.getRow() - 1][s.getCol() - 1] = s.getState();
            }
        }
    }

    public Plane getPlaneById(String id) throws IOException {
        plane = PlaneController.getPlaneById(id).converter();
        return plane;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int price) {
        this.cost = price;

    }

    public void setCost(String type) {
        this.cost = plane.getPriceConfig().get(type);
        this.special = type;
    }

    public void setCost() {
        this.cost = 0;
        this.special = "normal";
    }


    public Seat checkFullSeat(String type) {
        Seat s = null;
        ArrayList<Seat> seats = FlightController.getFlight().onAirSeats;
        for (int i = 0; i < seats.size(); i++) {
            s = seats.get(i);
            if (s.getType().equals(type) && s.getState() == 0) {
                return s;
            }
        }
        return s;
    }

    public void setDefaultChoice() {
        if (jSeat == null) {

        }
    }
}
