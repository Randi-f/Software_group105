package UI;



import java.awt.*;
import java.net.URL;

/**
 * <p>It is used to store all the UI fonts, size, image resources, colors and settings
 * so that any page uses color should directly reference this static variable and the page
 *  style will be consistent.</p>
 * @author daliangrun
 * @version 5.3
 */
public class UIStyle
{
    public static final Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
    public static final Font SMALL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font TINY_FONT = new Font("Arial", Font.PLAIN, 10);
    public static final Font BIG_FONT = new Font("Arial", Font.PLAIN, 36);


    public static final Font SMALL_ARIAL_BOLD = new Font("Arial", Font.BOLD, 14);
    public static final Font TINY_ARIAL_BOLD = new Font("Arial", Font.BOLD, 10);

    public static final Font NORMAL_ARIAL_BOLD = new Font("Arial", Font.BOLD, 18);

    public static final Color COLOR_1 = Color.decode("#292F41");
    public static final Color COLOR_2 = Color.WHITE;
    public static final Color COLOR_3 = Color.decode("#F6F6F6");
    public static final Color COLOR_4 = Color.BLACK;
    public static final Color COLOR_5 = Color.decode("#4D5054");

    public static final Color BLUE_BUTTRESS = Color.decode("#1253CE");
    public static final Color BLUE_SHALLOW = Color.decode("#ACC7F1");
    public static final Color GRAY_BUTTRESS = Color.decode("#58606A");
    public static final Color GRAY_SHALLOW = Color.decode("#F8FAFB");

    public static final Color GREEN_OK = Color.decode("#28943D");
    public static final URL economyOK = UIStyle.class.getClassLoader().getResource("img/yes.png");
    public static final URL economyNo = UIStyle.class.getClassLoader().getResource("img/no.png");

    public static int width=1120;
    public static int height=700;
    public static int flightGraphWidth=700;
    public static int flightGraphHeight=650;
    public static int foodPaneWidth=350, foodPaneHeight=450;
    public static int division=100;
    public static int barHeight;
    public static int ScreenWidth;
    public static int ScreenHeight;
    public static int titleX=50,titleY=10,titleWidth=250,titleHeight=50;
    public static int backWidth=50,backHeight=20;
    public static int backX=10,backY=UIStyle.height-UIStyle.backHeight-10;

    public UIStyle()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ScreenWidth =(int)dim.getWidth();
        ScreenHeight = (int)dim.getHeight();
        //define how far the division line of Navigation from the left


    }




}

