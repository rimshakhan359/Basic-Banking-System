package com.rk.bank.controllers;

import com.rk.bank.env.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class frontend {
    @Autowired
    private Env env;

    @GetMapping("/transactions")
    public String index(Model model){
        model.addAttribute("baseUrl", env.getBaseUrl() + env.getServerPort() + env.getApiPrefix());
        return "transactions";
    }

    @GetMapping("/all-clients")
    public String bankClients(Model model){
        model.addAttribute("baseUrl", env.getBaseUrl() + env.getServerPort() + env.getApiPrefix());
        return "otherUser";
    }

    @GetMapping("/transaction-history")
    public String transactionHistory(Model model){
        model.addAttribute("baseUrl", env.getBaseUrl() + env.getServerPort() + env.getApiPrefix());
        return "transferHistory";
    }

    @GetMapping("/transfer-funds")
    public String transferFunds(Model model){
        model.addAttribute("baseUrl", env.getBaseUrl() + env.getServerPort() + env.getApiPrefix());
        return "transferMoney";
    }

    @GetMapping("/dashboard")
    public String home(Model model){
        model.addAttribute("baseUrl", env.getBaseUrl() + env.getServerPort() + env.getApiPrefix());
        return "home";
    }
}
