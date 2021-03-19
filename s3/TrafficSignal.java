/*
Slip no 3-2
Write a java program to simulate traffic signal using multithreading.
*/

import java.awt.*;
import java.awt.event.*;

class TrafficSignal extends Frame
{
	private int f;
	private MyThread t;

	public TrafficSignal()
	{
		t = new MyThread();
		t.start();

		setTitle("Traffic Signal");
		setSize(150,500);
		setVisible(true);
		setBackground(Color.BLACK);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		int w = 100;
		int h = 100;

		switch(f)
		{
		case 0:
			g.setColor(Color.RED);
			g.fillOval(70,200,w,h);
			g.setColor(Color.WHITE);
			g.fillOval(70,h+200,w,h);
			g.fillOval(70,2*h+200,w,h);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			g.fillOval(70,h+200,w,h);
			g.setColor(Color.WHITE);
			//g.fillOval(70,200,w,h);
			//g.fillOval(70,2*h+200,w,h);
			break;
		case 2:
			g.setColor(Color.GREEN);
			g.fillOval(70,2*h+200,w,h);
			g.setColor(Color.WHITE);
			//g.fillOval(70,200,w,h);
			//g.fillOval(70,h+200,w,h);
			break;
		}
	}

	class MyThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				f=(f+1)%3;
				repaint();
				try
				{
					Thread.sleep(5000);
				}

				catch(Exception e)
				{
				}
			}
		}
	}

	public static void main(String args[])
	{
		new TrafficSignal();
	}
}
			

			
		
		