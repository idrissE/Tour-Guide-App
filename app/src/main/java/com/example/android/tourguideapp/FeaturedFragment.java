package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp.Adapters.LocationRecyclerAdapter;
import com.example.android.tourguideapp.Models.Location;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends Fragment implements LocationRecyclerAdapter.ListItemClickListener {
    private static final String LOCATION_INTENT_KEY = "CURRENT_LOCATION";

    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View featuredView = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = featuredView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        ArrayList<Location> locations = getLocations();
        // set the adapter
        RecyclerView.Adapter adapter = new LocationRecyclerAdapter(locations, this);
        recyclerView.setAdapter(adapter);
        // set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return featuredView;
    }

    /**
     * Generates and returns a dummy list of
     * featured locations
     */
    private ArrayList<Location> getLocations() {
        ArrayList<Location> featuredLocations = new ArrayList<>();
        featuredLocations.add(new Location(getString(R.string.hotel_5stars_1), getString(R.string.lorem), R.drawable.hotel1, 5f));
        featuredLocations.add(new Location(getString(R.string.hotel_5stars_2), getString(R.string.lorem), R.drawable.hotel3, 4.9f));
        featuredLocations.add(new Location(getString(R.string.hotel_5stars_3), getString(R.string.lorem), R.drawable.hotel2, 4.5f));
        featuredLocations.add(new Location(getString(R.string.natural_attr_1), getString(R.string.lorem), R.drawable.nature1, 4.8f));
        featuredLocations.add(new Location(getString(R.string.restaurant_1), getString(R.string.lorem), R.drawable.restaurant1, 4.0f));

        return featuredLocations;
    }

    @Override
    public void onListItemClick(int selectedItemPosition) {
        Location selectedLocation = getLocations().get(selectedItemPosition);
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(LOCATION_INTENT_KEY, selectedLocation);
        startActivity(intent);
    }
}
