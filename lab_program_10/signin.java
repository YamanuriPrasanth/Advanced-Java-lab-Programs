import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Signin")
public class Signin extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private int visitCount;
    public Signin()
    {
        super();
    }
    public void init()
    {
        visitCount=1;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","HR");
            PreparedStatement ps=con.prepareStatement("select * from reg111 where uname=? and pass=?");
            ps.setString(1, request.getParameter("name1"));
            ps.setString(2, request.getParameter("pass1"));
            ResultSet rs=ps.executeQuery();
            Cookie ck=null;
            Cookie ck1[]=new Cookie[2];
            if(rs.next())
            {
                out.print("<h3>Welcome,"+request.getParameter("name1")+"</h3>");
                if(visitCount==1) 
                {
                    ck=new Cookie("count",""+visitCount);
                    response.addCookie(ck);
                    out.print("<h4> No of visits made:"+visitCount+"</h4>");
                    visitCount++;
                }
                else
                {
                    ck1=request.getCookies();
                    visitCount=Integer.parseInt(ck1[0].getValue());
                    visitCount++;
                    ck1[0].setValue(""+visitCount);
                    response.addCookie(ck1[0]);
                    out.print("<h4> No of visits:"+visitCount+"</h4>");
                }
            }
            else
                out.print("<h3>Invalid credentials<a href='login.html'>Login</a></h3>");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

