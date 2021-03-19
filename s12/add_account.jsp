<%@page import="java.sql.*" errorPage="err.jsp"%>

<%
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:tybca/bca@localhost:1521:XE");

	int ano = Integer.parseInt(request.getParameter("ano"));
	String type = request.getParameter("type");
	float bal = Float.parseFloat(request.getParameter("bal"));
	
	PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?)");

	ps.setInt(1,ano);
	ps.setString(2,type);
	ps.setFloat(3,bal);

	ps.executeUpdate();
%>

Account created successfully.<br>

<a href='account.html'>Add Account</a> 
<a href='view_accounts.jsp'>View Accounts</a>
