package com.example.sgogsammenlign.model;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductResponse {

    private List<Product> suggestions;


    public List<Product> getProducts()
    {
        return suggestions;

    }


}
