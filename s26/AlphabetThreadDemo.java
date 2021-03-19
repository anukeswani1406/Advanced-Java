/*
 *Slip no 26-1
 *Write a Multithreading program in java to display all the alphabets from A to Z after 3 seconds.
 */
 
 class AlphabetThread extends Thread
{
	private char c;

	public AlphabetThread()
	{
		c='A';
	}

	public void run()
	{
		while(true)
		{
			System.out.println(c);
			c++;
			
			if(c=='Z'+1) 
				c='A';
			
			try
			{
				Thread.sleep(3000);
			}

			catch(Exception e)
			{
			}
		}
	}
}

class AlphabetThreadDemo
{
	public static void main(String args[])
	{
		new AlphabetThread().start();
	}
}
			