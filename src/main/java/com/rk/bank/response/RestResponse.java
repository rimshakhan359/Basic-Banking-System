package com.rk.bank.response;

import lombok.Data;

@Data
public class RestResponse {

    private String message;
    private Object data;

    public RestResponse(String message, Object responseBody){
        this.message = message;
        this.data = responseBody;
    }

    public RestResponse(String message){
        this.message = message;
    }
}
