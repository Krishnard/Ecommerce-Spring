package com.example.demo.Configurations;

import com.example.demo.Gateway.api.FakeStoreCategoryApi;
import com.example.demo.Gateway.api.FakeStoreProductApi;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    
    Dotenv dotenv = Dotenv.configure().load();
    
    
    @Value("${fakeStore.baseUrl}")
    private String fakeBaseUrl;
    
    
    @Bean
    public Retrofit retrofit(){
        
        return new Retrofit.Builder()
        .baseUrl(fakeBaseUrl) // use the value from application.properties
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }

    @Bean // assume it as an object
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryApi.class);
    }
    // this method is responsible for providing the object of FakeStoreCategoryApi
    
    
    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        return retrofit.create(FakeStoreProductApi.class);
    }
    
    
    
}
