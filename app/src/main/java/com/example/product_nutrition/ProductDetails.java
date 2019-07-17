package com.example.product_nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetails extends AppCompatActivity {

    TextView txt_Pname, txt_Ingredients, txt_Origin, txt_unit, txt_qty;
    ImageView img_front, img_back;
    String Pname, ingredients, origin, unit;
    long qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        txt_Pname = findViewById(R.id.txt_pname);
        txt_Ingredients = findViewById(R.id.txt_Ingredients);
        txt_Origin = findViewById(R.id.txt_Origin);
        txt_unit = findViewById(R.id.txt_Origin);
        txt_qty = findViewById(R.id.txt_Qty);
        img_front = findViewById(R.id.img_Front);
        img_back = findViewById(R.id.img_Back);

        Intent i = getIntent();

        Products p = i.getParcelableExtra("data");

        Pname = p.getProduct_name();
        ingredients = p.getIngredients();
        origin = p.getOrigin();
        unit = p.getUnit();
        qty = p.getQty();

        System.out.println("Data : " + Pname + " " + qty);
       // txt_Pname.setText("Product Name");
        /*txt_Ingredients.setText(ingredients);
        txt_Origin.setText(origin);
        txt_unit.setText(unit);
        txt_qty.setText((int) qty);*/

       // Picasso.get().load(p.getProduct_image()).into(img_front);
        //Picasso.get().load(p.getImage_back()).into(img_back);


    }
}
