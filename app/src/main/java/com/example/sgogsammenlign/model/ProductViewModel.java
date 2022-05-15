package com.example.sgogsammenlign.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ProductViewModel extends ViewModel {
    ProductRepository repository;

    public ProductViewModel() {
        repository = ProductRepository.getInstance();
    }




    public LiveData<List<Product>> searchForProduct(String s) {
       return repository.searchForProduct(s);
    }

}
