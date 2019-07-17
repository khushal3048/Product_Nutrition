package com.example.product_nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ProductDetails extends AppCompatActivity {

    TextView txt_Pname, txt_Nutrition, txt_unit;
    ImageView img_front, img_back;
    String Pname, nutrition , unit;
    long qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        txt_Pname = findViewById(R.id.txt_Pname);
        txt_Nutrition = findViewById(R.id.txt_Nutrition);
        txt_unit = findViewById(R.id.txt_Unit);

        img_front = findViewById(R.id.img_Front);
        img_back = findViewById(R.id.img_Back);

        Intent i = getIntent();

        Products p = i.getParcelableExtra("data");

        Pname = p.getProduct_name();
        nutrition = p.getNutrition();
        unit = p.getUnit();

        txt_Pname.setText(Pname);
        txt_Nutrition.setText(nutrition);
        txt_unit.setText(unit);

        Picasso.get().load(p.getProduct_image()).into(img_front);
        Picasso.get().load(p.getImage_back()).into(img_back);


    }
}
