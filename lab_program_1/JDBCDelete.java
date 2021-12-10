import java.sql.*;


public class JDBCDelete
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "SA");
			PreparedStatement psmt=con.prepareStatement("delete from Employee where id=?;");
			psmt.setInt(1, 102);
			boolean b=psmt.execute();
			con.close();
		}
	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
