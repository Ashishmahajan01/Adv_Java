package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	 Product getproductbyid(int pid);

	int addnewProduct(Product p);

	int updateProduct(Product p);

	int deleteById(int pid);
	
	

}
