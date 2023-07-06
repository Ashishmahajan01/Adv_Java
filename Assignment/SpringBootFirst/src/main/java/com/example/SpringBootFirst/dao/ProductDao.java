package com.example.SpringBootFirst.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SpringBootFirst.beans.Product;



@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
