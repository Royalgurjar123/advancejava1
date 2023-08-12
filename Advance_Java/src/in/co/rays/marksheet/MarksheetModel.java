package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class MarksheetModel {
	public Integer NextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet ");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}

		return pk + 1;

	}

	public void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values (?,?,?,?,?,?)");
		ps.setInt(1, NextPk());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_no());
		ps.setInt(4, bean.getPysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());

		int i = ps.executeUpdate();
		System.out.println("data inserted" + i);

	}

	public void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
		PreparedStatement ps = conn.prepareStatement(
				"update marksheet  set name =? , roll_no=?,pysics=?, chemistry=?,maths=? where id =?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRoll_no());
		ps.setInt(3, bean.getPysics());
		ps.setInt(4, bean.getChemistry());
		ps.setInt(5, bean.getMaths());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("data updated " + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from marksheet  where id =?");
		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("data  deleted" + i);

	}

	public MarksheetBean FindByRoll(int roll_no) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no =?");
		ps.setInt(1, roll_no);
		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setPysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

		}

		return bean;

	}

	public List Search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/advancejava", "root", "root");
		StringBuffer sql = new StringBuffer("select * from marksheet  where 1 = 1 ");
		List list = new ArrayList();
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");

			}
			if (bean.getId() != 0 && bean.getId() > 0) {
				sql.append(" and id=" + bean.getId());

			}
			if (bean.getRoll_no() != 0 && bean.getRoll_no() > 0) {
				sql.append(" and roll_no=" + bean.getRoll_no());
				
			}
			if (bean.getPysics()!=0&& bean.getPysics()>0) {
				sql.append(" and pysics="+ bean.getPysics());
				
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);

		}
		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setPysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);

		}

		return list;
	}
}
