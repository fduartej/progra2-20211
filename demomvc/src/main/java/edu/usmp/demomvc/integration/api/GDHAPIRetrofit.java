package edu.usmp.demomvc.integration.api;

import java.util.List;

import edu.usmp.demomvc.dto.Employee;
import retrofit2.Call;
import retrofit2.http.GET;


public interface GDHAPIRetrofit {

    @GET("api/employee/")
    Call<List<Employee>> getEmployees();
}
