package com.transactionroutine.app.controller;

import com.transactionroutine.app.dto.NewAccountRequest;
import com.transactionroutine.app.model.Account;
import com.transactionroutine.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody NewAccountRequest newAccountRequest) {

        Account account = accountService.createAccount(newAccountRequest.getDocumentNumber());
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {

        Account account = accountService.getAccountById(accountId);

        return ResponseEntity.ok(account);
    }
}
