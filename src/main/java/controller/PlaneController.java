package controller;



import backend.bean.PlaneBean;
import backend.dataIO.DataManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 15:10
 */

public class PlaneController {
    public static PlaneBean getPlaneById(String planeId) throws IOException {
        ArrayList<PlaneBean> planeBeans = DataManager.getInstance().planeBean;
        for(PlaneBean planeBean : planeBeans){
            if(planeBean.planeId.equals(planeId)){
                return planeBean;
            }
        }
        return null;
    }

}
