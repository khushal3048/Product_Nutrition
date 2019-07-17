package com.example.product_nutrition;

import android.os.Parcel;
import android.os.Parcelable;

/*
 *
 * Product Class used for display Product Data Into ListView
 * Data that we get from API
 * In this Class, There is only Getter and Setter Methods to Get data about product and Set Data of Product one by one
 * Also this class is used for pass data from MainActivity to ProductDetails
 * Where we display full Description of Single Product
 *
*/
public class Products implements Parcelable {

    String product_name, product_image, image_back, ingredients, origin, unit;
    long qty;

    public Products(String product_name, String product_image) {
        this.product_name = product_name;
        this.product_image = product_image;
    }

    public Products(String product_name, String product_image, String image_back, String ingredients, String origin, String unit, long qty) {
        this.product_name = product_name;
        this.product_image = product_image;
        this.image_back = image_back;
        this.ingredients = ingredients;
        this.origin = origin;
        this.unit = unit;
        this.qty = qty;
    }

    protected Products(Parcel in) {
        product_name = in.readString();
        product_image = in.readString();
        image_back = in.readString();
        ingredients = in.readString();
        origin = in.readString();
        unit = in.readString();
        qty = in.readLong();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

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

    public String getImage_back() {
        return image_back;
    }

    public void setImage_back(String image_back) {
        this.image_back = image_back;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(product_name);
        dest.writeString(product_image);
        dest.writeString(image_back);
        dest.writeString(ingredients);
        dest.writeString(origin);
        dest.writeString(unit);
        dest.writeLong(qty);
    }
}
