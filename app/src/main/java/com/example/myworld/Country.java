package com.example.myworld;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Country {
    private final OkHttpClient client = new OkHttpClient();
    protected static CountryType[] data;
    private final Gson gson = new Gson();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Map<String, ArrayList<CountryType>> run(String region) throws Exception {
        Request request = new Request.Builder()
                .url("https://ajayakv-rest-countries-v1.p.rapidapi.com/rest/v1/all")
                .get()
                .addHeader("x-rapidapi-host", "ajayakv-rest-countries-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2f94d532cbmshae55bbd53f2e573p1267b4jsn968791f03e59")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();

                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                Reader stream = response.body().charStream();
                Country.data = gson.fromJson(stream, CountryType[].class);
            }
        });

        Map<String, ArrayList<CountryType>> response = this.getRegion(Country.data);

        return response;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Map<String, ArrayList<CountryType>> getRegion(CountryType[] data)
    {
        Map<String, ArrayList<CountryType>> region = new ArrayMap<>();

        ArrayList americas = new ArrayList<>();
        ArrayList asia = new ArrayList<>();
        ArrayList europe = new ArrayList<>();
        ArrayList africa = new ArrayList<>();
        ArrayList oceania = new ArrayList<>();

        for (CountryType item : data) {
            switch (item.region) {
                case "Americas":
                    americas.add(item);
                    break;
                case "Asia":
                    asia.add(item);
                    break;
                case "Europe":
                    europe.add(item);
                    break;
                case "Africa":
                    africa.add(item);
                    break;
                case "Oceania":
                    oceania.add(item);
                    break;
            }
        }

        region.put("Asia", asia);
        region.put("Americas", americas);
        region.put("Europe", europe);
        region.put("Africa", africa);
        region.put("Oceania", oceania);

        return region;
    }

    static class CountryType {
        String name;
        String capital;
        String region;
        String population;
        String flag;



    }
}
