package edu.usmp.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import edu.usmp.demomvc.model.User;
import edu.usmp.demomvc.repository.UserRepository;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {

    private final UserRepository userData;
    private static final String MESSAGE_ATTRIBUTE = "message"; 
    private static final String USER_INDEX ="user/login";
    private static final String HOME_INDEX ="welcome"; 

    public UserController(UserRepository userData) {
        this.userData = userData;
    }

    @GetMapping("/user/login")
    public String index(Model model) {
        User usuario = new User();
        model.addAttribute("user", usuario);
        return USER_INDEX;
    }

    @PostMapping("/user/login")
    public String login(Model model,
        @Valid User objUser, BindingResult result 
        ){
        String page;
        if(result.hasFieldErrors()) {
            model.addAttribute(MESSAGE_ATTRIBUTE, "Ingrese la informacion mandatoria");
            page = USER_INDEX;
        }else{
           Optional<User> userDB = this.userData.findById(objUser.getUsername());
           if(userDB.isPresent()){
                if(objUser.getPassword().equals(userDB.get().getPassword())){
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Ingreso Satisfactorio");
                    page = HOME_INDEX;
                }else{
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Password no coincide");
                    page = USER_INDEX;
                }
           }else{
                model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario no existe");
                page = USER_INDEX;
           }
        }
        return page;

    }
}
