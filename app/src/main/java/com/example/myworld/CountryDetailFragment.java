package com.example.myworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


    public class CountryDetailFragment extends Fragment {
        @BindView(R.id.flagImageView)
        ImageView mImageLabel;
        @BindView(R.id.viewCountryTextView)
        TextView mNameLabel;
        @BindView(R.id.viewCountryTextViewPopulation) TextView mCategoriesLabel;
        @BindView(R.id.viewCountryTextViewCapital) TextView mRatingLabel;
        @BindView(R.id.viewCountryTextViewRegion) TextView mWebsiteLabel;


        private NewCountry mCountry;

        public CountryDetailFragment() {
            // Required empty public constructor
        }

        public static CountryDetailFragment newInstance(Country country){
            CountryDetailFragment  restaurantDetailFragment = new CountryDetailFragment ();
            Bundle args = new Bundle();
            args.putParcelable("restaurant", Parcels.wrap(country));
            restaurantDetailFragment.setArguments(args);
            return restaurantDetailFragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            mCountry = Parcels.unwrap(getArguments().getParcelable("restaurant"));
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_country_detail, container, false);
            ButterKnife.bind(this, view);
            Picasso.get().load(mCountry.getImageUrl()).into(mImageLabel);

            return view;
        }

    }

