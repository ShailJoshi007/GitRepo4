package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromMySQL {

	public static void main(String[] args) throws SQLException {
		//Register or load Mysql Database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//getConnection to the db
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shaildb","root","root");
		
		// create statement
		Statement stat = connection.createStatement();
		String selectQuery = "select * from mybatch";
		ResultSet result =  stat.executeQuery(selectQuery);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		// close the db connection
		connection.close();

	}

}
