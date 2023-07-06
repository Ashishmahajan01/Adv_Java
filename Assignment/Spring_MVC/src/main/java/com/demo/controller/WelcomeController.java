package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String displayWelcome() {
		System.out.println("In display Login");
		return "loginpage";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView syawlcome() {
		String message="this is message from say hello";
		//message data can be accessed in hello.jsp page by name msg
		return new ModelAndView("hello","msg",message);
		
	}
	
}
