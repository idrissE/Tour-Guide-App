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
public class RestaurantsFragment extends Fragment implements LocationRecyclerAdapter.ListItemClickListener {
    private static final String LOCATION_INTENT_KEY = "CURRENT_LOCATION";

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View featuredView = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = featuredView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        ArrayList<Location> locations = getRestaurants();
        // set the adapter
        RecyclerView.Adapter adapter = new LocationRecyclerAdapter(locations, this);
        recyclerView.setAdapter(adapter);
        // set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return featuredView;
    }

    /**
     * Generate and return a dummy list of
     * Restaurants
     */
    private ArrayList<Location> getRestaurants() {
        ArrayList<Location> restaurants = new ArrayList<>();
        restaurants.add(new Location(getString(R.string.restaurant_1), getString(R.string.lorem), R.drawable.restaurant1, 4.0f));
        restaurants.add(new Location(getString(R.string.restaurant_2), getString(R.string.lorem), R.drawable.restaurant2, 4.7f));
        restaurants.add(new Location(getString(R.string.restaurant_4), getString(R.string.lorem), R.drawable.restaurant3, 4.8f));
        restaurants.add(new Location(getString(R.string.restaurant_5), getString(R.string.lorem), R.drawable.restaurant4, 4.2f));

        return restaurants;
    }

    @Override
    public void onListItemClick(int selectedItemPosition) {
        Location selectedLocation = getRestaurants().get(selectedItemPosition);
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(LOCATION_INTENT_KEY, selectedLocation);
        startActivity(intent);
    }
}
