package entity;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:43
 */
public class Passenger {
    private String documentID;
    private String surname;
    private Seat favSeat;
    private ArrayList<Food> favFood;
    private int credit;


    public Passenger(String documentID, String surname,Seat favSeat,ArrayList<Food> favFood,int credit) {
        this.documentID = documentID;
        this.surname = surname;
    }


    public String getDocumentID() {
        return documentID;
    }

    public String getSurname() {
        return surname;
    }

    public Seat getFavSeat() {
        return favSeat;
    }

    public int getCredit() {
        return credit;
    }

    public void setFavSeat(Seat favSeat) {
        this.favSeat = favSeat;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


}