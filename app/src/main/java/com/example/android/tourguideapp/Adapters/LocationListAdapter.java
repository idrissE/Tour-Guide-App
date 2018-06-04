package com.example.android.tourguideapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.Models.Location;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

public class LocationListAdapter extends ArrayAdapter<Location> {
    public LocationListAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        Location currentLocation = getItem(position);

        if (currentView == null)
            currentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_list_item, parent, false);

        ImageView locationFeaturedImage = currentView.findViewById(R.id.location_featured_img);
        locationFeaturedImage.setImageResource(currentLocation.getFeaturedImage());

        TextView locationName = currentView.findViewById(R.id.location_name);
        locationName.setText(currentLocation.getName());

        TextView locationShortDescription = currentView.findViewById(R.id.location_short_description);
        locationShortDescription.setText(currentLocation.getDescription());

        return currentView;
    }
}