package com.example.product_nutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Listadapter extends BaseAdapter {

    Context context;
    ArrayList<Products> products;

    LayoutInflater inflater;

    public Listadapter(Context context, ArrayList<Products> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if(inflater == null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if(convertview == null){

            convertview = inflater.inflate(R.layout.list_item,parent,false);

        }

        ImageView img_product = convertview.findViewById(R.id.img_products);
        TextView txt_productName = convertview.findViewById(R.id.txt_pname);

        Picasso.get().load(products.get(position).getProduct_image()).into(img_product);
        txt_productName.setText(products.get(position).getProduct_name());

        return convertview;
    }
}
