package edu.usmp.demomvc.integration.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.usmp.demomvc.dto.Employee;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GDHAPI {
    
    @Value("${appexternal.endpoint.get.employees}")
    private String URL_GET_EMPLOYEES;

    @Value("${appexternal.endpoint.post.employees}")
    private String URL_POST_EMPLOYEES;

    private RestTemplate restTemplate;

    public GDHAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Employee> getEmployees(){
        ResponseEntity<List<Employee>> response = restTemplate.
                                    exchange(URL_GET_EMPLOYEES,
                                    HttpMethod.GET,
                                    HttpEntity.EMPTY,
                                    new ParameterizedTypeReference<List<Employee>>(){});
        return response.getBody();
    }

    public void postEmployees(Employee e){
        HttpEntity<Employee> bodyRequest = new  HttpEntity<Employee>(e);
        ResponseEntity<String> response = 
            restTemplate.exchange(URL_POST_EMPLOYEES,
                    HttpMethod.POST,
                    bodyRequest,
                    new ParameterizedTypeReference<String>(){}
            );
    }
}
