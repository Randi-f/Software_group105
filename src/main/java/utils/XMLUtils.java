package utils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/29 11:29
 */
public class XMLUtils {
    public static Object getBean(String special) {

        String char1= special.substring(0,1).toUpperCase();
        StringBuilder sb=new StringBuilder(special);
        sb.replace(0,1,char1);
        try {
            Class<?> clsname =Class.forName("UI.Component.seat."+sb);
//            System.out.println(clsname.getClass());
//            Constructor<?> ctr=clsname.getConstructor(Integer.class,Integer.class,Integer.class,Integer.class,String.class,Integer.class,Integer.class,Integer.class);
//            Object j = ctr.newInstance(new Object[]{x,y,w,h,type,state,Xm,Ym});,int x, int y, int w, int h, String type, int state, int Xm, int Ym
            Object j = clsname.newInstance();
            return j;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
