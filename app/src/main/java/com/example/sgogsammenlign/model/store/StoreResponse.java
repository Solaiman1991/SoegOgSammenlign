package com.example.sgogsammenlign.model.store;


import java.util.List;

public class StoreResponse {


    private Address address;
    private String brand;
    private double[] coordinates;


    public Store getStore()
    {
        return new Store(address.city, address.zip, coordinates,brand);

    }

    static class Address {
        public String city;
        public String zip;
    }
}
