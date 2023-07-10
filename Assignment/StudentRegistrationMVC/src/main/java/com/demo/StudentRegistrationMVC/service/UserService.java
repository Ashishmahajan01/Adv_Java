package com.demo.StudentRegistrationMVC.service;

import java.util.List;

import com.demo.StudentRegistrationMVC.beans.User;

public interface UserService {

	List<User> displayuser();

	void addUser(User u);

	void deleteById(int id);

	void updateUser(User u);

}
