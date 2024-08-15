package com.rk.bank.services;

import com.rk.bank.controllers.Clients;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class ClientService {

    private JdbcTemplate jdbc;

    public ClientService(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public ArrayList<LinkedHashMap<String,String>> getAllClients(){
        String query = "SELECT * FROM users";

        ArrayList<LinkedHashMap<String,String>> clientsList = new ArrayList<>();

        jdbc.execute(query, (PreparedStatementCallback<Void>) ps->{

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                LinkedHashMap<String,String> client = new LinkedHashMap<>();

                client.put("id", rs.getString("id"));
                client.put("name", rs.getString("name"));
                client.put("email", rs.getString("email"));
                client.put("phone", rs.getString("phone"));
                client.put("balance", rs.getString("balance"));

                clientsList.add(client);
            }

            return null;
        });

        return clientsList;
    }
}
