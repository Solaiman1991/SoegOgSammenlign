package com.example.sgogsammenlign.model;

public class Product {
    private final int id;
    private final int product_id;
    private final String title;
    private final String description;
    private final String imgUrl;
    private final String productUrl;
    private final int price;


    public Product(int id, int product_id, String title, String description, String imgUrl, String productUrl, int price) {
        this.id = id;
        this.product_id = product_id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.productUrl = productUrl;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public int getPrice() {
        return price;
    }
}
