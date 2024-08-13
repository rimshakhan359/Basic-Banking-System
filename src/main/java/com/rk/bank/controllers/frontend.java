package com.rk.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class frontend {

    @GetMapping("/transactions")
    public String index(){
        return "transactions";
    }

    @GetMapping("/all-clients")
    public String bankClients(){
        return "otherUser";
    }

    @GetMapping("/transaction-history")
    public String transactionHistory(){
        return "transferHistory";
    }

    @GetMapping("/transfer-funds")
    public String transferFunds(){
        return "transferMoney";
    }

    @GetMapping("/dashboard")
    public String home(){
        return "home";
    }
}
