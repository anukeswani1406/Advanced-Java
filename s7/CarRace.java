/*
Slip no 7-2
Write a Multithreading program in java for Racing Car.	(Use AWT)
*/

import java.awt.*;
import java.awt.event.*;

class CarRace extends Frame
{
	private CarThread t1,t2;

	public CarRace()
	{
		setTitle("Car Racing");
		setSize(500,300);
		setLocation(100,100);
		setVisible(true);

		t1 = new CarThread();
		t2 = new CarThread();

		t1.start();
		t2.start();

	}

	public void paint(Graphics g)
	{
		super.paint(g);

		g.setColor(Color.RED);
		g.fillRect(t1.getX(),70,75,45);

		g.setColor(Color.GREEN);
		g.fillRect(t2.getX(),150,75,45);
	}

	class CarThread extends Thread
	{
		private int x;
		public void run()
		{
			while(true)
			{
				x++;
				if(x>getWidth()) 
					System.exit(0);

				try
				{
					Thread.sleep((int)(Math.random()*1000));
				}

				catch(Exception e)
				{
				}

				repaint();
			}
		}

		public int getX()
		{
			return x;
		}
	}

	public static void main(String args[])
	{
		new CarRace();
	}
}
									
			

