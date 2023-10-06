package CRUDoperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.crud.JDBCUtil;

public class selectQuery {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtil.getConnection();
			if(connection!=null)
			{
				String mysqlQuery="select * from student where roll_no=?";
				preparedStatement=connection.prepareStatement(mysqlQuery);
				
				if(preparedStatement!=null)
				{
					System.out.println("Enter roll number to get data from the database postgresql ");
					int roll_no=sc.nextInt();
					
					preparedStatement.setInt(1, roll_no);
			    
				resultSet=preparedStatement.executeQuery();
				
				if(resultSet!=null)
				{
					if(resultSet.next())
					{
						System.out.println("ROLL_NO\t  NAME \t  GRADE");
						System.out.println(resultSet.getInt(1)+"\t  "+resultSet.getString(2)+"\t"+resultSet.getString(3));
					}
				}
				
				}
				
			}
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();//it print exception
		}finally {
			try {
				JDBCUtil.close(connection, preparedStatement,resultSet);//resource tho close hoga hi hoga
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
