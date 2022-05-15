package com.example.sgogsammenlign.model;

public class Product {
    private final String id;
    private final String prod_id;
    private final String title;
    private final String description;
    private final String img;
    private final String link;
    private final float price;


    public Product(String id, String product_id, String title, String description, String imgUrl, String link, float price) {
        this.id = id;
        this.prod_id = product_id;
        this.title = title;
        this.description = description;
        this.img = imgUrl;
        this.link = link;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getProd_id() {
        return prod_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public String getLink() {
        return link;
    }

    public float getPrice() {
        return price;
    }
}
