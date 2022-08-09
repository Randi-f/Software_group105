package entity;
/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class Seat {
    protected String cls;
    public String special;
    protected int row;
    protected int col;
    protected int state;
    public Seat(){};

    public Seat(String cls,String special, int row, int col, int state) {
        this.cls = cls;
        this.row = row;
        this.col = col;
        this.state = state;
        this.special=special;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getType() {
        return cls;
    }

    public void setType(String cls) {
        this.cls = cls;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
