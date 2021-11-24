package com.services.api.v1.interf.retro;
import com.services.api.v1.models.UserRequest;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface UserAPI {
    @POST("api/user")
    Call<UserRequest> updateUserById(@Body UserRequest userRequest) throws IOException;
    @GET("api/v1/employees")
    Call<UserRequest> getUserById() throws IOException;
}
