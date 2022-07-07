package com.yb.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.yb.springbootmicroservice3gateway.security.UserPrincipal;
import com.yb.springbootmicroservice3gateway.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/transaction")
public class TransactionController {

   @Autowired
   private ITransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody JsonElement transaction){
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("/delete/{transactionId}")
    public ResponseEntity<?> saveProduct(@PathVariable Long transactionId){
        transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal principal){

        return ResponseEntity.ok(transactionService.getAllTransactionsOfAuthorizedUser(principal.getId()));
    }
}
