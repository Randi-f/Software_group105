package utils;

import UI.Home;
import UI.UIStyle;

import javax.swing.*;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/15 22:30
 */
public class ThreadHandler {
    static CountDownThread timerThread;
    public static volatile int timerFlag=0;
    static Thread currentThread=new Thread();
    static JFrame jp;
    public static void newTimerThread(int t, JLabel timer, JFrame frame){
        currentThread.interrupt();
        timerThread = new CountDownThread(t,timer,frame);
        jp=frame;
    }
    public static void startTimer(){
        currentThread.interrupt();
        ThreadHandler.timerFlag=0;
        currentThread = new Thread(timerThread);
        currentThread.start();
    }
    public static void shutTimer(){
        currentThread.interrupt();
    }
    static {
        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    if(ThreadHandler.timerFlag==1){
                        ThreadHandler.timerFlag=0;
                        int option = JOptionPane.showConfirmDialog(jp,"Do you want to continue?");

                        if (option == JOptionPane.YES_OPTION) {
                            System.out.println("continue");
                            ThreadHandler.startTimer();
                        }
                        else {
                            System.out.println("default option"+ option);
                            jp.dispose();
                            new UIStyle();
                            Home home= new Home();
                            ThreadHandler.currentThread.interrupt();
                        }
                    }

                }
            }
        });
        System.out.println("begin");
        t.start();

    }

    public void showDialog(){

    }

    public void monitorFlag(){

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }
    private class MonitorThread implements Runnable{
        @Override
        public void run() {
            for(;;){
                if(ThreadHandler.timerFlag==1){
                    ThreadHandler.timerFlag=0;
//                    Thread secondTImer(){
//
//                    }
                    int option = JOptionPane.showConfirmDialog(jp,"Do you want to continue?");
                    System.out.println(222);
                    if (option == JOptionPane.YES_OPTION) {
                        System.out.println("continue");
                        ThreadHandler.timerFlag=2;
                        ThreadHandler.currentThread.interrupt();
                    }
                    else {
                        jp.dispose();
                        ThreadHandler.currentThread.interrupt();
                    }
                }
                if(ThreadHandler.timerFlag==2){
                    startTimer();
                }

            }
        }
    }

}
