package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		//step 1 -register the driver
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
			//step 3: create connection
			Statement st=con.createStatement();
			
			//step 4 execute query
			int id=100;
			String name="xxxx' or '1'='1";
			String query="select * from employee where empid="+id+" and ename='"+name+"'";
			System.out.println("Query : "+query);
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Id : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Salary : "+rs.getDouble(3));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
