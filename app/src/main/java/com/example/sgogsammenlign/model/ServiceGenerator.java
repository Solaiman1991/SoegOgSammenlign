package com.example.sgogsammenlign.model;
// this class is responsible for generating the API, where it uses Retrofit

import com.example.sgogsammenlign.model.product.ProductApi;
import com.example.sgogsammenlign.model.store.StoreApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static ProductApi productApi;
    private static StoreApi storeApi;

    public static ProductApi getProductApi() {
        if (productApi == null) {
            productApi = new Retrofit.Builder().
                    baseUrl("https://api.sallinggroup.com/").
                    addConverterFactory(GsonConverterFactory.create()).
                    build().create(ProductApi.class);

        }
        return productApi;


    }


    public static StoreApi getStoreApi() {
        if (storeApi == null) {
            storeApi = new Retrofit.Builder().
                    baseUrl("https://api.sallinggroup.com/").
                    addConverterFactory(GsonConverterFactory.create()).
                    build().create(StoreApi.class);

        }
        return storeApi;


    }
}
