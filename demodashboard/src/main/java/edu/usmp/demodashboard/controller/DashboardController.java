package edu.usmp.demodashboard.controller;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import edu.usmp.demodashboard.model.Payment;
import edu.usmp.demodashboard.repository.PaymentRepository;

@Controller
public class DashboardController {
    private static final String VIEW_INDEX ="dashboard/payments"; 

    @GetMapping("/dashboard/payments")
    public String index(Model model) {
        return VIEW_INDEX;
    }
}