package UI;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * javaÑÝÊ¾µ¹¼ÆÊ±
 *
 */
public class timer extends JLabel{
	private JLabel jl;
	
	public timer() {
		
		jl = new JLabel();
		int time = 5;
		while(time>=0) {
			jl.setText(time + "s");
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			time--;
		}
		
			
	}
	

}
