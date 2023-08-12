package in.co.rays.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testadd {
	public static void main(String[] args)  throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
   Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root"); 
   Statement stml = conn.createStatement();
   int i= stml.executeUpdate("insert into marksheet values(1,'dheeraj',102,11,33,44)");
   
   System.out.println("data inserted=" +i);
		
	}

}