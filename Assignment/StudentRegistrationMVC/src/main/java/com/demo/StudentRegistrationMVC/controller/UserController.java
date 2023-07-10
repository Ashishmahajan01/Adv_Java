package com.demo.StudentRegistrationMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.StudentRegistrationMVC.beans.User;
import com.demo.StudentRegistrationMVC.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("in constructor");
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		System.out.println("Hello");
		return "index";	
	}
	
	@GetMapping("/showuser")
	public ModelAndView displayuser() {
		List<User> ulist= userService.displayuser();
		return new ModelAndView("displayuser","ulist",ulist);
		 	
	}
	@GetMapping("/adduser")
	public String addnewuser(Model model) {
		User u=new User();
		model.addAttribute("registeruser",u);
		return "adduser";	 	
	}
	
	@PostMapping("/insertuser")
	public ModelAndView insertuser(@Validated @ModelAttribute("registeruser") User u,BindingResult result) {
		System.out.println("result :"+result);
		if(result.hasErrors()) {
			return new ModelAndView("adduser","",null);
		}
		  userService.addUser(u);
		  return new ModelAndView("redirect:/showuser");
	}
	
	
	
	@PostMapping("/updateuser/{id}")
	public ModelAndView updateProduct(@Validated @ModelAttribute User u,BindingResult br) {
		if(br.hasErrors())
			return new ModelAndView("registeruser","",null);
		userService.updateUser(u);
		return new ModelAndView("redirect:/showuser");
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		userService.deleteById(id);
		
		return new ModelAndView("redirect:/showuser");
		
	}
}
