/*
 *Slip 10-1
 *Write a JDBC program to count the number of records in table. (Without using standard method)
 */
 
 import java.sql.*;

class RecordCount
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select * from slip10");

			int count=0;
			while(rs.next())
			{
				count++;
			}

			System.out.println("No.of records:"+count);
			rs.close();
			con.close();
		}
	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}