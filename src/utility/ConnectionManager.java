package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// register the driver class
		Class.forName("oracle.jdbc.OracleDriver");
		
		// create the connection object
		Connection con =null;
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","887400");
	
//		if(con!=null) 
//			System.out.println("Established");
		return con;
		
	}
//	 public static Properties loadPropertiesFile() throws IOException {
//		 Properties prop = new Properties();
//		 InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
//		 prop.load(in);
//		 in.close();
//		 return prop;
//	 }
}
