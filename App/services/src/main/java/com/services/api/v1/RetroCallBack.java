package com.services.api.v1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetroCallBack<T> implements Callback<T> {
    public Response response ;
    @Override
    abstract public void onResponse(Call call, Response response);
    @Override
    abstract public void onFailure(Call call, Throwable t);
}
