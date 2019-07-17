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

    String product_name, product_image, image_back, nutrition, unit;


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
                JSONObject objNutri = childObj.getJSONObject("nutrients");

                if (objNutri.has("protein")){

                    JSONObject objProtein = objNutri.getJSONObject("protein");
                    JSONObject objProteinName = objProtein.getJSONObject("name_translations");

                    nutrition = objProteinName.getString("en");

                }

                    nutrition += " ";

                if (objNutri.has("carbohydrates")){

                    JSONObject objCarbo = objNutri.getJSONObject("carbohydrates");
                    JSONObject objCarboName = objCarbo.getJSONObject("name_translations");

                    nutrition += objCarboName.getString("en");

                }

                nutrition += " ";

                if (objNutri.has("fat")){

                    JSONObject objFat = objNutri.getJSONObject("fat");
                    JSONObject objFatName = objFat.getJSONObject("name_translations");

                    nutrition += objFatName.getString("en");

                }

                nutrition += " ";

                if (objNutri.has("sodium")){

                    JSONObject objSodium = objNutri.getJSONObject("sodium");
                    JSONObject objSodiumName = objSodium.getJSONObject("name_translations");

                    nutrition += objSodiumName.getString("en");

                }

                nutrition += " ";

                if (objNutri.has("fiber")){

                    JSONObject objFiber = objNutri.getJSONObject("fiber");
                    JSONObject objFiberName = objFiber.getJSONObject("name_translations");

                    nutrition += objFiberName.getString("en");

                }

                nutrition += " ";

                if (objNutri.has("salt")){

                    JSONObject objSalt = objNutri.getJSONObject("salt");
                    JSONObject objSaltName = objSalt.getJSONObject("name_translations");

                    nutrition += objSaltName.getString("en");

                }

                nutrition += " ";

                if (objNutri.has("sugars")){

                    JSONObject objSugar = objNutri.getJSONObject("sugars");
                    JSONObject objSugarName = objSugar.getJSONObject("name_translations");

                    nutrition += objSugarName.getString("en");

                }

                nutrition += " ";

                if (objNutri.has("energy_kcal")){

                    JSONObject objEnergyCal = objNutri.getJSONObject("energy_kcal");
                    JSONObject objEnergyCalName = objEnergyCal.getJSONObject("name_translations");

                    nutrition += objEnergyCalName.getString("en");


                }

                nutrition += " ";

                if(objNutri.has("energy")){

                    JSONObject objEnergy = objNutri.getJSONObject("energy");
                    JSONObject objEnergyName = objEnergy.getJSONObject("name_translations");

                    nutrition += objEnergyName.getString("en");

                }




                product_name = ProductName.getString("en");
                //nutrition = "Nutrition";
                unit = childObj.getString("unit");

                for (int j = 0; j < ProductImage.length(); j++){

                    JSONObject ProImg = ProductImage.getJSONObject(j);
                    if(j == 1){

                        product_image = ProImg.getString("large");

                    }

                    if(j == 2){

                        image_back = ProImg.getString("large");

                    }

                }

                pro.add(new Products(product_name,product_image,image_back,nutrition,unit));

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
