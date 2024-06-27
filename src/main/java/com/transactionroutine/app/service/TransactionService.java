package com.transactionroutine.app.service;

import com.transactionroutine.app.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface TransactionService {

    Transaction createTransaction(Long accountId, Long operationTypeId, BigDecimal amount);
}
