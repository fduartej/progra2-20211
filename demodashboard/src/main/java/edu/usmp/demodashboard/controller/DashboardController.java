package edu.usmp.demodashboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class DashboardController {
    private static final String PAYMENT_INDEX ="dashboard/payments"; 

    @GetMapping("/dashboard/payments")
    public String index(Model model) {
        return PAYMENT_INDEX;
    }
}