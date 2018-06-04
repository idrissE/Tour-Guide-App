package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.tourguideapp.Models.Location;

public class DetailActivity extends AppCompatActivity {
    private static final String LOCATION_INTENT_KEY = "CURRENT_LOCATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Location currentLocation = intent.getParcelableExtra(LOCATION_INTENT_KEY);
        setupLocationDetails(currentLocation);
    }

    private void setupLocationDetails(Location location) {
        TextView locationNameTv = findViewById(R.id.detail_name);
        locationNameTv.setText(location.getName());

        TextView locationDescTv = findViewById(R.id.detail_description);
        locationDescTv.setText(location.getDescription());

        ImageView locationFeaturedImg = findViewById(R.id.detail_featured_img);
        locationFeaturedImg.setImageResource(location.getFeaturedImage());

        RatingBar locationRatingRB = findViewById(R.id.detail_rating);
        locationRatingRB.setRating(location.getRating());
    }
}
