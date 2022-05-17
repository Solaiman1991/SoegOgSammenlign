package com.example.sgogsammenlign.model.store;

public class Store {

    private final String city;
    private final String zip;
    private final double[] coordinates;
    private final String brand;


    public Store(String city, String zip, double[] coordinates, String brand) {
        this.city = city;
        this.zip = zip;
        this.coordinates = coordinates;
        this.brand =  brand;
    }


    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public String getBrand(){
        return brand;
    }
}
