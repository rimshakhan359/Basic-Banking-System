package com.rk.bank.controllers;

import com.rk.bank.response.RestResponse;
import com.rk.bank.services.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/bank")
public class Transactions {

    private final TransactionsService transactionsService;
    public Transactions(TransactionsService transactionsService){
        this.transactionsService = transactionsService;
    }


    @PutMapping("/transfer-amount")
    public ResponseEntity<Object> transferAmount(@RequestBody HashMap<String,String> request){

       String message = "Amount transfered successfully";
       HttpStatusCode httpStatusCode = HttpStatus.OK;

       if(null == request.get("recipientID") || request.get("recipientID").isEmpty()){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("Valid Recipient ID Required");
       }

        if(null == request.get("amount") || request.get("amount").isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Valid Amount Required");
        }

       int recipientID = Integer.parseInt(request.get("recipientID"));
       BigDecimal amount = new BigDecimal(request.get("amount"));
       amount = amount.setScale(2, RoundingMode.HALF_EVEN);

       try{
           transactionsService.transferFundsTrx(recipientID, amount.doubleValue());
       }catch (Exception e){
           e.printStackTrace();

           message = e.getMessage();
           httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
       }

        return ResponseEntity.status(httpStatusCode).body(new RestResponse(message));
    }

    @GetMapping("/transactions-list")
    public ResponseEntity<Object> getTransactionsHistory(){

        String message = "Transactions Data Returned successfully";
        HttpStatusCode httpStatusCode = HttpStatus.OK;

        ArrayList<HashMap<String,String>> transactionsList = null;
        try{
            transactionsList = transactionsService.getTransactionsHistory();
        }catch (Exception e){
            e.printStackTrace();

            message = e.getMessage();
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatusCode).body(new RestResponse(message,transactionsList));
    }

}
