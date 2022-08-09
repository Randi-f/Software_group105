package backend.dataIO;

import backend.bean.*;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class DataManager {
    private static DataManager instance = null;

    /**
     * get the unique instance of DataManager
     * @return reference of DataManager object
     * @throws IOException
     */
    public static DataManager getInstance() throws IOException {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public ArrayList<PlaneBean> planeBean;
    public ArrayList<FoodBean> foodBean;
    public ArrayList<BookingBean> bookingBeans;
    public ArrayList<FlightBean> flightBeans;
    public ArrayList<PassengerBean> passengerBeans;


    /**
     * DataManager constructor
     * @throws IOException
     */
    private DataManager() throws IOException {

        /**
         * Read information which are stored in JSON files.
         */
        planeBean = (ArrayList<PlaneBean>)    JSON.parseArray(IO.read("plane.json"), PlaneBean.class);
        bookingBeans = (ArrayList<BookingBean>)    JSON.parseArray(IO.read("booking.json"), BookingBean.class);
        foodBean  = (ArrayList<FoodBean>)    JSON.parseArray(IO.read("food.json"), FoodBean.class);
        passengerBeans  = (ArrayList<PassengerBean>)    JSON.parseArray(IO.read("passenger.json"), PassengerBean.class);
        flightBeans  = (ArrayList<FlightBean>)    JSON.parseArray(IO.read("flight.json"), FlightBean.class);
    }

    /**
     * write all data from memory into disk (files)
     * @throws IOException
     */
    public void commit() throws IOException {
        IO.write("plane.json",    JSON.toJSONString(planeBean));
        IO.write("booking.json",    JSON.toJSONString(bookingBeans));
        IO.write("flight.json",    JSON.toJSONString(flightBeans));
//        IO.write("plane.json",    JSON.toJSONString(planeBean));
//        IO.write("plane.json",    JSON.toJSONString(planeBean));
    }

}
