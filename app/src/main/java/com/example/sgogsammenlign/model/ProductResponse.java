package com.example.sgogsammenlign.model;

public class ProductResponse {


    private  int id;
    private  int product_id;
    private  String title;
    private  String description;
    private  String imgUrl;
    private  String productUrl;
    private int price;

    public Product getProduct()
    {
        return new Product(id,product_id,title,description,imgUrl,productUrl,price);

    }


}
