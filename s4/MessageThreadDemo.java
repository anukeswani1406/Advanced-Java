/*
 *Slip no 4-1
 *Write a java program to display “Hello Java” message n times on the screen. (Use Runnable Interface). 
 */


class MessageThread implements Runnable
{
	private int n;

	public MessageThread(int n)
	{
		this.n = n;
	}

	public void run()
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println("Hello Java");
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

class MessageThreadDemo
{
	public static void main(String args[])
	{
		new Thread(new MessageThread(10)).start();
	}
}