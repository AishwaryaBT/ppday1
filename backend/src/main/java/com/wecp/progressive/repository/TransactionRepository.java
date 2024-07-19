package com.wecp.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer>  {
    @Query("Select t from Transactions t where t.customerId=:customerId")
    public List<Transactions> getTransactionsByCustomerId(Integer customerId);
    
}
