/*
 *Slip no 8-1
 *Write a Multithreading program using Runnable interface to blink Text on the frame. 
 */
 
 import java.awt.*;
import java.awt.event.*;

class BlinkText extends Frame implements Runnable
{
	private boolean flag;

	public BlinkText()
	{
		setTitle("Blink");
		setSize(500,300);
		setLocation(100,100);
		setVisible(true);

		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(flag?Color.WHITE:Color.BLACK);
		g.drawString("Welcome to TYBCA",50,150);
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1000);
			}
			
			catch(Exception e)
			{
			}

			flag=!flag;
			repaint();
		}
	}

	public static void main(String args[])
	{
		new BlinkText();
	}
}
									
			

