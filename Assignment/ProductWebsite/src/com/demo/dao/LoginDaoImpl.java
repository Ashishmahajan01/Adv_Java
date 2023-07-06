package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao {
	private static Connection conn;
	private static PreparedStatement pst, psins, psuserins;

	static {
		conn = DBUtil.getMyConnection();
		try {
			pst = conn.prepareStatement("select * from user where uname=? and password=?");
			psins = conn.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?)");
			psuserins = conn.prepareStatement("insert into user value(?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MyUser authenticateUser(String uname, String pass) {
		try {
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs =pst.executeQuery();
			if(rs.next()){
				return new MyUser(uname,pass,rs.getString(3));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
