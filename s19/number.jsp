<font color='blue'>
	<%
		String words[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

		String s = request.getParameter("no");

		for(int i=0;i<s.length();i++)
		{
			out.print(words[s.charAt(i)-'0']+" ");
		}
	%>
</font>	