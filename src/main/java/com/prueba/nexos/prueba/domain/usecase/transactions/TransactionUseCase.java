package com.prueba.nexos.prueba.domain.usecase.transactions;

import com.prueba.nexos.prueba.domain.domain.transaction.request.Transaction;
import com.prueba.nexos.prueba.domain.domain.transaction.response.TransactionResponse;
import com.prueba.nexos.prueba.domain.model.request.Card;
import com.prueba.nexos.prueba.domain.model.response.CardResponse;
import com.prueba.nexos.prueba.infrastructure.point.models.request.TransactionPurchaseRequest;
import com.prueba.nexos.prueba.infrastructure.point.models.request.TransactionRequest;

import java.util.Optional;

public interface TransactionUseCase {

    Transaction consultarTransacion(Long transacionId);

    Optional<TransactionResponse> anularTransacion(TransactionRequest transactionRequest);

    Optional<TransactionResponse> transacionCompra(TransactionPurchaseRequest transaction);

}
