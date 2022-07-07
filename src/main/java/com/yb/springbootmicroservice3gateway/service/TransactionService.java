package com.yb.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.yb.springbootmicroservice3gateway.request.ITransactionServiceRequest;
import com.yb.springbootmicroservice3gateway.utils.RetrofitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TransactionService implements ITransactionService{

    @Autowired
    private ITransactionServiceRequest transactionServiceRequest;

    @Override
    public JsonElement saveTransaction(JsonElement requestBody) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(requestBody));
    }

    @Override
    public void deleteTransaction(Long productId) {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(productId));
    }

    @Override
    public List<JsonElement> getAllTransactionsOfAuthorizedUser(Long userId) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionsOfAuthorUser(userId));
    }

}
