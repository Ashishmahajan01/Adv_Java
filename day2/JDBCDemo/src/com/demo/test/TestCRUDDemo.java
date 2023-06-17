package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestCRUDDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		EmployeeService es=new EmployeeServiceImpl();
		do {
		System.out.println("1. add new employee\n2. delete emplyee \n 3. modify employee");
		System.out.println("4. display all\n5. display by id \n 6. display in sorted order\n 7. exit\n choice :");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			es.addnewEmployee();
			break;
		case 2:
			System.out.println("enetr id");
			int id=sc.nextInt();
			boolean status=es.deleteById(id);
			if(status) {
				System.out.println("deleted");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 3:
			System.out.println("enetr id");
			id=sc.nextInt();
			System.out.println("enetr salary");
			double s=sc.nextInt();
			status=es.updateById(id,s);
			if(status) {
				System.out.println("updated successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 4:
			List<Employee> lst=es.displayAll();
			lst.forEach(System.out::println);
			break;
		case 5:
			System.out.println("enetr id");
			id=sc.nextInt();
			Employee e=es.displayById(id);
			if(e!=null)
				System.out.println(e);
			else {
				System.out.println("not found");
			}
			break;
		case 6:
			lst=es.displaySorted();
			lst.forEach(System.out::println);
			break;
		case 7:
			es.closeConnection();
			System.out.println("Thank you for visiting.....");
			break;
		}
		}while(choice!=7);
		
	}

}
