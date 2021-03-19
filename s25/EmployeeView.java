/*
Slip no 25-2
Write a JDBC program for implementation of scrollable ResultSet. Consider Emp table (eno ename, sal) 
-	moveFirst
-	moveNext
-	movePrevious
-	moveLast   
*/

import java.sql.*;
import java.io.*;

class EmployeeView
{
	private static Connection con;
	private static Statement s;
	private static ResultSet rs;

	public static void show() throws Exception
	{
		System.out.println("Emp No:" + rs.getInt(1) + "\nName:" + rs.getString(2) + "\nSalary:" + rs.getFloat(3));
	}	

	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			con = DriverManager.getConnection("jdbc:odbc:Anu");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = s.executeQuery("select * from employees");

			int ch;
			while(true)
			{
				System.out.println("1.Move First" + "\n2.Move Next" + "\n3.Move Previous" + "\n4.Move Last" + "\n5.Exit" + "\nEnter your choice (1-5):");

				ch = Integer.parseInt(br.readLine());

				switch(ch)
				{
				case 1:
					rs.first();
					break;

				case 2:
					rs.next();
					if(rs.isAfterLast())
						rs.first();
					break;

				case 3:
					rs.previous();
					if(rs.isBeforeFirst())
						rs.last();
					break;

				case 4:
					rs.last();
					break;

				case 5:
					con.close();
					System.exit(0);				
				}
				show();
			}
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}