package entity;

import java.util.ArrayList;

/**
 * @version 2.1
 * @author: Yixuan Wang
 */
public class Passenger {
    private String documentID;
    private String surname;
   


    public Passenger(String documentID, String surname) {
        this.documentID = documentID;
        this.surname = surname;
    }


    public String getDocumentID() {
        return documentID;
    }

    public String getSurname() {
        return surname;
    }





}