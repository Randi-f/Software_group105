package entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class Plane {
    private ArrayList<Integer>  econCol;
    private int econRow;
    private  String planeId;
    private ArrayList<Integer>  firCol;
    private int firRow;
    private ArrayList<Integer>  clubCol;
    private int clubRow;
    private HashMap<String,Integer> priceConfig;
    private HashMap<String,ArrayList<Integer>> positionConfig;


    public Plane(HashMap<String,Integer> priceConfig,HashMap<String,ArrayList<Integer>> positionConfig,ArrayList<Integer> econCol, int econRow,ArrayList<Integer> clubCol, int clubRow,ArrayList<Integer> firCol, int firRow,String planeId) {
        this.econCol = econCol;
        this.econRow = econRow;
        this.planeId = planeId;
        this.clubCol=clubCol;this.clubRow=clubRow;this.firCol=firCol;this.firRow=firRow;
        this.priceConfig=priceConfig;
        this.positionConfig=positionConfig;

    }

    public HashMap<String, Integer> getPriceConfig() {
        return priceConfig;
    }

    public void setPriceConfig(HashMap<String, Integer> priceConfig) {
        this.priceConfig = priceConfig;
    }

    public HashMap<String, ArrayList<Integer>> getPositionConfig() {
        return positionConfig;
    }

    public void setPositionConfig(HashMap<String, ArrayList<Integer>> positionConfig) {
        this.positionConfig = positionConfig;
    }

    public ArrayList<Integer> getFirCol() {
        return firCol;
    }

    public void setFirCol(ArrayList<Integer> firCol) {
        this.firCol = firCol;
    }

    public int getFirRow() {
        return firRow;
    }

    public void setFirRow(int firRow) {
        this.firRow = firRow;
    }

    public ArrayList<Integer> getClubCol() {
        return clubCol;
    }

    public void setClubCol(ArrayList<Integer> clubCol) {
        this.clubCol = clubCol;
    }

    public int getClubRow() {
        return clubRow;
    }

    public void setClubRow(int clubRow) {
        this.clubRow = clubRow;
    }

    public ArrayList<Integer> getEconCol() {
        return econCol;
    }

    public void setEconCol(ArrayList<Integer> econCol) {
        this.econCol = econCol;
    }

    public int getEconRow() {
        return econRow;
    }

    public void setEconRow(int econRow) {
        this.econRow = econRow;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }
}
