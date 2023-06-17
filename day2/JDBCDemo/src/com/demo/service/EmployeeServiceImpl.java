package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao edao;

	public EmployeeServiceImpl() {
		super();
		this.edao = new EmployeeDaoImpl();
	}

	

	@Override
	public void addnewEmployee() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		System.out.println("enter name");
		String nm=sc.next();
		System.out.println("enter salary");
		double sal=sc.nextDouble();
		Employee e=new Employee(id,nm,sal);
		edao.save(e);
		
	}
	
	@Override
	public void closeConnection() {
		edao.closeConnection();
		
	}



	@Override
	public List<Employee> displayAll() {
		return edao.getAllEmployees();
	}



	@Override
	public Employee displayById(int id) {
		return edao.getById(id);
	}



	@Override
	public boolean deleteById(int id) {
		return edao.deleteById(id);
	}



	@Override
	public boolean updateById(int id,double sal) {
		return edao.modifyById(id,sal);
	}



	@Override
	public List<Employee> displaySorted() {
		return edao.displaySorted();
	}
	
}
