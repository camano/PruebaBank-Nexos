package com.prueba.nexos.prueba.infrastructure.point.controller;

import com.prueba.nexos.prueba.aplication.services.TransactionService;
import com.prueba.nexos.prueba.infrastructure.point.models.request.TransactionPurchaseRequest;
import com.prueba.nexos.prueba.infrastructure.point.models.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/{transactionId}")
    public ResponseEntity<?> consultarTransacionController(@PathVariable Long transactionId){
        return new ResponseEntity<>(transactionService.consultarTransacion(transactionId), HttpStatus.OK);
    }

    @PostMapping("/anulation")
    public ResponseEntity<?> anularTranascionController(@RequestBody TransactionRequest transactionRequest){
        return new ResponseEntity<>(transactionService.anularTransacion(transactionRequest),HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?>compraTransacionController(@RequestBody TransactionPurchaseRequest transactionPurchaseRequest){
        return new ResponseEntity<>(transactionService.transacionCompra(transactionPurchaseRequest),HttpStatus.OK);
    }

}
