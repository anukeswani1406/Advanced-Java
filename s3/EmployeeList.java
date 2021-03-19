/*
 *Slip no 3-1
 *Write a JDBC program to displays the details of employees (eno, ename, department, sal) whose department is “Computer Science”.
 */


import java.sql.*;

class EmployeeList
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select * from slip3 where department='Computer Science'");

			System.out.println("ENo\tName\tSalary");

			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+ rs.getFloat(4));
			}

			rs.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}