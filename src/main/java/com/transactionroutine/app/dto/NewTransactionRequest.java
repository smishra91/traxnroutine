package com.transactionroutine.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewTransactionRequest {
    private Long accountId;
    private Long operationTypeId;
    private BigDecimal amount;
}
