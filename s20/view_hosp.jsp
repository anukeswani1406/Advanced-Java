/*
Slip no 20-1
Write a JSP program to display the details of Hospital (HNo, HName, Address) in tabular form on browser.  
*/


<%@page import="java.sql.*"%>
	
<%
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	Connection con = DriverManager.getConnection("jdbc:odbc:Anu");

	Statement s = con.createStatement();
	ResultSet rs = s.executeQuery("select * from slip20");
%>

<table border=1>
	<tr>
		<th>Hospital No</th>
		<th>Name</th>
		<th>Address</th>
	</tr>

	<%
		while(rs.next())
		{
	%>

	<tr>
		<td><%=rs.getInt(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
	</tr>

	<%
		}
	%>

</table>