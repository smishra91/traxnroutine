package com.transactionroutine.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactionroutine.app.dto.NewAccountRequest;
import com.transactionroutine.app.model.Account;
import com.transactionroutine.app.service.AccountService;
import com.transactionroutine.app.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private AccountService accountService;

    private MockMvc mockMvc;

    private Account account;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        account = TestUtil.generateRandomObject(Account.class);
    }

    @Test
    void testCreateAccount() throws Exception {
        NewAccountRequest newAccountRequest = TestUtil.generateRandomObject(NewAccountRequest.class);
        newAccountRequest.setDocumentNumber("123456789");

        when(accountService.createAccount(newAccountRequest.getDocumentNumber())).thenReturn(account);

        mockMvc.perform(post("/accounts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newAccountRequest)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(account)));
    }

    @Test
    void testGetAccount() throws Exception {
        when(accountService.getAccountById(1L)).thenReturn(account);

        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(account)));
    }
}
