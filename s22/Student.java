/*
Slip no 22-2
Write a java program to create a student table with field’s rno, name and per. Insert values in the table. Display all the details of the student on screen. (Use PreparedStatement Interface)
*/

import java.sql.*;
import java.io.*;

class Student
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PreparedStatement ps = con.prepareStatement("create table stud(rno integer primary key, name varchar(30), per float)");

		ps.execute();		

		ps = con.prepareStatement("insert into stud values(?,?,?)");

		String ch="";

		do{
			System.out.print("Enter roll no:");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter name:");
			String name = br.readLine();
			
			System.out.print("Enter percentage:");
			float per = Float.parseFloat(br.readLine());

			ps.setInt(1,rno);
			ps.setString(2,name);
			ps.setFloat(3,per);

			ps.executeUpdate();

			System.out.print("Add More (Y/N)?");
			ch = br.readLine();
		}while(ch.equals("Y"));
		
		ps = con.prepareStatement("select * from stud");
		ResultSet rs = ps.executeQuery();

		while(rs.next())
		{
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3));
		}

		con.close();
	}
}