/*
 *Slip no 22-1
 *Write a Socket program in java in which client accept a number, send it to the server, server calculates its factorial and sends result to the client. 
 */
 
 import java.io.*;
import java.net.*;

class Client
{
	public static void main(String args[]) throws Exception
 	{
		Socket s = new Socket("localhost",7080);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter number:");
		String n = br.readLine();		

		DataOutputStream toServer = new DataOutputStream(s.getOutputStream());
		DataInputStream fromServer = new DataInputStream(s.getInputStream());

		toServer.writeBytes(n+"\n");
		System.out.println("Factorial:"+fromServer.readLine());
	}
}
