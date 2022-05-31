package com.cn.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cn.model.*;

public class JdbcJavabean {
	private List<goods> list;
	private List<stock_list> list2;
	private List<emp> list3;
	private List<member> list4;
	private List<salelist> list5;
	private List<Vendor> list6;


	public List<goods> getList() {
		return list;
	}

	public void setList(List<goods> list) {
		this.list = list;
	}

	public List findallgoods() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��Ʒ");
			list = new ArrayList<goods>();
			while (rst.next()) {
				goods u = new goods();
				u.setGoods_id(rst.getInt(1));
				u.setGoods_name(rst.getString(2));
				u.setGoods_price(rst.getFloat(3));
				u.setGoods_number(rst.getInt(4));
				u.setGoods_shelf_number(rst.getString(5));
				list.add(u);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list;

	}

	public List findallsl() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��浥");
			list2 = new ArrayList<stock_list>();
			while (rst.next()) {
				stock_list ls = new stock_list();
				ls.setSl_id(rst.getInt(1));
				ls.setSl_name(rst.getString(2));
				ls.setGoods_number(rst.getInt(3));
				ls.setGoods_price(rst.getFloat(4));
				ls.setSupplier_name(rst.getString(5));
//				ls.setRuku_name(rst.getString(6));
				list2.add(ls);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list2;

	}

	public List findallemp() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ְ��");
			list3 = new ArrayList<emp>();
			while (rst.next()) {
				emp em = new emp();
				em.setEmpid(rst.getInt(1));
				em.setEmpname(rst.getString(2));
				em.setEmptel(rst.getString(3));
				em.setEmppos(rst.getString(4));
				list3.add(em);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list3;

	}

	public List findallmem() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��Ա");
			list4 = new ArrayList<member>();
			while (rst.next()) {
				member mem = new member();
				mem.setMemid(rst.getInt(1));
				mem.setMemname(rst.getString(2));
				mem.setMemtel(rst.getString(3));
				mem.setMemjifen(rst.getInt(4));
				list4.add(mem);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list4;

	}

	public List findallsale() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from �����嵥");
			list5 = new ArrayList<salelist>();
			while (rst.next()) {
				salelist sale = new salelist();
				sale.setSaleid(rst.getInt(1));
				sale.setSalename(rst.getString(2));
				sale.setSalenum(rst.getInt(3));
				sale.setTotal(rst.getFloat(4));
				sale.setDate(rst.getString(5));
				sale.setFunder(rst.getString(6));
				list5.add(sale);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list5;

	}
	

	public List findgoodsbyid(String goods_id) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��Ʒ where ��Ʒ���=" + goods_id);
			list = new ArrayList<goods>();
			while (rst.next()) {
				goods u = new goods();
				u.setGoods_id(rst.getInt(1));
				u.setGoods_name(rst.getString(2));
				u.setGoods_price(rst.getFloat(3));
				u.setGoods_number(rst.getInt(4));
				u.setGoods_shelf_number(rst.getString(5));
				list.add(u);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list;
	}

	public List findslbyid(String sl_id) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��浥 where ��浥���=" + sl_id);
			list2 = new ArrayList<stock_list>();
			while (rst.next()) {
				stock_list sl = new stock_list();
				sl.setSl_id(rst.getInt(1));
				sl.setSl_name(rst.getString(2));
				sl.setGoods_number(rst.getInt(3));
				sl.setGoods_price(rst.getFloat(4));
				sl.setSupplier_name(rst.getString(5));
//				sl.setRuku_name(rst.getString(6));
				list2.add(sl);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list2;
	}

	public List findempbyid(String empid) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ְ�� where ְ�����=" + empid);
			list3 = new ArrayList<emp>();
			while (rst.next()) {
				emp em = new emp();
				em.setEmpid(rst.getInt(1));
				em.setEmpname(rst.getString(2));
				em.setEmptel(rst.getString(3));
				em.setEmppos(rst.getString(4));
				list3.add(em);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list3;

	}

	public List findmembyid(String memid) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��Ա where ��Ա���=" + memid);
			list4 = new ArrayList<member>();
			while (rst.next()) {
				member mem = new member();
				mem.setMemid(rst.getInt(1));
				mem.setMemname(rst.getString(2));
				mem.setMemtel(rst.getString(3));
				mem.setMemjifen(rst.getInt(4));
				list4.add(mem);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list4;

	}

	public List findsalebyid(String sale_id) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from �����嵥 where �嵥���=" + sale_id);
			list5 = new ArrayList<salelist>();
			while (rst.next()) {
				salelist sale = new salelist();
				sale.setSaleid(rst.getInt(1));
				sale.setSalename(rst.getString(2));
				sale.setSalenum(rst.getInt(3));
				sale.setTotal(rst.getFloat(4));
				sale.setDate(rst.getString(5));
				sale.setFunder(rst.getString(6));
				list5.add(sale);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}

		return list5;
	}

	
	public boolean insertgoods(goods goods) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "INSERT INTO ��Ʒ(��Ʒ���,��Ʒ����,��Ʒ����,��Ʒ����,��Ʒ���ܺ�) VALUES (?,?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,goods.getGoods_id()) ;
		ps.setString(2,goods.getGoods_name()) ;
		ps.setFloat(3,goods.getGoods_price()) ;
		ps.setInt(4,goods.getGoods_number()) ;
		ps.setString(5,goods.getGoods_shelf_number()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean insertsl(stock_list sl) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "INSERT INTO ��浥(��浥���,��浥����,��Ʒ����,��Ʒ����,��Ӧ������,�����) VALUES (?,?,?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,sl.getSl_id()) ;
		ps.setString(2,sl.getSl_name()) ;
		ps.setInt(3,sl.getGoods_number()) ;
		ps.setFloat(4,sl.getGoods_price()) ;
		ps.setString(5,sl.getSupplier_name()) ;
		ps.setString(6,"11") ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean insertsale(salelist sale) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "INSERT INTO �����嵥(�嵥���,�嵥����,�嵥����,�ܽ��,��������,������) VALUES (?,?,?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,sale.getSaleid()) ;
		ps.setString(2,sale.getSalename()) ;
		ps.setInt(3,sale.getSalenum()) ;
		ps.setFloat(4,sale.getTotal()) ;
		ps.setString(5,sale.getDate()) ;
		ps.setString(6,sale.getFunder()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean insertemp(emp emp) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "INSERT INTO ְ��(ְ�����,ְ������,ְ���绰,ְ��ְλ) VALUES (?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,emp.getEmpid()) ;
		ps.setString(2,emp.getEmpname()) ;
		ps.setString(3,emp.getEmptel()) ;
		ps.setString(4,emp.getEmppos()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean insertmem(member mem) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "INSERT INTO ��Ա(��Ա���,��Ա����,��Ա�绰,��Ա����) VALUES (?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,mem.getMemid()) ;
		ps.setString(2,mem.getMemname()) ;
		ps.setString(3,mem.getMemtel()) ;
		ps.setInt(4,mem.getMemjifen()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	
	public boolean updategoods(goods goods) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "update ��Ʒ set ��Ʒ����=?,��Ʒ����=?,��Ʒ����=?,��Ʒ���ܺ�=? where ��Ʒ���=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,goods.getGoods_name()) ;
		ps.setFloat(2,goods.getGoods_price()) ;
		ps.setInt(3,goods.getGoods_number()) ;
		ps.setString(4,goods.getGoods_shelf_number()) ;
		ps.setInt(5,goods.getGoods_id()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean updatesl(stock_list sl) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "update ��浥 set ��浥����=?,��Ʒ����=?,��Ʒ����=?,��Ӧ������=?,�����=? where ��浥���=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,sl.getSl_name()) ;
		ps.setInt(2,sl.getGoods_number()) ;
		ps.setFloat(3,sl.getGoods_price()) ;
		ps.setString(4,sl.getSupplier_name()) ;
		ps.setString(5,"10") ;
		ps.setInt(6,sl.getSl_id()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean updatesale(salelist sale) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "update �����嵥 set �嵥����=?,�嵥����=?,�ܽ��=?,��������=?,������=? where �嵥���=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,sale.getSalename()) ;
		ps.setInt(2,sale.getSalenum()) ;
		ps.setFloat(3,sale.getTotal()) ;
		ps.setString(4,sale.getDate()) ;
		ps.setString(5,sale.getFunder()) ;
		ps.setInt(6,sale.getSaleid()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean updateemp(emp emp) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "update ְ�� set ְ������=?,ְ���绰=?,ְ��ְλ=? where ְ�����=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,emp.getEmpname()) ;
		ps.setString(2,emp.getEmptel()) ;
		ps.setString(3,emp.getEmppos()) ;
		ps.setInt(4,emp.getEmpid()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	public boolean updatemem(member mem) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "update ��Ա set ��Ա����=?,��Ա�绰=?,��Ա����=? where ��Ա���=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,mem.getMemname()) ;
		ps.setString(2,mem.getMemtel()) ;
		ps.setInt(3,mem.getMemjifen()) ;
		ps.setInt(4,mem.getMemid()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
	
	public boolean delgoodsbyid(String goods_id) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		Statement stmt = con.createStatement();
		String sql = "delete from  ��Ʒ WHERE ��Ʒ���=";
		int rst = stmt.executeUpdate(sql + goods_id);
		if(rst>0) {
			flag=true;
		}
		return flag;
	}
	public boolean delslbyid(String sl_id) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		Statement stmt = con.createStatement();
		String sql = "delete from  ��浥 WHERE ��浥���=";
		int rst = stmt.executeUpdate(sql + sl_id);
		if(rst>0) {
			flag=true;
		}
		return flag;
	}
	public boolean delsalebyid(String saleid) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		Statement stmt = con.createStatement();
		String sql = "delete from  �����嵥 WHERE �嵥���=";
		int rst = stmt.executeUpdate(sql + saleid);
		if(rst>0) {
			flag=true;
		}
		return flag;
	}
	public boolean delempbyid(String empid) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		Statement stmt = con.createStatement();
		String sql = "delete from  ְ�� WHERE ְ�����=";
		int rst = stmt.executeUpdate(sql + empid);
		if(rst>0) {
			flag=true;
		}
		return flag;
	}
	public boolean delmembyid(String memid) throws Exception {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		Statement stmt = con.createStatement();
		String sql = "delete from  ��Ա WHERE ��Ա���=";
		int rst = stmt.executeUpdate(sql + memid);
		if(rst>0) {
			flag=true;
		}
		return flag;
	}

	public List Find_Ve_all() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��Ӧ��");
			list6 = new ArrayList<Vendor>();
			while (rst.next()) {
				Vendor vendor = new Vendor();
				vendor.setVe_id(rst.getInt(1));
				vendor.setVe_name(rst.getString(2));
				vendor.setVe_tel(rst.getString(3));
				vendor.setVe_address(rst.getString(4));
				list6.add(vendor);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return list6;
	}

	public List Find_Ve_id(String ve_id) throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from ��Ӧ�� where ���̱��=" + ve_id);
			list6 = new ArrayList<Vendor>();
			while (rst.next()) {
				Vendor vendor = new Vendor();
				vendor.setVe_id(rst.getInt(1));
				vendor.setVe_name(rst.getString(2));
				vendor.setVe_tel(rst.getString(3));
				vendor.setVe_address(rst.getString(4));
				list6.add(vendor);
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return list6;
	}

	public boolean de_Ve_id(String ve_id) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		Statement stmt = con.createStatement();
		String sql = "delete from  ��Ӧ�� WHERE ���̱��=";
		int rst = stmt.executeUpdate(sql + ve_id);
		if(rst>0) {
			flag=true;
		}
		return flag;
	}

	public boolean insertVendor(Vendor vendor) throws ClassNotFoundException, SQLException {

		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "INSERT INTO ��Ӧ��(���̱��,��������,���̵绰,���̵�ַ) VALUES (?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,vendor.getVe_id()) ;
		ps.setString(2,vendor.getVe_name()) ;
		ps.setString(3, vendor.getVe_tel()); ;
		ps.setString(4, vendor.getVe_address()); ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}

	public boolean update_Ve(Vendor vendor) throws SQLException, ClassNotFoundException {
		boolean flag = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/supermarket?useUnicode=true&characterEncoding=utf8", "root", "03024");
		String sql = "update ��Ӧ�� set ��������=?,���̵绰=?,���̵�ַ=? where ���̱��=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,vendor.getVe_name()) ;
		ps.setString(2,vendor.getVe_tel()) ;
		ps.setString(3,vendor.getVe_address()) ;
		ps.setInt(4,vendor.getVe_id()) ;
		int rst = ps.executeUpdate();
		if(rst>0) {
			flag = true ;
		}
		return flag ;
	}
}
