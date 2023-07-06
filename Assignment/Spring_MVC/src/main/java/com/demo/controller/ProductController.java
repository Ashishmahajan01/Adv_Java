package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/viewproduct")
	public ModelAndView diplayProduct() {
		List<Product> plist = productService.getAllProduct();
		return new ModelAndView("displayproduct", "plist", plist);
	}

	@GetMapping("/addnewproduct")
	public String displayaddform() {
		return "addproduct";
	}

	@PostMapping("/addproduct")
	public ModelAndView addProduct(@RequestParam int pid, @RequestParam String pname, @RequestParam int qty,
			@RequestParam float price) {
		Product p = new Product(pid, pname, qty, price);
		productService.addNewProduct(p);
		return new ModelAndView("redirect:/product/viewProduct");

	}
}
