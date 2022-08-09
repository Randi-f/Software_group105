package utils;

import UI.Home;

import javax.swing.*;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/15 21:31
 */
public class CountDownThread implements Runnable{
    int time;
    JLabel timer;
    JFrame frame;
    public CountDownThread(int t, JLabel timer , JFrame jf){
        this.time=t;
        this.timer=timer;
        frame=jf;
    }


    @Override
    public void run() {
        int t=time;
        int i;
        boolean flagSet=false;
        for (i= t; i >= 0; i--) {
            timer.setText(i + "s to exit");
            try {
                Thread.sleep(1000);
                if(i < t*0.5 && i > 0){
                    if(!flagSet) {
                        ThreadHandler.timerFlag=1;
                        flagSet=true;
                    }
                }
                else if(i == 0){
                    frame.dispose();
                    Home home= new Home();
                    break;
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println(i);
    }
}
