package com.example.SpringBootFirst.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBootFirst.beans.Product;
import com.example.SpringBootFirst.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/displayproduct")
	public ModelAndView displayproduct() {
		List<Product> plist = productService.displayproduct();
		return new ModelAndView("displayproduct","plist",plist);
		
	}
	
}
