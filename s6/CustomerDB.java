/*
 *Slip no 6-1
 *Write a JDBC program to accept the details of customer (CID, CName, Address, Ph_No) and store it into the database (Use PreparedStatement interface)
 */
 
 import java.sql.*;
import java.io.*;

class CustomerDB
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PreparedStatement ps = con.prepareStatement("insert into slip6 values(?,?,?,?)");

			String ch="";
			
			do
			{
				System.out.print("Enter CID:");
				int cid = Integer.parseInt(br.readLine());
				
				System.out.print("Enter CName:");
				String name = br.readLine();
				
				System.out.print("Enter Address:");
				String addr = br.readLine();
				
				System.out.print("Enter Phone No:");
				String phno = br.readLine();

				ps.setInt(1,cid);
				ps.setString(2,name);
				ps.setString(3,addr);
				ps.setString(4,phno);

				ps.executeUpdate();
			
				System.out.print("Continue Y/N?");
				ch = br.readLine();
			}while(ch.equals("Y"));

			con.close();
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}