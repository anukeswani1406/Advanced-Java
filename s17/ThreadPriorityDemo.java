/*
 *Slip no 17-1
 *Write a java program which will display name and priority of current thread. Change name of Thread to MyThread and priority to 2. Display the details of Thread.
 */
 
 class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread());
		
			if(i==5)
			{
				setPriority(2);
				setName("MyThread");
			}
		}
	}
}

class ThreadPriorityDemo
{
	public static void main(String args[])
	{
		new MyThread().start();
	}
}
