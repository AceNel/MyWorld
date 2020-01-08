package com.example.myworld.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myworld.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryListAdapter extends RecyclerView.Adapter <CountryListAdapter.CountryViewHolder> {
    private ArrayList<String> mCountries;
    private Context mContext;

    public CountryListAdapter(Context context, ArrayList<String> countries) {
        mContext = context;
        mCountries = countries;

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_country, parent, false);
        CountryViewHolder viewHolder = new CountryViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.flagImageView)
        ImageView mCountryImageView;
        @BindView(R.id.viewCountryTextView)
        TextView mNameTextView;
        @BindView(R.id.viewCountryTextViewCapital) TextView mCapitalTextView;
        @BindView(R.id.viewCountryTextViewPopulation) TextView mPopulationTextView;

        private Context mContext;

        public CountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }


    }
}
