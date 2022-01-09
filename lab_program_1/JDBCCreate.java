import java.sql.*;
public class JDBCCreate
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "SA");
			Statement st=con.createStatement();
			boolean b=st.execute("create table Employee(id int Primary key,name varchar(15),age int,department int,address varchar(20),salary_basic int,salary_DA int,salary_HRA int);");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
