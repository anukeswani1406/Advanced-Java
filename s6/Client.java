/*
Slip no 6-2
Write a SOCKET program in java to check whether given file is present on server or not, If it is present then display its content on the server’s machine otherwise display error message.
*/

import java.io.*;
import java.net.*;

class Client
{
	public static void main(String args[]) throws Exception
	{
		Socket s = new Socket("localhost",7080);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter file name:");
		String fileName = br.readLine();

		DataInputStream fromServer = new DataInputStream(s.getInputStream());

		DataOutputStream toServer = new DataOutputStream(s.getOutputStream());

		toServer.writeBytes(fileName+"\n");

		String str="";

		while(true)
		{
			str = fromServer.readLine();
			if(str.equals("END")) break;

			System.out.println(str);
		}				
	}
}