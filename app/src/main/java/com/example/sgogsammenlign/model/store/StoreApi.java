package com.example.sgogsammenlign.model.store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface StoreApi {


    @Headers({"Authorization: Bearer bed5d2a1-635d-4aad-b2f4-08d0411e5fde"})
    @GET("v2/stores")

        // can also add more paths here
    Call<List<StoreResponse>> getStore(@Query("city") String city);

}
