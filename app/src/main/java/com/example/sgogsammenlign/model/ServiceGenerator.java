package com.example.sgogsammenlign.model;
// this class is responsible for generating the API, where it uses Retrofit
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static ProductApi productApi;

    public static ProductApi getProductApi()
    {
        if (productApi == null)
        {
            productApi = new Retrofit.Builder().
                    baseUrl("https://api.sallinggroup.com/").
                    addConverterFactory(GsonConverterFactory.create()).
                    build().create(ProductApi.class);

        }
        return productApi;


    }
}
