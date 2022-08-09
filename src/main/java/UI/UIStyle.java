package UI;



import java.awt.*;
import java.net.URL;

/**
 * <p>It is used to store all the UI fonts, size, image resources, colors and settings
 * so that any page uses color should directly reference this static variable and the page
 *  style will be consistent.</p>
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
    public static final URL emergencySeat = UIStyle.class.getClassLoader().getResource("img/emergency.png");
    public static final URL backgroundImg = UIStyle.class.getClassLoader().getResource("background.jpeg");
    public static final URL logo = UIStyle.class.getClassLoader().getResource("logo.jpg");
    public static final URL seatLegroom = UIStyle.class.getClassLoader().getResource("img/medium.png");
    public static final URL seatLegroomNo = UIStyle.class.getClassLoader().getResource("img/nedium.png");
    public static final URL seatOK = UIStyle.class.getClassLoader().getResource("img/yes.png");
    public static final URL seatNo = UIStyle.class.getClassLoader().getResource("img/no.png");
    public static final URL chosenSeat = UIStyle.class.getClassLoader().getResource("img/chosenSeat.png");
    public static final URL windowSeat = UIStyle.class.getClassLoader().getResource("img/windows.png");

    public static final URL back = UIStyle.class.getClassLoader().getResource("img/back.png");
    public static final URL next = UIStyle.class.getClassLoader().getResource("img/next.png");
    public static final URL cancel = UIStyle.class.getClassLoader().getResource("img/cancel.png");
    public static final URL info = UIStyle.class.getClassLoader().getResource("img/info.png");
    public static final URL login = UIStyle.class.getClassLoader().getResource("img/login.png");
    public static final URL instr = UIStyle.class.getClassLoader().getResource("img/instructions.png");
    public static final URL lHA = UIStyle.class.getClassLoader().getResource("img/LHA.png");
    public static final URL ques = UIStyle.class.getClassLoader().getResource("img/ques.png");
    public static final URL lWay = UIStyle.class.getClassLoader().getResource("img/LoginWay.png");
    public static final URL confirm = UIStyle.class.getClassLoader().getResource("img/confirm.png");
    public static final URL back1 = UIStyle.class.getClassLoader().getResource("img/back1.png");
    public static final URL flight = UIStyle.class.getClassLoader().getResource("img/flight.png");
    public static final URL food = UIStyle.class.getClassLoader().getResource("img/food.png");
    public static final URL seat = UIStyle.class.getClassLoader().getResource("img/seat.png");
    public static final URL ticket = UIStyle.class.getClassLoader().getResource("img/ticket.png");
    public static final URL scan = UIStyle.class.getClassLoader().getResource("img/Scan.png");
    public static final URL success = UIStyle.class.getClassLoader().getResource("img/success.png");
    public static final URL barcode1 = UIStyle.class.getClassLoader().getResource("img/barcode1.png");
    public static final URL barcode2 = UIStyle.class.getClassLoader().getResource("img/barcode2.png");
    public static final URL ticket02 = UIStyle.class.getClassLoader().getResource("img/ticket02.png");
    public static final URL tag = UIStyle.class.getClassLoader().getResource("img/tag.png");
    public static final URL counter = UIStyle.class.getClassLoader().getResource("img/counter.png");
    public static final URL instruction = UIStyle.class.getClassLoader().getResource("img/instruct.png");
    public static final URL bill = UIStyle.class.getClassLoader().getResource("img/bill.png");
    public static final URL yl = UIStyle.class.getClassLoader().getResource("company/yl.png");
    public static final URL AMEX = UIStyle.class.getClassLoader().getResource("company/AMEX.png");
    public static final URL card = UIStyle.class.getClassLoader().getResource("company/card.png");
    public static final URL ysf = UIStyle.class.getClassLoader().getResource("company/ysf.png");
    public static final URL visa = UIStyle.class.getClassLoader().getResource("company/visa.png");
    public static final URL discover = UIStyle.class.getClassLoader().getResource("company/discover.png");
    public static final URL wechat = UIStyle.class.getClassLoader().getResource("company/wechat.png");
    public static final URL QRcode = UIStyle.class.getClassLoader().getResource("company/QRcode.jpg");



    public static int timer=300;
    public static int bottomH=60;
    public static int HomeW=800;
    public static int HomeH=600;
    public static int width=1100;
    public static int height=700;
    public static int flightGraphWidth=700;
    public static int flightGraphHeight=650;
    public static int foodPaneWidth=350, foodPaneHeight=450;
    public static int division=100;
    public static int contentW=1000;
    public static int barHeight=50;
    public static int billW=100;
    public static int billH=60;
    public static int foodListW= UIStyle.foodPaneWidth*3/4;
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