package edu.usmp.demomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demomvc.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
