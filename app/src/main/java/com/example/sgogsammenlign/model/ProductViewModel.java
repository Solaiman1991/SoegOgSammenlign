package com.example.sgogsammenlign.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ProductViewModel extends ViewModel {
    ProductRepository repository;

    public ProductViewModel() {
        repository = ProductRepository.getInstance();
    }

   public LiveData<Product> getSearchedProduct() {
        return repository.getSearchedProduct();
    }


    public void searchForProduct(String s) {
        repository.searchForProduct(s);
    }
}
