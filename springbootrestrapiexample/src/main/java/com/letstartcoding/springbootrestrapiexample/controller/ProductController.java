package com.letstartcoding.springbootrestrapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letstartcoding.springbootrestrapiexample.dao.ProductDAO;
import com.letstartcoding.springbootrestrapiexample.model.Products;

@RestController
@RequestMapping("/company/")
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	/*to save a product*/
	@PostMapping("/products/")
	public Products createProducts(@Valid @RequestBody Products prdct) {
		return productDAO.save(prdct);
		
	}
	
	/*get all products*/
	@GetMapping("/products/")
	public List<Products>getAllProducts(){
		return productDAO.findAll();
	}
	
	/*get products by prdctid*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Products> getProductByID(@PathVariable(value="id") Long prdctid){
		
		Products prdct=productDAO.findOne(prdctid);
		
		if(prdct==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(prdct);
		
	} 
	
	/*update a product by prdctid*/
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable(value="id") Long prdctid,@Valid @RequestBody Products prdctDetails){
		
		Products prdct=productDAO.findOne(prdctid);
		if(prdct==null) {
			
			return ResponseEntity.notFound().build();
			
		}
		prdct.setPprice(prdctDetails.getPprice());
		prdct.setPquantity(prdctDetails.getPquantity());
		
		Products updateProduct=productDAO.save(prdct);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	/*Delete a product */
	
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Products> deleteProduct(@PathVariable(value="id") Long prdctid){
		Products prdct=productDAO.findOne(prdctid);
		
			if(prdct==null) {
			
			return ResponseEntity.notFound().build();
			
		}
			productDAO.delete(prdct);
			return ResponseEntity.ok().build();

}
	
}
