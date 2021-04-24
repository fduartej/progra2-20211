package edu.usmp.demomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demomvc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
