package praticeadvance.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestWithoutBean {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root","root");
 PreparedStatement ps=  co.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
 
 ps.setInt(1,312);
 ps.setString(2,"vikash");
 ps.setInt(3,420);
 ps.setInt(4,77);
 ps.setInt(5,44);
 ps.setInt(6,55);
               
       int i=   ps.executeUpdate();
       
       System.out.println(i+"inserted");
		
	}

}
