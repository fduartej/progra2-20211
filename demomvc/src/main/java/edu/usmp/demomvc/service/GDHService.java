package edu.usmp.demomvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import edu.usmp.demomvc.dto.Employee;

@Service
public class GDHService {

    @Value("${appexternal.url}")
    private String URL_APP;

    @Value("${appexternal.endpoint}")
    private static String URL_ENPOINT;
    
    private RestTemplate restTemplate;

    public GDHService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
    public List<Employee> queryEmployeeExternal(){
        ResponseEntity<List<Employee>> response = restTemplate.
                                    exchange(URL_APP + URL_ENPOINT,HttpMethod.GET,
                                    HttpEntity.EMPTY,new ParameterizedTypeReference<List<Employee>>(){});
        return response.getBody();
    }

}
