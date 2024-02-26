package com.prueba.nexos.prueba.domain.domain.transaction.gateways;

import com.prueba.nexos.prueba.domain.domain.transaction.request.Transaction;
import com.prueba.nexos.prueba.domain.domain.transaction.response.TransactionResponse;

import java.util.Optional;

public interface TransationRepository {

    Transaction transactionCompra(Transaction transaction);

    Transaction consultTransaction(Long transactioId);

    Optional<Transaction> anularTransaction(Transaction transaction);
}
