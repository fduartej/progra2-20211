package edu.usmp.demomvc.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;
import edu.usmp.demomvc.domain.*;
import edu.usmp.demomvc.repository.*;

@RestController
public class EmployeeController{
    
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> employees(){
        return  new ResponseEntity<List<Employee>>(
            employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Employee e){
        employeeRepository.save(e);
        employeeRepository.flush();
        return new ResponseEntity<Integer>(e.getId(),HttpStatus.CREATED);
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> employees(@PathVariable int id){
        Optional<Employee> optinalEntity = employeeRepository.findById(id);
        if(optinalEntity.isPresent())
            return new ResponseEntity<Employee>(
                optinalEntity.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable int id){
        employeeRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> update(@RequestBody Employee e){
        create(e);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
}