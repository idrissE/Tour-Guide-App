package com.example.android.tourguideapp.Hotels;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp.Adapters.LocationRecyclerAdapter;
import com.example.android.tourguideapp.DetailActivity;
import com.example.android.tourguideapp.Models.Location;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedHotelsFragment extends Fragment implements LocationRecyclerAdapter.ListItemClickListener {
    private static final String LOCATION_INTENT_KEY = "CURRENT_LOCATION";

    public FeaturedHotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View featuredHotelsView = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = featuredHotelsView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        ArrayList<Location> locations = getFeaturedHotels();
        // set the adapter
        RecyclerView.Adapter adapter = new LocationRecyclerAdapter(locations, this);
        recyclerView.setAdapter(adapter);
        // set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return featuredHotelsView;
    }

    /**
     * Generates and returns a dummy list of
     * Restaurants
     */
    private ArrayList<Location> getFeaturedHotels() {
        ArrayList<Location> hotels = new ArrayList<>();
        hotels.add(new Location(getString(R.string.hotel_5stars_1), getString(R.string.lorem), R.drawable.hotel1, 4.9f));
        hotels.add(new Location(getString(R.string.hotel_5stars_2), getString(R.string.lorem), R.drawable.hotel3, 4.7f));
        hotels.add(new Location(getString(R.string.hotel_5stars_4), getString(R.string.lorem), R.drawable.hotel4, 4.2f));
        hotels.add(new Location(getString(R.string.hotel_4stars_1), getString(R.string.lorem), R.drawable.hotel3, 4.1f));
        hotels.add(new Location(getString(R.string.hotel_4stars_2), getString(R.string.lorem), R.drawable.hotel2, 4.6f));

        return hotels;
    }

    @Override
    public void onListItemClick(int selectedItemPosition) {
        Location selectedLocation = getFeaturedHotels().get(selectedItemPosition);
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(LOCATION_INTENT_KEY, selectedLocation);
        startActivity(intent);
    }
}
