package com.prueba.nexos.prueba.infrastructure.point.controller;


import com.prueba.nexos.prueba.aplication.services.CardService;
import com.prueba.nexos.prueba.infrastructure.point.models.request.CardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card")
public class CardController {


    @Autowired
    private CardService cardService;

    @GetMapping("/{productoId}/number")
    public ResponseEntity<?> generateCardPort(@PathVariable String productoId){
        return new ResponseEntity<>(cardService.generarCard(productoId), HttpStatus.OK);
    }

    @PostMapping("/enroll")
    public ResponseEntity<?>activateCardPort(@RequestBody CardRequest card){
        return new ResponseEntity<>(cardService.activeCard(card.getCardId()),HttpStatus.OK);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<?>blockCardPort(@PathVariable String cardId){
        return new ResponseEntity<>(cardService.blockCard(cardId),HttpStatus.OK);
    }

    @PostMapping("/balance")
    public ResponseEntity<?>rechangeBalanceCardPort(@RequestBody CardRequest cardRequest){
        return new ResponseEntity<>(cardService.rechangeBalance(cardRequest),HttpStatus.OK);
    }

    @GetMapping("/balance/{cardId}")
    public ResponseEntity<?>checkBalance(@PathVariable String cardId){
        return new ResponseEntity<>(cardService.checkBalance(cardId),HttpStatus.OK);
    }
}
