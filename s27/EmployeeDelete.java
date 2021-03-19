/*
 *Slip no 27-1
 *Write a JDBC program to delete the details of given employee (ENo EName Salary). Accept employee ID through command line.   
 */
 
 import java.sql.*;

class EmployeeDelete
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

			int eid = Integer.parseInt(args[0]);

			PreparedStatement ps = con.prepareStatement("delete from slip27 where eno=?");

			ps.setInt(1,eid);

			if(ps.executeUpdate()==1)
				System.out.println("Employee "+eid+" deleted successfully.");
			else
				System.out.println("Employee "+eid+" not found.");

			con.close();
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}