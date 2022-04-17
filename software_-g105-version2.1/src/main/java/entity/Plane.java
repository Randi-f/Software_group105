package entity;

import java.util.ArrayList;
/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class Plane {
    public ArrayList<Integer>  econCol;
    public int econRow;
    public  String planeId;
    public ArrayList<Integer>  firCol;
    public int firRow;
    public ArrayList<Integer>  clubCol;
    public int clubRow;

    public Plane(ArrayList<Integer> econCol, int econRow, String planeId) {
        this.econCol = econCol;
        this.econRow = econRow;
        this.planeId = planeId;
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
