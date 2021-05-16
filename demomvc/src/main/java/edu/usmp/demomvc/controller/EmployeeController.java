package edu.usmp.demomvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import edu.usmp.demomvc.dto.Employee;
import edu.usmp.demomvc.service.GDHService;

@Controller

public class EmployeeController {
    
    private final GDHService gdhService;
    private static final String EMPLOYEE_INDEX = "employee/index";


    public EmployeeController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @GetMapping(EMPLOYEE_INDEX)
    public String index(Model model) {
        List<Employee> employess = gdhService.queryEmployeeExternal();
        model.addAttribute("employees", employess);
        return EMPLOYEE_INDEX;
    }

}
