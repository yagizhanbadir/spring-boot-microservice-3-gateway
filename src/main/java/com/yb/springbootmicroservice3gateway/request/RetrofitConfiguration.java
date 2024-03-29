package com.yb.springbootmicroservice3gateway.request;

import com.google.gson.Gson;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfiguration{

    @Value("${retrofit.timeout}")
    private Long TIMEOUT_IN_SECS;

    @Bean
    public OkHttpClient secureKeyClient(@Value("${service.security.secure-key-username}") String username,
                                        @Value("${service.security.secure-key-password}") String password){

        return createDefaultClientBuilder().addInterceptor(interceptor -> interceptor.proceed(interceptor.request().newBuilder()
                .header("Authorization", Credentials.basic(username,password)).build()))
                .build();

    }

    @Bean
    public Retrofit.Builder secureKeyBuilder(OkHttpClient secureKeyClient, Gson gson){
        return new Retrofit.Builder().client(secureKeyClient).addConverterFactory(GsonConverterFactory.create(gson));
    }

    private OkHttpClient.Builder createDefaultClientBuilder(){
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_IN_SECS, TimeUnit.SECONDS);
    }

    @Bean
    public IProductServiceRequest productServiceRequest(Retrofit.Builder secureKeyBuilder,
                                                        @Value("${product.service.url}") String baseUrl){

        return secureKeyBuilder
                .baseUrl(baseUrl)
                .build()
                .create(IProductServiceRequest.class);
    }

    @Bean
    public ITransactionServiceRequest transactionServiceRequest(Retrofit.Builder secureKeyBuilder,
                                                        @Value("${transaction.service.url}") String baseUrl){

        return secureKeyBuilder
                .baseUrl(baseUrl)
                .build()
                .create(ITransactionServiceRequest.class);
    }
}
