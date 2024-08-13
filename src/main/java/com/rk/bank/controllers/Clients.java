package com.rk.bank.controllers;

import com.rk.bank.response.RestResponse;
import com.rk.bank.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/bank")
public class Clients {

    private ClientService clientService;
    public Clients(ClientService clientService){
        this.clientService  = clientService;
    }

    @GetMapping("/clients")
    public ResponseEntity<Object> getBankClients(){
        String message = "Clients returned successfully";
        HttpStatusCode httpStatusCode = HttpStatus.OK;

        ArrayList<LinkedHashMap<String,String>> clients = null;

        try{
            clients = clientService.getAllClients();
        }catch (Exception e){
            e.printStackTrace();

            message = "Could not process request";
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity
                .status(httpStatusCode)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new RestResponse(message,clients));
    }
}
