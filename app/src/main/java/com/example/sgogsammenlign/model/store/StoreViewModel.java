package com.example.sgogsammenlign.model.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StoreViewModel extends ViewModel {
    StoreRepository repository;

    public StoreViewModel() {
        repository = StoreRepository.getInstance();
    }


    public LiveData<List<Store>> searchForStore(String city,String brand) {
        return repository.searchForStore(city,brand);

    }


}