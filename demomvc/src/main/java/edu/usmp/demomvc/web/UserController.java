package edu.usmp.demomvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import edu.usmp.demomvc.domain.User;
import edu.usmp.demomvc.repository.UserRepository;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {

    private final UserRepository userData;
    private static final String MESSAGE_ATTRIBUTE = "message"; 

    public UserController(UserRepository userData) {
        this.userData = userData;
    }

    @GetMapping("/")
    public String index(Model model) {
        User usuario = new User();
        model.addAttribute("user", usuario);
        return "user/index";
    }

    @PostMapping("/user/login")
    public String login(Model model,
        @Valid User objUser, BindingResult result 
        ){
        String page;
        if(result.hasFieldErrors()) {
            model.addAttribute(MESSAGE_ATTRIBUTE, "Ingrese la informacion mandatoria");
            page = "user/index";
        }else{
           Optional<User> userDB = this.userData.findById(objUser.getUsername());
           if(userDB.isPresent()){
                if(objUser.getPassword().equals(userDB.get().getPassword())){
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Ingreso Satisfactorio");
                }else{
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Password no coincide");
                }
           }else{
                model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario no existe");
           }
           page = "home/index";
        }
        return page;

    }
}
