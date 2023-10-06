package in.crud;
//Statement is not dynamic so we move to Preparedstatement.
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	//task to get the properties from the application file and loading the driver with connection
	public static Connection getConnection() throws IOException, SQLException
	{
		FileInputStream fis=new FileInputStream("app.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String password=p.getProperty("password");
		
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
		
	}
	//close the connection
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException
	{
		if(connection!=null)
		{
			connection.close();
		}
		if(preparedStatement!=null)
		{
			preparedStatement.close();
		}
		if(resultSet!=null)
		{
			resultSet.close();
		}
	}
}
