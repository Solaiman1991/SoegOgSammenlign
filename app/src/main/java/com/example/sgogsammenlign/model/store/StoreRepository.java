package com.example.sgogsammenlign.model.store;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sgogsammenlign.model.ServiceGenerator;

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

    public LiveData<List<Store>> searchForStore(String storeCityName)
    {
        StoreApi storeApi = ServiceGenerator.getStoreApi();
        Call<StoreResponse> call = storeApi.getStore(storeCityName);
        call.enqueue(new Callback<StoreResponse> ()
        {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<StoreResponse> call, Response<StoreResponse> response)
            {
                if (response.code()==200)
                {
                    // maybe the first line should be deleted. but it will give nullpointer
                    assert response.body() != null;
//                    searchedStore.setValue(response.body().getStores().get(0));
                    searchedStore.setValue(response.body().getStores());
                    Log.e("Retrofit", response.body().toString());



                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<StoreResponse> call, Throwable t)
            {
                Log.i("Retrofit",t.getMessage());

            }
        });

        return searchedStore;
    }

}
