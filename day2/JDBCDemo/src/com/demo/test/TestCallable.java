package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Types;

import java.sql.CallableStatement;

public class TestCallable {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
			//step2 : getConnection
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
			Connection con=DriverManager.getConnection(url,"root","root123");
			if(con!=null) {
				System.out.println("connection done");
			}
			else {
				System.out.println("connection not done");
			}
			int id=20;
			CallableStatement cs=con.prepareCall("call getcnt(?,?)");
			cs.setInt(1, id);
			cs.registerOutParameter(2,java.sql.Types.INTEGER);
			cs.execute();
			int c=cs.getInt(2);
			System.out.println("no of employees : "+c);
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
