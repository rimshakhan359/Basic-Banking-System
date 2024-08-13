package com.rk.bank.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    private final JdbcTemplate jdbc;

    public TransactionsService(JdbcTemplate jdbcTemplate){
        this.jdbc = jdbcTemplate;
    }

    public void transferFunds(int recipientID, Double amount){
        String query = "UPDATE users SET balance = balance + ? WHERE id = ?";

        jdbc.execute(query, (PreparedStatementCallback<Void>) ps->{

            ps.setDouble(1,amount);
            ps.setInt(2,recipientID);

            if(ps.executeUpdate() < 1 )
                throw new RuntimeException("Could not transfer funds");

            return null;
        });
    }
}
