package com.example.product_nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText edit_search;
    ListView lsp;
    ListAdapter adapt;
    ArrayList<Products> pro;

    String product_name, product_image, image_back, ingredients, origin, unit;
    long qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_search = findViewById(R.id.edt_search);
        //edit_search.setSelected(false);

        lsp = findViewById(R.id.lst_products);

        String api_link = getResources().getString(R.string.api_link);
        pro =  new ArrayList<>();

        try {

            String jsonData = new Asycdata().execute(api_link).get();
            System.out.println("This is From MainActivity " + jsonData);

            JSONObject MainObj = new JSONObject(jsonData);

            JSONArray productArray = MainObj.getJSONArray("data");

            for (int i = 0; i < productArray.length(); i++){

                JSONObject childObj = productArray.getJSONObject(i);

                JSONObject ProductName = childObj.getJSONObject("display_name_translations");
                JSONArray ProductImage = childObj.getJSONArray("images");
                JSONObject objingre = childObj.getJSONObject("ingredients_translations");
                JSONObject objOrigin = childObj.getJSONObject("origin_translations");

                product_name = ProductName.getString("en");
               // ingredients = objingre.getString("en");
                ingredients = "Ingredients";
                //origin = objOrigin.getString("en");
                origin = "Country Of Origin";
                unit = childObj.getString("unit");
                qty = childObj.getLong("quantity");


                for (int j = 0; j < ProductImage.length(); j++){

                    JSONObject ProImg = ProductImage.getJSONObject(j);
                    if(j == 1){

                        product_image = ProImg.getString("thumb");

                    }

                    if(j == 2){

                        image_back = ProImg.getString("thumb");

                    }

                }

                pro.add(new Products(product_name,product_image,image_back,ingredients,origin,unit,qty));

            }

            System.out.println("ArrayList Size : " + pro.size());

            adapt = new Listadapter(MainActivity.this,pro);

            lsp.setAdapter(adapt);

            lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    //Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_LONG).show();

                    Intent i = new Intent(MainActivity.this,ProductDetails.class);
                    i.putExtra("data",pro.get(position));
                    startActivity(i);

                }
            });

        } catch (InterruptedException e) {

            e.printStackTrace();

        } catch (ExecutionException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }
}
