package com.services.api.v1.impl;

import com.services.api.v1.interf.UserServiceApiInter;
import com.services.api.v1.interf.retro.UserAPI;
import com.services.api.v1.models.UserRequest;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserServiceApiImpl implements UserServiceApiInter {
    private Retrofit retrofit;
    private UserAPI userAPI;
    private String baseUrl;

    public UserServiceApiImpl(String url){
        this.baseUrl = url;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.userAPI = retrofit.create(UserAPI.class);
    }

    @Override
    public UserRequest getUserAllUsers() throws IOException {

        return  this.userAPI.getUserById().execute().body();
    }

    @Override
    public UserRequest updateUserById(UserRequest userRequest) throws IOException {
        return this.userAPI.updateUserById(userRequest).execute().body();
    }
}
