package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteDataToDataBase {
	public static void main(String[] args) throws SQLException {
		//Register or load Mysql Database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);		
		//getConnection to the db
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shaildb","root","root");		
		// create statement
		Statement stat = connection.createStatement();
		String insertQuery = "insert into mybatch(first_name,last_name,address)values('Tarun','Vyas','Bengalore') ";
		int result =  stat.executeUpdate(insertQuery);
		if(result==1)
		{
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Data not  Updated");
		}
		connection.close();
	}
}
