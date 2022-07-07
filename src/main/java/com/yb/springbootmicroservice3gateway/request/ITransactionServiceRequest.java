package com.yb.springbootmicroservice3gateway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ITransactionServiceRequest {

    @POST("/api/transaction/save")
    Call<JsonElement> saveTransaction(@Body JsonElement requestBody);

    @DELETE("/api/transaction/delete/{transactionId}")
    Call<Void> deleteTransaction(@Path("transactionId") Long transactionId);

    @GET("/api/transaction/{userId}")
    Call<List<JsonElement>> getAllTransactionsOfAuthorUser(@Path("userId") Long userId);
}
