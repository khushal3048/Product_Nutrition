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

    String product_name, product_image, image_back, unit, nutrition;


    public Products(String product_name, String product_image) {
        this.product_name = product_name;
        this.product_image = product_image;
    }

    public Products(String product_name, String product_image, String image_back, String nutrition , String unit) {
        this.product_name = product_name;
        this.product_image = product_image;
        this.image_back = image_back;
        this.nutrition = nutrition;
        this.unit = unit;

    }

    protected Products(Parcel in) {
        product_name = in.readString();
        product_image = in.readString();
        image_back = in.readString();
        nutrition=in.readString();
        unit = in.readString();

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

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
       dest.writeString(nutrition);
        dest.writeString(unit);

    }
}
