/*
 *Slip no 1-1
 *Write a java program to display IP Address and Name of client machine.
 */


import java.net.*;

class ClientInfo
{
	public static void main(String args[]) throws UnknownHostException
	{
		InetAddress i = InetAddress.getByName("localhost");
		
		System.out.println(i);
		
		System.out.println("IP Address:"+i.getHostAddress() + "\nName:"+i.getHostName());
	}
}
