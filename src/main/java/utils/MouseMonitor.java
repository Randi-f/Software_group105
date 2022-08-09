package utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/5/16 00:52
 */
public class MouseMonitor implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("timer interrupted!");
        ThreadHandler.startTimer();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
