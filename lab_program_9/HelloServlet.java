import java.io.*;
import javax.servlet.*;
public class HelloServlet extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<B>Hello!");
		pw.println("<br>");
		pw.println("<h1> Hello Servlet");
		pw.close();
	}
}

