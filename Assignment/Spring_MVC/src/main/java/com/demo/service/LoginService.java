package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {
	MyUser validateUser(String un, String pass);

}
