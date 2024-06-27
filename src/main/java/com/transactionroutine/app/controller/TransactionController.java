package com.transactionroutine.app.controller;

import com.transactionroutine.app.dto.NewTransactionRequest;
import com.transactionroutine.app.model.Transaction;
import com.transactionroutine.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody NewTransactionRequest newTransactionRequest) {

        Transaction transaction = transactionService.createTransaction(newTransactionRequest.getAccountId(),
                newTransactionRequest.getOperationTypeId(),
                newTransactionRequest.getAmount());

        return ResponseEntity.ok(transaction);
    }
}
