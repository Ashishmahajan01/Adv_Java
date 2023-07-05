package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		List<Product> plist= productDao.findAll();
		System.out.println(plist);
		return plist;
		
	}
}
