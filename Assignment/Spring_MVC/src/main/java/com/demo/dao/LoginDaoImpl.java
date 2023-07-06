package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private JdbcTemplate jadbcTemplate;

	@Override
	public MyUser validateUser(String un, String pass) {

		try {
			return jadbcTemplate.queryForObject("select * from user where uname=? and password=?",
					new Object[] { un, pass }, BeanPropertyRowMapper.newInstance(MyUser.class));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Ganesh");
			return null;
		}
	}

}
