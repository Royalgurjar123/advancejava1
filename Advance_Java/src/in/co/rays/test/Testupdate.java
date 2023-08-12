
package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testupdate {
 public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn =	DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
	Statement stml = conn.createStatement();
int i =	stml.executeUpdate("update marksheet set maths = 12 where id =2");
	System.out.println( "data updated"+i);
	
}
}
