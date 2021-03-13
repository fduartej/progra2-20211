package edu.usmp.demomvc.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import edu.usmp.demomvc.domain.*;

@RestController
public class HelloController{

    @RequestMapping("/")
    public String index(){
        return "Saludos desde spring boot";
    }

    @RequestMapping("/employees")
    public List<Employee> employees(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Orestes","La Cunsa"));
        return employees;
    }

}