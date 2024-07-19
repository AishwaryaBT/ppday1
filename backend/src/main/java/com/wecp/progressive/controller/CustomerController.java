package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;
import com.wecp.progressive.service.CustomerServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired 
    private  CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException {
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
      
    }

@GetMapping("/{customerID}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerID) throws SQLException {
        return new ResponseEntity<>(customerService.getCustomerById(customerID),HttpStatus.OK);
       
    }
@PostMapping
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) throws SQLException {
        return new ResponseEntity<>(customerService.addCustomer(customers),HttpStatus.CREATED);
        
       
    }
@PutMapping("/{customerId}")
    public ResponseEntity<Integer> updateCustomer(@PathVariable int customerId, @RequestBody Customers customers) {
        customers.setCustomerId(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
       
       
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) throws SQLException {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      
    }

    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
        return null;
    }
}
