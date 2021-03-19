/*
 *Slip no 27-2
 *Write a Multithreading  program in java to create an applet that contains a TextField to show time. The time should be displayed in the hh:mm:ss format. The thread should start when the user clicks the Start button and stop when the user clicks the stop button. Initialize the values to current time.
 */
 
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StopWatchApplet extends JApplet
{
	private JTextField txtTime;
	private JButton btnStart,btnStop;

	private MyThread t;

	public void init()
	{
		txtTime = new JTextField(10);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");

		btnStart.setMnemonic('S');
		btnStop.setMnemonic('o');

		btnStart.setToolTipText("Resume watch");
		btnStop.setToolTipText("Suspend watch");

		setLayout(new FlowLayout());
		add(txtTime);
		add(btnStart);
		add(btnStop);

		t = new MyThread();
		t.start();

		ButtonHandler bh = new ButtonHandler();
		btnStart.addActionListener(bh);
		btnStop.addActionListener(bh);
	}

	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==btnStart)
				t.resume();

			if(ae.getSource()==btnStop)
				t.suspend();
		}
	}

	class MyThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				Date d = new Date();
				txtTime.setText(
				d.getHours()+":"+
				d.getMinutes()+":"+
				d.getSeconds());

				try
				{
					Thread.sleep(1000);
				}

				catch(Exception e)
				{
				}
			}
		}
	}
}

/*
<applet code=StopWatchApplet width=400 height=200>
</applet>
*/