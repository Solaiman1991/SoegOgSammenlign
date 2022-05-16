package com.example.sgogsammenlign.model.store;

public class Store {

    private final String city;
    private final String zip;
    private final double[] coordinates;

    public Store(String city, String zip, double[] coordinates) {
        this.city = city;
        this.zip = zip;
        this.coordinates = coordinates;
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
}
