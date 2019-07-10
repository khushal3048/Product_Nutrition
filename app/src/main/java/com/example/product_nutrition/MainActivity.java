package com.example.product_nutrition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText edit_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_search = findViewById(R.id.edt_search);
        //edit_search.setSelected(false);

        String api_link = getResources().getString(R.string.api_link);

        try {

            String jsonData = new Asycdata().execute(api_link).get();
            System.out.println("This is From MainActivity " + jsonData);

        } catch (InterruptedException e) {

            e.printStackTrace();

        } catch (ExecutionException e) {

            e.printStackTrace();

        }
    }
}
