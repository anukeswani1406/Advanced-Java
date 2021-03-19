/*
 *Slip no 5-1
 *Write a java program to create Teacher table(TNo.TName, Sal, Desg) and insert a record in it.
 */
 
import java.sql.*;
import java.io.*;

class TeacherDB
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PreparedStatement ps = con.prepareStatement("insert into slip5 values(?,?,?,?)");

			String ch="";
			
			do
			{
				System.out.print("Enter TNo:");
				int tno = Integer.parseInt(br.readLine());
				
				System.out.print("Enter TName:");
				String name = br.readLine();
				
				System.out.print("Enter salary:");
				float sal = Float.parseFloat(br.readLine());
				
				System.out.print("Enter designation:");
				String dsgn = br.readLine();

				ps.setInt(1,tno);
				ps.setString(2,name);
				ps.setFloat(3,sal);
				ps.setString(4,dsgn);

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