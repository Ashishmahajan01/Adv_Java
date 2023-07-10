package com.demo.StudentRegistrationMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.StudentRegistrationMVC.beans.User;
import com.demo.StudentRegistrationMVC.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> displayuser() {
		return userDao.findAll();
	}

	@Override
	public void addUser(User u) {
		 userDao.save(u);
		
	}

	@Override
	public void deleteById(int id) {
		userDao.deleteById(id);
		
	}
   //  , String city
	@Override
	public void updateUser(User u) {
		Optional<User> op=userDao.findById(u.getId());
		if(op.isPresent()) {
			User u2=op.get();
			u2.setName(u.getName());
			u2.setAddress(u.getAddress());
			u2.setGender(u.getGender());
			u2.setCity(u.getCity());
			userDao.save(u);
		}
		
		
	}

}
