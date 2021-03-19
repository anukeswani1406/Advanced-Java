import java.io.*;
import java.net.*;

class Server
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss = new ServerSocket(7080);
		
		while(true)
		{
			Socket s = ss.accept();

			DataInputStream fromClient = new DataInputStream(s.getInputStream());
			DataOutputStream toClient = new DataOutputStream(s.getOutputStream());

			int n = Integer.parseInt(fromClient.readLine());

			int f=1;

			for(int i=1;i<=n;i++)
				f*=i;
	
			toClient.writeBytes(f+"\n");
		}
	}
}
