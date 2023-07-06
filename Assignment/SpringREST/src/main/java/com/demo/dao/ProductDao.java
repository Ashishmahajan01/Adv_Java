package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAll();

	Product findbyid(int pid);

	int save(Product p);

	int updateProduct(Product p);

	int delete(int pid);

}
