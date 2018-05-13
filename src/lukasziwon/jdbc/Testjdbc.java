package lukasziwon.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_test?useSSL=false";
		String user = "hibernate";
		String pass = "hibernate";
		
		try  {
			System.out.println("Connecting to database: "+ jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user,pass);
			System.out.println("Connection successfull!!!");
			
			myConn.close();
			
		}
		catch (Exception exc)  {
			exc.printStackTrace();
		}
	}

}
