package com.transactionroutine.app.repository;

import com.transactionroutine.app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByDocumentNumber(String documentNumber);

}
