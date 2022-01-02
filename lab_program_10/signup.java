import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Signup")
public class Signup extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public Signup(){}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","HR");
            PreparedStatement ps=con.prepareStatement("insert into reg111 values(?,?)");
            ps.setString(1, request.getParameter("name1"));
            ps.setString(2, request.getParameter("pass1"));
            ps.executeUpdate();
            out.print("<h3>Registration Done</h3>&nbsp &nbsp &nbsp<a href='login.html'>Login</a>");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
