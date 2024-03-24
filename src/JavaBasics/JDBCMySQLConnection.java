package JavaBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;




public class JDBCMySQLConnection {
	private static Properties properties = null;
	public static void getProperties(){
		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("C:\\Users\\mohd.mohammad.yaqoob\\Documents\\Eclipse\\SpringMVC\\JavaCourseAndMicroservices\\src\\JavaBasics\\database.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(fileInputStream!=null)
				fileInputStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	public static Connection getSQLConnection() throws SQLException {
		
		return DriverManager.getConnection(properties.getProperty("db_url"), properties.getProperty("db_username"),properties.getProperty("db_password"));
	
		
	}
	
	/**
	 * for Stored procedures we use Callable statements. in case we have a return value in our result set we use :
	 * callableStatement.registerOutparameter(Number, Types.Type)
	 * @param args
	 */

	public static void main(String[] args) {
		getProperties();
		try (Connection connection  = getSQLConnection()){
			
				System.out.println("Connection has been Established!!");
				try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
					try(ResultSet resultSet =  statement.executeQuery("SELECT id about, firstname, lastName FROM javadb.exnuserentity")) {
						while (resultSet.next()) {
						System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
