package com.transactionroutine.app.service.impl;

import com.transactionroutine.app.exception.NotFoundException;
import com.transactionroutine.app.model.Account;
import com.transactionroutine.app.model.OperationType;
import com.transactionroutine.app.model.Transaction;
import com.transactionroutine.app.repository.AccountRepository;
import com.transactionroutine.app.repository.OperationTypeRepository;
import com.transactionroutine.app.repository.TransactionRepository;
import com.transactionroutine.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final OperationTypeRepository operationTypeRepository;

    @Autowired
    public TransactionServiceImpl(AccountRepository accountRepository,
                                  TransactionRepository transactionRepository,
                                  OperationTypeRepository operationTypeRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.operationTypeRepository = operationTypeRepository;
    }

    @Override
    public Transaction createTransaction(Long accountId, Long operationTypeId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Account not found with id: " + accountId));

        OperationType operationType = operationTypeRepository.findById(operationTypeId)
                .orElseThrow(() -> new NotFoundException("Operation type not found with id: " + operationTypeId));

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setOperationType(operationType);
        transaction.setAmount(amount);
        transaction.setEventDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
