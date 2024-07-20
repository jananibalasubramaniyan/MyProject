package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
	    DriverManager.registerDriver(driverRef);
	
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspiders_info", "root", "tiger");
	Statement stat = connection.createStatement();

String query = "insert into student_infom(first_name,last_name,address)values('shobha','rani','goa')";
int result = stat.executeUpdate(query);
	
if(result==1)
{
	System.out.println("data updated");
}
else
{
	System.out.println("not updated");
}
	}

}


