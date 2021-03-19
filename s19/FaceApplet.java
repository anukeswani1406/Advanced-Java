/*
Slip no 19-2
Write a Multithreading program in java to convert smile face into the crying face after 5 seconds and vice versa(Use Applet).
*/

import java.awt.*;
import java.applet.*;

public class FaceApplet extends Applet implements Runnable
{
	private Thread t;
	private boolean flag;

	public void init()
	{
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		while(true)
		{
			flag=!flag;
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

	public void paint(Graphics g)
	{
		super.paint(g);
		
		int w = getWidth();
		int h = getHeight();

		g.drawOval(20,20,w-40,h-40);
		g.drawOval(w/2-75,h/2-75,30,30);
		g.drawOval(w/2+75,h/2-75,30,30);
		
		if(flag)
		{
			g.drawArc(w/2-75,h/2-30,150,60,180,180);
		}
		else
		{
			g.drawArc(w/2-75,h/2-30,150,60,180,-180);
		}
	}
}

/*
<applet code=FaceApplet width=400 height=400></applet>
*/

		
		