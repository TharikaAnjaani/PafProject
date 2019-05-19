package com.letstartcoding.springbootrestrapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letstartcoding.springbootrestrapiexample.model.Products;
import com.letstartcoding.springbootrestrapiexample.repository.ProductRepositary;

@Service

public class ProductDAO {
	
	
	@Autowired
	ProductRepositary productRepositary;

	/*to save a product*/
	
	public Products save (Products prdct) {
		return productRepositary.save(prdct);
	}
	
	/*search all product*/
	  public List<Products> findAll(){
		  return productRepositary.findAll();
	  }
	
	
	/*get a product*/
	  public Products findOne(Long prdctid) {
		  return productRepositary.findOne(prdctid);
	  }
	
	/*delete a product*/
	  public void delete(Products prdct) {
		  productRepositary.delete(prdct);
	  }
}
