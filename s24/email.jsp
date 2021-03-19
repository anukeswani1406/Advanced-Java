<%
	String email = request.getParameter("email");

	int i = email.indexOf('@');
	int j = email.lastIndexOf('@');

	int k = email.indexOf('.');

	if(i!=-1 && j!=-1 && i==j && k!=-1 && k>i)
		out.print(email+" is valid email.");
	else
		out.print(email+" is invalid email.");
%>