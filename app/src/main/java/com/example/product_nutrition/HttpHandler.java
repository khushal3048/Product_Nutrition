package com.example.product_nutrition;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 *
 * HTTPHANDLER Class is used for Handling API Response
 * It Covert Json Data into Iterable Data That we can use after to Display in ListView
 *
*/
public class HttpHandler {

    public HttpHandler() {
    }

    public String makeServiceCall(String api_url){

        String response = null;

        try {

            URL url = new URL(api_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
           // connection.setRequestProperty("Content-type","application/json");
            connection.setRequestProperty("Authorization", "Token token=29d627b7563f2318bae73d77a6bc11e5");
            // Read Response from API

            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            response = convertStream(inputStream);

        } catch (MalformedURLException e) {

            Log.e("HttpHandler Class","MalformedURLException :" + e.getMessage() );

        } catch (IOException e) {

            Log.e("HttpHandler Class","IOException :" + e.getMessage() );

        }

        return response;
    }

    public String convertStream(InputStream inputStream) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try {

            while ((line = reader.readLine()) != null){

                stringBuilder.append(line).append("\n");

            }
        } catch (IOException e) {

            Log.e("ConvertStream","IOException :" + e.getMessage() );

        }finally {

            try {

                inputStream.close();
            } catch (IOException e) {

                Log.e("ConvertStreamFinally","IOException :" + e.getMessage() );

            }

        }

        return stringBuilder.toString();
    }
}
