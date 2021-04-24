package edu.usmp.demomvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
    private static final String MESSAGE_ATTRIBUTE = "message"; 
    private static final String HOME_INDEX ="welcome"; 

    @GetMapping("/")
    public String index(Model model) {
        return HOME_INDEX;
    }
}
