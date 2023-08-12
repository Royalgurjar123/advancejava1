package praticeadvance.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testadd4 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/barberjava", "root", "root"); 
		   Statement stml = conn.createStatement();
		   int i= stml.executeUpdate("insert into person values(6,'virat',400)");
		   
		   System.out.println("data inserted=" +i);

	}

}
