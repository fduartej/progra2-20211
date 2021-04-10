package edu.usmp.demomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demomvc.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    
}