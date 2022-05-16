package com.example.sgogsammenlign.model.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StoreViewModel extends ViewModel {
    StoreRepository repository;
    MutableLiveData<List<Store>> dummyStores;

    public StoreViewModel() {
        repository = StoreRepository.getInstance();
    }


    public LiveData<List<Store>> searchForStore(String city) {
        // return repository.searchForStore(city);

        double[] coordiantesDummy = {9.469351,
                55.475203};
        Store storeDummy = new Store("Kolding", "6000", coordiantesDummy);
        dummyStores = new MutableLiveData<>();
        List<Store> arryDummyList = new ArrayList<>();
        arryDummyList.add(storeDummy);
        dummyStores.setValue(arryDummyList);

        return dummyStores;
    }


}