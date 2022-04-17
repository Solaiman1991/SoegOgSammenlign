package com.example.sgogsammenlign.model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ProductApi {

@Headers({"authorization: bed5d2a1-635d-4aad-b2f4-08d0411e5fde",
"Platform: Android"})
    @GET("v1-beta/product-suggestions/relevant-products{title}")

    // can also add more paths here
    Call<ProductResponse> getProduct(@Query("title") String title);

}
