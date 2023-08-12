package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testselect {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn =	DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
   Statement stml = conn.createStatement();
   ResultSet rs  = stml.executeQuery("select *  from marksheet");
   
   
   System.out.println("data selected="+ rs);
   while(rs.next()){
	   System.out.println(rs.getInt(1));
	
	   System.out.println(rs.getString(2));
	   System.out.println(rs.getInt(3));
	   
	   
   }
		

}
}
