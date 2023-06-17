package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Connection con;
	private static PreparedStatement psins,psget,psgetById,psdel,psupdate,pssorted;
	
	static {
		try {
			con=DBUtil.getMyConnection();
			psins=con.prepareStatement("insert into employee values(?,?,?)");
			psget=con.prepareStatement("select * from employee");
			psgetById=con.prepareStatement("select * from employee where empid=?");
			psdel=con.prepareStatement("delete from employee where empid=?");
			psupdate=con.prepareStatement("update employee set sal=? where empid=?");
			pssorted=con.prepareStatement("select * from employee order by sal");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void closeConnection() {
		DBUtil.closeMyConnection();
		
	}
	@Override
	public void save(Employee e) {
		try {
			psins.setInt(1,e.getEmpid());
			psins.setString(2, e.getEname());
			psins.setDouble(3, e.getSal());
			psins.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	@Override
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> lst=new ArrayList<>();
			ResultSet rs=psget.executeQuery();
			while(rs.next()) {
				lst.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Employee getById(int id) {
		try {
			psgetById.setInt(1, id);
			ResultSet rs=psgetById.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteById(int id) {
		try {
			psdel.setInt(1, id);
			int n=psdel.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean modifyById(int id,double sal) {
		try {
			psupdate.setDouble(1, sal);
			psupdate.setInt(2,id);
			int n=psupdate.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Employee> displaySorted() {
		List<Employee> lst=new ArrayList<>();
		try {
			ResultSet rs=pssorted.executeQuery();
			while(rs.next()) {
				lst.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
