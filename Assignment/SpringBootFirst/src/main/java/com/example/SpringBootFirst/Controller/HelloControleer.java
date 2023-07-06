package com.example.SpringBootFirst.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControleer {
	@GetMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello","msg","Welcome to spring boot mvc");
		
	}
}
