package com.example.sgogsammenlign.model.store;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sgogsammenlign.model.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class StoreRepository {


    private static StoreRepository instance;
    private MutableLiveData<List<Store>> searchedStore;

    private StoreRepository()
    {
        searchedStore = new MutableLiveData<>();
    }

    public static synchronized StoreRepository getInstance()
    {
        if (instance == null)
        {
            instance = new StoreRepository();
        }
        return instance;
    }

    public LiveData<List<Store>> getSearchedStore()
    {
        return searchedStore;
    }

    public LiveData<List<Store>> searchForStore(String storeCityName, String brand)
    {
        StoreApi storeApi = ServiceGenerator.getStoreApi();
        Call<List<StoreResponse>> call = storeApi.getStore(storeCityName,brand);
        call.enqueue(new Callback<List<StoreResponse>> ()
        {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<StoreResponse>> call, Response<List<StoreResponse>> response)
            {
                if (response.code()==200)
                {
                    assert response.body() != null;
                    List<StoreResponse> storeResponseList = response.body();

                    List<Store> result = new ArrayList<>();

                    for (StoreResponse storeResponse : storeResponseList) {
                        result.add(storeResponse.getStore());
                    }

                    searchedStore.setValue(result);
                    Log.e("Retrofit", response.body().toString());



                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<StoreResponse>> call, Throwable t)
            {
                Log.i("Retrofit",t.getMessage());

            }
        });

        return searchedStore;
    }

}
