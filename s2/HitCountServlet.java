/*
Slip no 2-2
Write a SERVLET program which counts how many times a user has visited a web page. If user is visiting the page for the first time, display a welcome message. If the user is revisiting the page, display the number of times visited. (Use Cookie)
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HitCountServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

		int count=1;

		Cookie c[] = req.getCookies();

		if(c==null)
		{
			Cookie newCookie = new Cookie("count","1");
			res.addCookie(newCookie);
			
			out.print("<h1>Welcome Servlet</h1>");
		}
		else
		{
			count = Integer.parseInt(c[0].getValue())+1;
			c[0].setValue(Integer.toString(count));
			res.addCookie(c[0]);
		}

		out.print("Hit Count:"+count);
	}
}