package UI;

import UI.Component.JSeat;
import controller.SeatsController;
import entity.Plane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatsPanel extends JPanel{

    int X_OFFSET = 2;
    int Y_OFFSET = 10;

    int firstRow=4,firstCol=4;
    int clubRow=6,clubCol=6;

    ImageIcon economyOK,economyNO;
    ImageIcon clubOK,clubNO;
    ImageIcon firOK,firNo;

    JLabel economyLabel=new JLabel("E");
    JLabel clubLabel=new JLabel("C");
    JLabel firstLabel=new JLabel("F");
    int classLabelX=10,classLabelW=50,classLabelH=30;


    int econSeatSize=30,clubSeatSize=32,firSeatSize=45;
    JPanel firstPanel, clubPanel,economyPanel;
    JPanel fixEconOuter;
    int ecoArea ,clubArea, firArea;//the area of one seat
    int passageSpace = 10,lineSpace=1;

    int[][] econRoom;

    JScrollPane econScroller;
    int fixEconOuterWidth=350,fixEconOuterHeight=300;
    int econClassWidth,econClassHeight;
    int econClassX,econClassY;



    /**
     *   make the panel inside the scroller get its size so that
     *   the scroller can play a role
     */
    public void expandClassPanel(String type,JPanel panel,int row,int col,int size, Color color){
        int height=400,width=300;
        if(type.equals("economy")){
            econClassWidth=col * size + passageSpace*(col%3==0?3:2 - 1);
            econClassHeight=row * size + lineSpace*(row-1);
            width=econClassWidth;height=econClassHeight;
        }
        panel.setPreferredSize(new Dimension(width,height));
        panel.setBackground(color);
    }
    /**
     * arrange every JSeat component on the class board 
     * @return byproduct-number of column
     */
    public int arrangeClassSeat(JPanel panel,int size,int row,ArrayList<Integer> col,String type, Color color){
        int blockCol=0,Col=0,x=0,state=0;
        for (int i = 0; i < col.size(); i++) {
            blockCol=col.get(i);
            Col=blockCol+Col;
            for (int c = 0; c < blockCol; c++) {
            for (int r = 0; r <row ; r++) {
                    state=SeatsController.getController().getBoard(type)[r][x];
                    panel.add(new JSeat(x*size+i*passageSpace,r*size,size,size,type,state,r+1,x+1));
                }
                x=x+1;
            }
        }
        return Col;
    }

    public SeatsPanel() throws Exception {
        this.setLayout(null);
        Plane plane=SeatsController.getController().getPlaneById("123");
        SeatsController.getController().loadBoard("economy");
//        firstCol=plane;
        economyPanel=new JPanel(null);
        int Col=arrangeClassSeat(economyPanel,econSeatSize,plane.getEconRow(),plane.getEconCol(),"economy",Color.BLUE);
        expandClassPanel("economy",economyPanel,plane.getEconRow(),Col,econSeatSize,Color.BLUE);

        fixEconOuter=new JPanel();//limit the height of scroller
        fixEconOuter.setBounds((UIStyle.flightGraphWidth-fixEconOuterWidth)/2,Y_OFFSET,econClassWidth,fixEconOuterHeight);
        fixEconOuter.setLayout(new BorderLayout(0, 0));

        econScroller = new JScrollPane(economyPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        fixEconOuter.add(econScroller,BorderLayout.CENTER);

        clubPanel=new JPanel(null);
        clubPanel.setBackground(Color.GREEN);
        clubPanel.setBounds(200,500,100,100);
        clubPanel.add(new Button("1313"));


//        this.computePanel(clubPanel,clubRow,clubCol,clubSeatSize,Color.cyan);
//        clubPanel=makeClassPanel(econSeatSize,economyRow,economyCol,economyOK,economyNO,econRoom);
//        econClass = new classRoom(econSeatSize,economyRow,economyCol,economyOK,economyNO,econRoom);
//        economyPanel.add(econClass);

        this.add(fixEconOuter);

        economyLabel.setBounds(classLabelX,(fixEconOuterHeight/2)+Y_OFFSET,classLabelW,classLabelH);
        this.add(economyLabel);
        this.add(clubPanel);



    }







}