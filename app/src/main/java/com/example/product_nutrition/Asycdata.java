package com.example.product_nutrition;

import android.os.AsyncTask;


/*
 *
 * Class for synchronize JSON Data into Service Call Method
 * doInBackground Method Call from MainActivity.Java for implement the methos for Calling API Link
 *
*/
public class Asycdata extends AsyncTask<String,Void,String> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {

        String jsonURL = strings[0];

        HttpHandler handler = new HttpHandler();

        String json = handler.makeServiceCall(jsonURL);
        System.out.println("This is JSON " + json);

        return json;
    }
}
