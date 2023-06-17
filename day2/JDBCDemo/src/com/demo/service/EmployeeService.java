package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;

public interface EmployeeService {

	void closeConnection();

	void addnewEmployee();

	List<Employee> displayAll();

	Employee displayById(int id);

	boolean deleteById(int id);

	boolean updateById(int id,double s);

	List<Employee> displaySorted();
	
	

}
