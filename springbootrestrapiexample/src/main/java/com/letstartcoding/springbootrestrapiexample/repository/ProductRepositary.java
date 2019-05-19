package com.letstartcoding.springbootrestrapiexample.repository;

import com.letstartcoding.springbootrestrapiexample.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepositary extends JpaRepository<Products, Long> {

}
