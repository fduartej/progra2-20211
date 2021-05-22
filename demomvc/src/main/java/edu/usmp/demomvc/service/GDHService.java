package edu.usmp.demomvc.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import edu.usmp.demomvc.dto.Employee;
import edu.usmp.demomvc.integration.api.GDHAPI;

@Service
public class GDHService {

    private GDHAPI gdhAPI;

    public GDHService(GDHAPI gdhAPI){
        this.gdhAPI = gdhAPI;
    }
    
    public List<Employee> getValidEmployees(){
        List<Employee> employeesValid = gdhAPI.getEmployees().stream().
        filter(e -> e.getStatus().equals("A")).
        collect(Collectors.toList());
        return employeesValid;
    }

}
