package CRUDoperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.crud.JDBCUtil;

public class updateQuery {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtil.getConnection();
			if(connection!=null)
			{
				String mysqlQuery="update student set name=? where roll_no=?";
				preparedStatement=connection.prepareStatement(mysqlQuery);
				
				if(preparedStatement!=null)
				{
					System.out.println("Enter roll number where we want to update the data");
					int roll_no=sc.nextInt();
					System.out.println("Enter Name which you want to change ");
					String name=sc.next();
					
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, roll_no);
					
				int roweffected=preparedStatement.executeUpdate();
				if(roweffected==1)
				{
					System.out.println("Row updated");	
				}
				else {
					System.out.println("Row not updated");
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
}
