package edu.usmp.demomvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import edu.usmp.demomvc.repository.ContactRepository;

import edu.usmp.demomvc.domain.Contact;

@Controller
public class ContactController {
    
    private final ContactRepository contactData;
    private static final String MESSAGE_ATTRIBUTE = "message"; 
    private static final String CONTACT_INDEX ="user/index";
    private static final String HOME_INDEX ="home/index"; 

    public ContactController(ContactRepository contactData) {
        this.contactData = contactData;
    }

    @GetMapping("/contact/index")
    public String index(Model model) {
        return CONTACT_INDEX;
    }
}
