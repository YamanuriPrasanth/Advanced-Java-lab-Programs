import java.sql.*;


public class JDBCSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Employee;");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3)+""+rs.getInt(4)+""+
			rs.getString(5)+""+rs.getInt(6)+""+rs.getInt(7)+""+rs.getInt(8));
			
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
