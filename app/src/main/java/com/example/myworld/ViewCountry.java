package com.example.myworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ViewCountry extends AppCompatActivity {
    TextView textView;
    TextView textViewPopulation;
    TextView textViewCapital;
    TextView textViewRegion;
    ImageView imageViewFlag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_country);
        textView = (TextView) findViewById(R.id.viewCountryTextView);
        textViewRegion = (TextView) findViewById(R.id.viewCountryTextViewRegion);
        textViewPopulation = (TextView) findViewById(R.id.viewCountryTextViewPopulation);
        textViewCapital= (TextView) findViewById(R.id.viewCountryTextViewCapital);
        imageViewFlag= (ImageView) findViewById(R.id.flagImageView);

        Intent intent = getIntent();
        String countryName = intent.getStringExtra("countryName");
        String countryRegion = intent.getStringExtra("countryRegion");
        String countryCapital = intent.getStringExtra("countryCapital");
        String countryPopulation = intent.getStringExtra("countryPopulation");

        textView.setText("Country Name:" + countryName);
        textViewRegion.setText("Continent: " + countryRegion);
        textViewPopulation.setText("Population: " + countryPopulation + " inhabitants");
        textViewCapital.setText("Capital: " + countryCapital);
      //  Picasso.get().load(country.getImageUrl()).into(imageViewFlag);



    }
}
