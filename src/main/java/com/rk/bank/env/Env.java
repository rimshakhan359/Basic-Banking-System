package com.rk.bank.env;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Env {

    @Value("${base.url}")
    private String baseUrl;

    @Value("${server.port}")
    private String serverPort;

    @Value("${api.prefix}")
    private String apiPrefix;

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public String getServerPort(){
        return this.serverPort;
    }

    public String getApiPrefix(){
        return this.apiPrefix;
    }
}
