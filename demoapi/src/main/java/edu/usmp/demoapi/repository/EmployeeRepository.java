package edu.usmp.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.demoapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    
}