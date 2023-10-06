package CRUDoperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.crud.JDBCUtil;

public class insertQuery {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtil.getConnection();
			if(connection!=null)
			{
				String mysqlQuery="insert into student (roll_no,name,grade)values(?,?,?)";
				preparedStatement=connection.prepareStatement(mysqlQuery);
				
				if(preparedStatement!=null)
				{
					System.out.println("Enter roll Number");
					int rollnum=sc.nextInt();
					System.out.println("Enter name");
					String name=sc.next();
					System.out.println("Enter grade");
					String grade=sc.next();
					preparedStatement.setInt(1, rollnum);
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, grade);
					
				int roweffected=preparedStatement.executeUpdate();
				if(roweffected==1)
				{
					System.out.println("Row inserted");	
				}
				else {
					System.out.println("Row not effected");
				}
				}
				
			}
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();//it print exception
		}finally {
			try {
				JDBCUtil.close(connection, preparedStatement, null);//resource tho close hoga hi hoga
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}/*//statement
try {
	connection=JDBCUtil.getConnection();
	if(connection!=null)
	{
		statement=connection.createStatement();
		String myinsertQuery="insert into student(roll_no,name,grade)values(2,'Abhishek','3')";
		int roweffected=statement.executeUpdate(myinsertQuery);
		
		if(roweffected==1)
		{
			System.out.println("Row is inserted ");
		}else {
			System.out.println("Row not inserted");
		}
	}
}*/
