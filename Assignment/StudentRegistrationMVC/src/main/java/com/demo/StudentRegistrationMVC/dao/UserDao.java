package com.demo.StudentRegistrationMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.StudentRegistrationMVC.beans.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
