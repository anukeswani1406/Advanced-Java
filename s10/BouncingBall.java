/*
Slip no 10-2
Write a Multithreading program in java for bouncing ball. For each bounce, Change the color of ball randomly. 
*/

import java.awt.*;
import java.awt.event.*;

class BouncingBall extends Frame implements Runnable
{
	private int x,y,w,h,f;
	private Color c=Color.RED;

	public BouncingBall()
	{
		setTitle("Bouncing Balling");
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

		x = (int)(Math.random()*w);
		y = (int)(Math.random()*h);

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
				y++;
				if(y>h-50)
				{
					c = new Color((int)(Math.random()*256),
							(int)(Math.random()*256),
							(int)(Math.random()*256));
					f=1;
				}							
				break;

			case 1:
				y--;
				if(y<0)
				{
					c = new Color((int)(Math.random()*256),
							(int)(Math.random()*256),
							(int)(Math.random()*256));
					f=0;
				}
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
		g.setColor(c);
		g.fillOval(x,y,50,50);
	}

	public static void main(String args[])
	{
		new BouncingBall();
	}
}						




		