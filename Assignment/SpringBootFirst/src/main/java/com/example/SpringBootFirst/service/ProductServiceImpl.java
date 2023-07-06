package com.example.SpringBootFirst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootFirst.beans.Product;
import com.example.SpringBootFirst.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> displayproduct() {
		return productDao.findAll();
	}

}
