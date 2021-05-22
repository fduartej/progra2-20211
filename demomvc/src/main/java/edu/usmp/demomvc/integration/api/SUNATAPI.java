package edu.usmp.demomvc.integration.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.usmp.demomvc.dto.Factura;

import org.springframework.stereotype.Service;

@Service
public class SUNATAPI {
    
    @Value("${appexternal.endpoint.get.employees}")
    private String URL_POST_SEND_FACTURA;

    private RestTemplate restTemplate;

    public SUNATAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void sendFactura(Factura f){
        HttpEntity<Factura> bodyRequest = new  HttpEntity<Factura>(f);
        ResponseEntity<String> response = 
            restTemplate.exchange(URL_POST_SEND_FACTURA,
                    HttpMethod.POST,
                    bodyRequest,
                    new ParameterizedTypeReference<String>(){}
            );
    }
}
