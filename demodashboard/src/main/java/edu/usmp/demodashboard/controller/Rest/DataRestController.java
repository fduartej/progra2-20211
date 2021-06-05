package edu.usmp.demodashboard.controller.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;
import edu.usmp.demodashboard.repository.*;

@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DataRestController {
    private final PaymentRepository paymentData;

    public DataRestController(PaymentRepository paymentData){
        this.paymentData = paymentData;
    } 

    @GetMapping(value = "/tarjetas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> employees(){
        return  new ResponseEntity<List<Map<String, Object>>>(
            paymentData.queryByTipoTarjeta(), HttpStatus.OK);
    }
}
