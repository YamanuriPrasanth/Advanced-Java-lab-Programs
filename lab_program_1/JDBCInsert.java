import java.sql.*;

public class JDBCInsert {

	public static void main(String[] args) {
		Connection con;
		try
		{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			Statement st=con.createStatement();
			int n=st.executeUpdate("insert into Employee values(101,'pqr',23,5,'chennai',230,460,2),(102,'iqr',22,3,'Mumbai',220,350,35);");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
