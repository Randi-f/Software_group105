package backend.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaneBean {

    @JSONField(name = "planeId")
    public  String planeId;

    @JSONField(name = "econCol")
    public ArrayList<Integer>  econCol;

    @JSONField(name = "econRow")
    public int  econRow;

    @JSONField(name = "firCol")
    public ArrayList<Integer>  firCol;

    @JSONField(name = "firRow")
    public int firRow;

    @JSONField(name = "clubCol")
    public ArrayList<Integer>  clubCol;

    @JSONField(name = "clubRow")
    public int clubRow;

    @JSONField(name = "priceConfig")
    public HashMap<String,Integer> priceConfig;

    @JSONField(name = "positionConfig")
    public HashMap<String,ArrayList<Integer>> positionConfig;


    public ArrayList<Integer> getEconCol() {
        return econCol;
    }

    public void setEconCol(ArrayList<Integer> econCol) {
        this.econCol = econCol;
    }

    public entity.Plane converter(){
        return new entity.Plane(this.priceConfig,this.positionConfig,this.econCol,this.econRow,this.clubCol,this.clubRow,this.firCol,this.firRow,this.planeId);
    }


}
