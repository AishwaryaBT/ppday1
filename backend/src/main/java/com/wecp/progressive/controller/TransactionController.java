package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.repository.TransactionRepository;
import com.wecp.progressive.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/transactions")


public class TransactionController {
    @Autowired
    private TransactionService transactionService;
@GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() throws SQLException {
        return new ResponseEntity<>(transactionService.getAllTransactions(),HttpStatus.OK);
        
    }
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transactions> getTransactionById(int transactionId) throws SQLException {
        return new ResponseEntity<>(transactionService.getTransactionById(transactionId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Integer> addTransaction(Transactions transaction) throws SQLException {
        return new ResponseEntity<>(transactionService.addTransaction(transaction),HttpStatus.OK);
       
    }
    @PutMapping("/{transactionId}")
    public ResponseEntity<Void> updateTransaction(int transactionId, Transactions transaction) {
        transaction.setTransactionId(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);

       
    }
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(int transactionId) throws SQLException {
    transactionService.deleteTransaction(transactionId);
    return new ResponseEntity<>(HttpStatus.OK);
      
    }
}
