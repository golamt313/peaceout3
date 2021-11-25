package com.services.api.v1.impl;

import com.services.api.v1.RetroCallBack;
import com.services.api.v1.interf.retro.UserAPI;
import com.services.api.v1.models.UserRequest;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPIImpl implements UserAPI {
    private Retrofit retrofit;
    private UserAPI userAPI;
    private String baseUrl;
    private Response<UserRequest> userResponse;

    public Response<UserRequest> getUserResponse() {

        return userResponse;
    }

    public UserAPIImpl(String url){
        this.baseUrl = url;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         this.userAPI = retrofit.create(UserAPI.class);
    }
    @Override
    public Call<UserRequest> updateUserById(UserRequest userRequest) throws IOException {
        Call<UserRequest> call = this.userAPI.getUserById();
        //RetroCallBack<UserRequest> request = this.requestUpdateUser();
        this.userResponse = call.execute();
       // call.enqueue(request);
        return call;
    }

    @Override
    public Call<UserRequest> getUserById() throws IOException {
        Call<UserRequest> call = null;
            call = this.userAPI.getUserById();
            this.userResponse = call.execute();
        //RetroCallBack<UserRequest> request = this.requestGetUserById();
        //call.enqueue(request);
        return call;
    }

    private RetroCallBack<UserRequest> requestUpdateUser (){
        return new RetroCallBack<UserRequest>() {
            @Override
            public void onResponse(Call call, Response response) {
                this.response = response;
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.isCanceled();
            }

        };
    }

    private RetroCallBack<UserRequest> requestGetUserById (){
        return new RetroCallBack<UserRequest>() {
            @Override
            public void onResponse(Call call, Response response) {
                this.response = response;
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        };
    }


}
