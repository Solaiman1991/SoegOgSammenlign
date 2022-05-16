package com.example.sgogsammenlign.model.product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ProductApi {

@Headers({"Authorization: Bearer bed5d2a1-635d-4aad-b2f4-08d0411e5fde"})
    @GET("v1-beta/product-suggestions/relevant-products")

    // can also add more paths here
    Call<ProductResponse> getProduct(@Query("query") String title);


}
