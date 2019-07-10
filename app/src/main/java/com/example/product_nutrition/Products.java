package com.example.product_nutrition;

/*
 *
 * Product Class used for display Product Data Into ListView
 * Data that we get from API
 * In this Class, There is only Getter and Setter Methods to Get data about product and Set Data of Product one by one
 * Also this class is used for pass data from MainActivity to ProductDetails
 * Where we display full Description of Single Product
 *
*/
public class Products {

    String product_name, product_image;

    public Products(String product_name, String product_image) {
        this.product_name = product_name;
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
}
