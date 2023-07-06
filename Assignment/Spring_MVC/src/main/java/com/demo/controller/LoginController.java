package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;


@Controller
//@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String showloginpage() {
		System.out.println("-------------------");
		return "loginpage";
	}
	@PostMapping("/validate")
	public ModelAndView validateUser(HttpSession session,@RequestParam("uname") String un,@RequestParam String pass) {
		MyUser u1 = loginService.validateUser(un, pass);
		System.out.println("In validate");
		if(u1 != null) {
			session.setAttribute("user",u1);
			return new ModelAndView("redirect:/product/viewproduct");
		}
		else {
			return new ModelAndView("loginpage","msg","Plz Re-Enter Credential :(");
		}
	}
	
	

}
