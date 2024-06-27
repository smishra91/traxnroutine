package com.transactionroutine.app.service;

import com.transactionroutine.app.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account createAccount(String documentNumber);

    Account getAccountById(Long id);
}
