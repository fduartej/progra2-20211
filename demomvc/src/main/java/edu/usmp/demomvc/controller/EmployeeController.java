package edu.usmp.demomvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import edu.usmp.demomvc.dto.Employee;
import edu.usmp.demomvc.service.GDHService;

import org.springframework.validation.BindingResult;

@Controller

public class EmployeeController {
    
    private final GDHService gdhService;
    private static final String EMPLOYEE_INDEX = "employee/index";
    private static final String EMPLOYEE_CREATE ="employee/create"; 
    private static String MODEL_EMPLOYEE="employee";


    public EmployeeController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @GetMapping(EMPLOYEE_INDEX)
    public String index(Model model) {
        List<Employee> employess = gdhService.getValidEmployees();
        model.addAttribute("employees", employess);
        return EMPLOYEE_INDEX;
    }

    @GetMapping(EMPLOYEE_CREATE)
    public String create(Model model) {
        model.addAttribute(MODEL_EMPLOYEE, new Employee());
        return EMPLOYEE_CREATE;
    }    

    @PostMapping(EMPLOYEE_CREATE)
    public String createSubmitForm(Model model, 
        Employee objEmp, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro empleado");
        }else{
            gdhService.addValidEmployee(objEmp);
            model.addAttribute(MODEL_EMPLOYEE, objEmp);
            model.addAttribute("mensaje", "Se registro empleado");
        }
        return EMPLOYEE_CREATE;
    }

}
