package edu.usmp.demomvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import edu.usmp.demomvc.domain.User;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model){
        User usuario = new User();
        model.addAttribute("user", usuario);
        return "user/index";
    }
    
    @PostMapping("/user/login")
    public String login(Model model){
        User usuario = new User();
        String mensaje = "Ingreso Satisfactorio";
        model.addAttribute("user", usuario);
        model.addAttribute("message", mensaje);
        return "user/index";
    }
}
