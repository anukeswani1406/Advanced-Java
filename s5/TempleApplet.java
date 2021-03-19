/*
Slip no 5-2
Write a MultiThreading program in java using Runnable interface to draw temple flag on an applet container. 
*/

import java.awt.*;
import java.applet.*;

public class TempleApplet extends Applet implements Runnable
{
	private int flag;
	
	public void init()
	{
		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g)
	{
		switch(flag)
		{
		case 11:
			g.drawLine(45,150,65,150);
		case 10:
			g.drawLine(65,200,65,150);
		case 9:
			g.drawLine(45,200,45,150);
		case 8:
			g.drawLine(75,10,55,30);
		case 7:
			g.drawLine(55,10,75,10);
		case 6:
			g.drawLine(55,50,55,10);
		case 5:
			g.drawLine(110,100,55,50);
		case 4:
			g.drawLine(10,100,55,50);
		case 3:
			g.drawLine(10,100,110,100);
		case 2:
			g.drawLine(110,200,110,100);
		case 1:
			g.drawLine(10,200,10,100);
		case 0:
			g.drawLine(10,200,110,200);
		}
	}

	public void run()
	{
		while(true)
		{
			flag=(flag+1)%12;
			repaint();
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

/*
<applet code=TempleApplet width=400 height=400></applet>
*/



				