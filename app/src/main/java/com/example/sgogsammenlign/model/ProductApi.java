package com.example.sgogsammenlign.model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ProductApi {


    @GET("v1-beta/product-suggestions/relevant-products/{title}")

    // can also add more paths here
    Call<ProductResponse> getProduct(@Path("title") String title);

}
