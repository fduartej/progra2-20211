package edu.usmp.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import edu.usmp.demomvc.model.Customer;
import edu.usmp.demomvc.repository.CustomerRepository;
import edu.usmp.demomvc.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class CustomerController {
    
       
    private static final String INDEX ="customer/create"; 
    private static String MODEL_CONTACT="client";
    private final CustomerRepository clientsData;
    private final UserRepository usuariosData;

    public CustomerController(CustomerRepository clientsData,
    UserRepository usuariosData    
        ){
        this.clientsData = clientsData;
        this.usuariosData = usuariosData;
    }      

    @GetMapping("/customer/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Customer());
        return INDEX;
    }    

    @PostMapping("/customer/create")
    public String createSubmitForm(Model model, 
        @Valid Customer objCliente, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un cliente");
        }else{
            this.usuariosData.save(objCliente.getUser());
            this.usuariosData.flush();
            this.clientsData.save(objCliente);
            model.addAttribute(MODEL_CONTACT, objCliente);
            model.addAttribute("mensaje", "Se registro un cliente");
        }
        return INDEX;
    }
}
