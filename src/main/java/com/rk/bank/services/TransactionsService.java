package com.rk.bank.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

@Service
public class TransactionsService {

    private final JdbcTemplate jdbc;

    public TransactionsService(JdbcTemplate jdbcTemplate){
        this.jdbc = jdbcTemplate;
    }

    private void transferFunds(int recipientID, Double amount){
        String query = "UPDATE users SET balance = balance + ? WHERE id = ?";

        jdbc.execute(query, (PreparedStatementCallback<Void>) ps->{

            ps.setDouble(1,amount);
            ps.setInt(2,recipientID);

            if(ps.executeUpdate() < 1 )
                throw new RuntimeException("Could not transfer funds");

            return null;
        });
    }

    private void updateTransactionHistory(int recipientID, Double amount){
        String query = "INSERT INTO transactions_history (id,user_id,transaction_amount) VALUES (?,?,?)";

        jdbc.execute(query, (PreparedStatementCallback<Void>) ps->{

            ps.setString(1, UUID.randomUUID().toString());
            ps.setInt(2,recipientID);
            ps.setDouble(3,amount);

            if(ps.executeUpdate() < 1 )
                throw new RuntimeException("Could not update transaction history");

            return null;
        });
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void transferFundsTrx(int recipientID, Double amount){
        transferFunds(recipientID,amount);
        updateTransactionHistory(recipientID, amount);
    }

    public ArrayList<HashMap<String,String>> getTransactionsHistory(){
        String query = "SELECT th.*, u.name as client_name,u.email as client_email,u.balance as total_balance FROM transactions_history th JOIN users u ON th.user_id = u.id";

        ArrayList<HashMap<String, String>> transactionsList = new ArrayList<>();

        jdbc.execute(query, (PreparedStatementCallback<Void>) ps->{

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                LinkedHashMap<String,String> transactionData = new LinkedHashMap<>();

                transactionData.put("recordCount", String.valueOf(transactionsList.size() + 1));
                transactionData.put("clientName", rs.getString("client_name"));
                transactionData.put("clientEmail", rs.getString("client_email"));
                transactionData.put("transactionAmount", rs.getString("transaction_amount"));
                transactionData.put("totalBalance", rs.getString("total_balance"));
                transactionData.put("transactionDateTime", rs.getString("created_at"));

                transactionsList.add(transactionData);
            }
            return null;
        });

        return transactionsList;
    }
}
