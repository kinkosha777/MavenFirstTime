import com.fasterxml.jackson.databind.ObjectMapper;

import models.Products;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://www.7timer.info/bin/astro.php?lon=74.59&lat=42.88&ac=0&unit=metric&output=json&tzshift=0");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String json = response.body().string();
        Products obj = objectMapper.readValue(json, Products.class);
        System.out.println(obj);
    }
}