/*
Slip no 9-2
Write a Multithreading program in java using Runnable interface to move text on the frame as follow:
*/

import java.awt.*;
import java.awt.event.*;

class MovingText extends Frame implements Runnable
{
	private int x,y,w,h,f;

	public MovingText()
	{
		setTitle("Moving Text");
		setSize(400,400);
		setVisible(true);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});

		w = getWidth();
		h = getHeight();

		x = 0;
		y = h/2;

		Thread t = new Thread(this);
		t.start();
	}

	public void run()
	{
		while(true)
		{
			switch(f)
			{
			case 0:
				x++;
				y--;
				if(x==w/2 && y==0) f=1;
				break;

			case 1:
				x++;
				y++;
				if(x==w && y==h/2) f=2;
				break;

			case 2:
				x--;
				y++;
				if(x==w/2 && y==h) f=3;
				break;

			case 3:
				x--;
				y--;
				if(x==0 && y==h/2) f=0;
			}

			repaint();

			try
			{
				Thread.sleep(100);
			}

			catch(Exception e)
			{
			}
		}
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Hello",x,y);
	}

	public static void main(String args[])
	{
		new MovingText();
	}
}	
			








		
		
		