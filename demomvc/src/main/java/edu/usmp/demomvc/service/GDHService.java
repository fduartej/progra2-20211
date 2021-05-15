package edu.usmp.demomvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import edu.usmp.demomvc.dto.Employee;

@Service
public class GDHService {

    @Value("${appexternal.url}")
    private String urlApp;

    @Value("${appexternal.endpoint}")
    private String urlEndPoint;
    
    private RestTemplate restTemplate;

    public GDHService(RestTemplate _restTemplate){
        restTemplate = _restTemplate;
    }
    
    public List<Employee> queryEmployeeExternal(){


        return null;
    }

}
