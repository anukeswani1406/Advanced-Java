<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));

	if(age>=18)
		out.print(name+" you are eligible for voting");
	else
		out.print(name+" you are not eligible for voting");
%>