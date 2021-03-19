/*
 *Slip no 2-1
 *Write a multithreading program in java to display all the vowels from a given String.(Use Thread Class)
 */


import java.io.*;

class VowelsThread extends Thread
{
	private String s;

	public VowelsThread(String str)
	{
		s = str;
	}

	public void run()
	{
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
				System.out.println(i+":"+c);
		
			try
			{
				Thread.sleep((int)(Math.random()*1000));
			}

			catch(Exception e)
			{
			}
		}
	}
}

class VowelsThreadTest
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter string:");
		String s = br.readLine();

		VowelsThread t = new VowelsThread(s);
		t.start();
	}
}		