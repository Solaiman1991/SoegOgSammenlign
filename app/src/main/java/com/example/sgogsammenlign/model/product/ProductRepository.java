package com.example.sgogsammenlign.model.product;

import android.util.Log;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sgogsammenlign.model.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class ProductRepository {

    private static ProductRepository instance;
    private MutableLiveData<List<Product>> searchedProduct;

    private ProductRepository()
    {
        searchedProduct = new MutableLiveData<>();
    }

    public static synchronized ProductRepository getInstance()
    {
        if (instance == null)
        {
            instance = new ProductRepository();
        }
        return instance;
    }

    public LiveData<List<Product>> getSearchedProduct()
    {
        return searchedProduct;
    }

    public LiveData<List<Product>> searchForProduct(String productName)
    {
        ProductApi productApi = ServiceGenerator.getProductApi();
        Call<ProductResponse> call = productApi.getProduct(productName);
        call.enqueue(new Callback<ProductResponse>()
        {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response)
            {
                if (response.code()==200)
                {
                    assert response.body() != null;
                    searchedProduct.setValue(response.body().getProducts());

                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t)
            {
                Log.i("Retrofit",t.getMessage());
            }
        });

        System.out.println("size efter ? " + searchedProduct.getValue());
        return searchedProduct;
    }


}
