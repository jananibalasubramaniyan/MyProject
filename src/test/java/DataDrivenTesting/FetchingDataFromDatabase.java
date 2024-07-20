package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class FetchingDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("");
		
		Statement state=conn.createStatement();
		String query="select * from student";
		
		ResultSet result=state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}

			
			
				
		conn.close();
	}

}
