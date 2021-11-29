package com.services.api.v1.models;

public class UserRequest {
    public UserRequest(){
        super();
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String status;
    private Object data;
}
