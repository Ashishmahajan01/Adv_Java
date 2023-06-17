package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
			con=DriverManager.getConnection(url,"root","root123");
			//to set autocommit off
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Salary : "+rs.getDouble(3));
			}
			int id=124;
			String name="Mugdha";
			double salary=444;
			PreparedStatement ps2=con.prepareStatement("insert into employee values(?,?,?)");
			ps2.setInt(1, id);
			ps2.setString(2, name);
			ps2.setDouble(3, salary);
			int num=ps2.executeUpdate();
			if(num>0) {
				System.out.println("inserted");
			    con.commit();
			}
			else {
				System.out.println("not inserted");
				con.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("error occured"+e.getMessage());
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
