package com.example.myworld;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AfricaArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mAfrica;
    private String[] mAfricanCountries;

    public AfricaArrayAdapter (Context mContext, int resource, String[] mRestaurants, String[] mAfricanCountries){
        super(mContext, resource);
        this.mContext = mContext;
        this.mAfricanCountries = mAfricanCountries;
        this.mAfrica = mRestaurants;
    }

    @Override
    public Object getItem(int position){
        String africa = mAfrica[position];
        String country = mAfricanCountries[position];
        return String.format("%s \n Capital City is %s", africa, country);
    }

    @Override
    public int getCount(){
        return mAfrica.length;
    }
}
