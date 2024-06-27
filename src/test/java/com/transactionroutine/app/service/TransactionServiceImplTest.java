package com.transactionroutine.app.service;

import com.transactionroutine.app.exception.NotFoundException;
import com.transactionroutine.app.model.Account;
import com.transactionroutine.app.model.OperationType;
import com.transactionroutine.app.model.Transaction;
import com.transactionroutine.app.repository.AccountRepository;
import com.transactionroutine.app.repository.OperationTypeRepository;
import com.transactionroutine.app.repository.TransactionRepository;
import com.transactionroutine.app.service.impl.TransactionServiceImpl;
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

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private OperationTypeRepository operationTypeRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    void testCreateTransaction() {
        Account account = TestUtil.generateRandomObject(Account.class);
        OperationType operationType = TestUtil.generateRandomObject(OperationType.class);
        Transaction transaction = TestUtil.generateRandomObject(Transaction.class);
        transaction.setAccount(account);
        transaction.setOperationType(operationType);
        when(accountRepository.findById(anyLong())).thenReturn(Optional.of(account));
        when(operationTypeRepository.findById(anyLong())).thenReturn(Optional.of(operationType));
        when(transactionRepository.save(any(Transaction.class))).thenAnswer(i -> {
            Transaction savedTransaction = i.getArgument(0);
            savedTransaction.setId(transaction.getId());
            return savedTransaction;
        });

        Transaction createdTransaction = transactionService.createTransaction(account.getId(), operationType.getId(), BigDecimal.valueOf(100.0));

        assertEquals(transaction.getId(), createdTransaction.getId());
        assertEquals(transaction.getAccount().getId(), createdTransaction.getAccount().getId());
        assertEquals(transaction.getOperationType().getId(), createdTransaction.getOperationType().getId());
        assertEquals(transaction.getAmount(), createdTransaction.getAmount());
    }*/

    @Test
    void testCreateTransactionAccountNotFound() {
        assertThrows(NotFoundException.class, () -> transactionService.createTransaction(1L, 1L, BigDecimal.valueOf(100.0)));
    }

    @Test
    void testCreateTransactionOperationTypeNotFound() {
        assertThrows(NotFoundException.class, () -> transactionService.createTransaction(1L, 1L, BigDecimal.valueOf(100.0)));
    }
}
