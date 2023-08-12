package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testadd1 {
	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
			conn.setAutoCommit(false);
			Statement stml = conn.createStatement();
			int i = stml.executeUpdate("insert into marksheet values(204,'yash',505,34,45,67)");
			i = stml.executeUpdate("insert into marksheet values(205 ,'yash',505,34,45,67)");
			i = stml.executeUpdate("insert into marksheet values(12,'yash',505,34,45,67)");
			i = stml.executeUpdate("insert into marksheet values(206,'yash',505,34,45,67)");

			System.out.println("data  insertd" + i);
			conn.commit();
		}

		catch (Exception e) {
			conn.rollback();
			System.out.println(e);

		}

	}
}
