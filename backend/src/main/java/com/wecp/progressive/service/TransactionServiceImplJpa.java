package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.repository.TransactionRepository;
@Service
public class TransactionServiceImplJpa implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transactions> getAllTransactions() throws SQLException{
        return transactionRepository.findAll();
    }
    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException{
        return transactionRepository.findById(transactionId).get();
    }
    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        transactionRepository.save(transaction);
        return transaction.getTransactionId();
    }
    @Override
    public void updateTransaction(Transactions transaction) throws SQLException{
        Transactions t = transactionRepository.findById(transaction.getTransactionId()).get();
        t.setAmount(transaction.getAmount());
        t.setTransactionDate(transaction.getTransactionDate());
        t.setTransactionType(transaction.getTransactionType());
        transactionRepository.save(t);

    }
    @Override
    public void deleteTransaction(int transactionId) throws SQLException{
        if(transactionRepository.findById(transactionId)!=null){
            transactionRepository.deleteById(transactionId);
        }

    }
    @Override
     public List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException{
        return transactionRepository.getTransactionsByCustomerId(customerId);

     }

  
    




}
