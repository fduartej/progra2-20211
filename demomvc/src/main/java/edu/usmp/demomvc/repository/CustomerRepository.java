package edu.usmp.demomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demomvc.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
