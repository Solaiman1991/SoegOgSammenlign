package com.example.sgogsammenlign.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class ProductRepository {

    private static ProductRepository instance;
    private final MutableLiveData<Product> searchedProduct;

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

    public LiveData<Product> getSearchedProduct()
    {
        return searchedProduct;
    }

    public void searchForProduct(String productName)
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
                    // maybe the first line should be deleted. but it will give nullpointer
                    assert response.body() != null;
                    searchedProduct.setValue(response.body().getProduct());

                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t)
            {
                Log.i("Retrofit","Something went wrong");
            }
        });
    }


}
