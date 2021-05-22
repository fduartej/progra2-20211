package edu.usmp.demomvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import edu.usmp.demomvc.dto.Employee;
import edu.usmp.demomvc.integration.api.GDHAPIRetrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class GDHRetrofitService {

    @Value("${appexternal.endpoint.get.employees}")
    private String URL_ENPOINT;

    @Value("${appexternal.url}")
    private String URL_EXTERNAL;

    private GDHAPIRetrofit gdhAPI;

    public GDHRetrofitService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app-spring-progrados.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gdhAPI = retrofit.create(GDHAPIRetrofit.class);
    }
    
    public List<Employee> queryEmployeeExternal(){
        Call<List<Employee>> retrofitCall = gdhAPI.getEmployees();
        Response<List<Employee>> response = null;
        try {
            response = retrofitCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

}
