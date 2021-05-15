package edu.usmp.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import edu.usmp.demomvc.model.Contact;
import edu.usmp.demomvc.repository.ContactRepository;

@Controller
public class ContactController {

    private final ContactRepository contactData;
    private static final String CONTACT_CREATE = "contact/create";

    public ContactController(ContactRepository contactData) {
        this.contactData = contactData;
    }

    @GetMapping("/contact/create")
    public String index(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return CONTACT_CREATE;
    }

    @PostMapping("/contact/create")
    public String submitCreationForm(Model model,
        @Valid Contact objContact, BindingResult result) {
        if (!result.hasErrors()) {
            this.contactData.save(objContact);
            model.addAttribute("contact", objContact);
            model.addAttribute("message", "Se registro satisfactoriamente");
        }else{
            model.addAttribute("message", "Por favor envie los datos correctos");
        }
        return CONTACT_CREATE;
    }

}
