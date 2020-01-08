package com.example.myworld;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.myworld.Adapters.CountryListAdapter;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;

public class ListCountry extends AppCompatActivity {
    private static final String TAG = ListCountry.class.getSimpleName();

    ArrayAdapter adapter;
    Map<String, ArrayList<Country.CountryType>> response;
    ListView listView;
    String continent;
    Country country;
    private CountryListAdapter mAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);

        listView = (ListView) findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        continent = intent.getStringExtra("region");

        try {
            if (networkAvailable()) {
                country = new Country();
                response = country.run(continent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> countryList = null;
        if (response != null) {
            countryList = new ArrayList<>();
            for (Country.CountryType item : response.get(continent)) {
                countryList.add(item.name + " - " + item.capital);
            }

            adapter = new ArrayAdapter<>(this, R.layout.activity_list_country,
                    R.id.viewCountryTextView, countryList);
            if (mRecyclerView != null) {
                listView.setAdapter(adapter);
            }
        } else {
            System.out.println("ERROR ON GET REPONSE");
        }

        mAdapter = new CountryListAdapter(ListCountry.this, countryList);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(ListCountry.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    private boolean networkAvailable()
    {
        boolean network = false;
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            network = true;
        }

        return network;
    }


}
