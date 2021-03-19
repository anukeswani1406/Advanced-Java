/*
 *Slip no 9-1
 *Write a JDBC program to delete the records of employees whose names are starting with ‘A’ character.
 */

import java.sql.*;

class EmpJDBC
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

		Statement s = con.createStatement();

		int n = s.executeUpdate("delete from slip9 where ename like 'A%'");
		System.out.println("No.of records deleted:"+n);

		con.close();
	}
}