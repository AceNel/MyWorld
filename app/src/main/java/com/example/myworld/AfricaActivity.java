package com.example.myworld;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import butterknife.BindView;
import butterknife.ButterKnife;

public class AfricaActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] restaurants = new String[] {"Kenya", "Uganda",
            "Tanzania", "Nigeria", "Ghana", "Egypt",
            "Sudan", "South Sudan", "Somalia", "Djibouti",
            "Rwanda", "Burundi", "Congo",
            "South Africa", "Namibia"};
    private String[] cuisines = new String[] {"Nairobi", "Kampala", "Dodoma",
            "Lagos", "Accra", "Cairo", "Khartoum", "Juba", "Mogadishu","Djibouti",
            "Kigali", "Gitega", "Zaire", "Cape Town", "Whindoek", };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africa);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        AfricaArrayAdapter adapter = new  AfricaArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(AfricaActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
        mLocationTextView.setText("Here are all the countries in Africa");
    }


}
