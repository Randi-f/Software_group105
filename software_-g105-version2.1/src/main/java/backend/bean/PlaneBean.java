package backend.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
public class PlaneBean {
    @JSONField(name = "econCol")
    public ArrayList<Integer>  econCol;

    @JSONField(name = "econRow")
    public int  econRow;

    @JSONField(name = "planeId")
    public  String planeId;

    @JSONField(name = "firCol")
    public ArrayList<Integer>  firCol;

    @JSONField(name = "firRow")
    public int firRow;

    @JSONField(name = "clubCol")
    public ArrayList<Integer>  clubCol;

    public ArrayList<Integer> getEconCol() {
        return econCol;
    }

    public void setEconCol(ArrayList<Integer> econCol) {
        this.econCol = econCol;
    }

    @JSONField(name = "clubRow")
    public int clubRow;
    public entity.Plane converter(){
        return new entity.Plane(this.econCol,this.econRow,this.planeId);
    }

}
