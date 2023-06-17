package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void closeConnection();

	void save(Employee e);

	List<Employee> getAllEmployees();

	Employee getById(int id);

	boolean deleteById(int id);

	boolean modifyById(int id, double sal);

	List<Employee> displaySorted();

}
