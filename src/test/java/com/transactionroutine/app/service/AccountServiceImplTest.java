package com.transactionroutine.app.service;

import com.transactionroutine.app.exception.NotFoundException;
import com.transactionroutine.app.model.Account;
import com.transactionroutine.app.repository.AccountRepository;
import com.transactionroutine.app.service.impl.AccountServiceImpl;
import com.transactionroutine.app.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   /* @Test
    void testCreateAccount() {
        Account account = TestUtil.generateRandomObject(Account.class);

        when(accountRepository.save(account)).thenReturn(account);

        Account createdAccount = accountService.createAccount(account.getDocumentNumber());

        assertEquals(account.getId(), createdAccount.getId());
        assertEquals(account.getDocumentNumber(), createdAccount.getDocumentNumber());
    }

    @Test
    void testGetAccountById() {
        Account account = TestUtil.generateRandomObject(Account.class);
        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));

        Account foundAccount = accountService.getAccountById(account.getId());

        assertEquals(account.getId(), foundAccount.getId());
        assertEquals(account.getDocumentNumber(), foundAccount.getDocumentNumber());
    }
*/
    @Test
    void testGetAccountByIdNotFound() {
        assertThrows(NotFoundException.class, () -> accountService.getAccountById(2L));
    }
}
