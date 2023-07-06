package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getproductbyid(int pid) {
		return productDao.findbyid(pid);
	}

	@Override
	public int addnewProduct(Product p) {
		return productDao.save(p);
	}

	@Override
	public int updateProduct(Product p) {
		
		return productDao.updateProduct(p);
	}

	@Override
	public int deleteById(int pid) {
		return productDao.delete(pid);
	}

}
