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
public class NatureFragment extends Fragment implements LocationRecyclerAdapter.ListItemClickListener {
    private static final String LOCATION_INTENT_KEY = "CURRENT_LOCATION";

    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View featuredView = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = featuredView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        ArrayList<Location> locations = getNatureAttractions();
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
     * Natural attractions
     */
    private ArrayList<Location> getNatureAttractions() {
        ArrayList<Location> natureLocations = new ArrayList<>();
        natureLocations.add(new Location(getString(R.string.natural_attr_1), getString(R.string.lorem), R.drawable.nature1, 4.3f));
        natureLocations.add(new Location(getString(R.string.natural_attr_2), getString(R.string.lorem), R.drawable.nature2, 4f));
        natureLocations.add(new Location(getString(R.string.natural_attr_3), getString(R.string.lorem), R.drawable.nature3, 4.2f));

        return natureLocations;
    }

    @Override
    public void onListItemClick(int selectedItemPosition) {
        Location selectedLocation = getNatureAttractions().get(selectedItemPosition);
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(LOCATION_INTENT_KEY, selectedLocation);
        startActivity(intent);
    }
}
