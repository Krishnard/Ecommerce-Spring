package com.example.demo.Configurations;

import com.example.demo.Gateway.api.FakeStoreCategoryApi;
import com.example.demo.Gateway.api.FakeStoreProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    
    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
        .baseUrl("https://fakestoreapi.in/api/")
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
