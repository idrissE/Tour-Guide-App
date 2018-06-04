package com.example.android.tourguideapp.Hotels;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguideapp.Adapters.LocationListAdapter;
import com.example.android.tourguideapp.DetailActivity;
import com.example.android.tourguideapp.Models.Location;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoStarsHotelsFragment extends Fragment {
    private static final String LOCATION_INTENT_KEY = "CURRENT_LOCATION";

    public TwoStarsHotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View hotelsRootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Location> hotels = getFiveStarsHotels();
        LocationListAdapter adapter = new LocationListAdapter(getContext(), hotels);

        ListView hotelsLV = hotelsRootView.findViewById(R.id.list);
        hotelsLV.setAdapter(adapter);
        hotelsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location selectedLocation = (Location) parent.getItemAtPosition(position);
                showLocationDetail(selectedLocation);
            }
        });

        return hotelsRootView;
    }

    /**
     * Generates and returns a dummy list of
     * 5 stars hotels
     */
    private ArrayList<Location> getFiveStarsHotels() {
        ArrayList<Location> hotels = new ArrayList<>();
        hotels.add(new Location(getString(R.string.hotel_2stars_1), getString(R.string.lorem), R.drawable.hotel2, 4.7f));
        hotels.add(new Location(getString(R.string.hotel_2stars_2), getString(R.string.lorem), R.drawable.hotel1, 4.0f));
        hotels.add(new Location(getString(R.string.hotel_2stars_3), getString(R.string.lorem), R.drawable.hotel3, 4.5f));
        hotels.add(new Location(getString(R.string.hotel_2stars_4), getString(R.string.lorem), R.drawable.hotel4, 4.1f));
        hotels.add(new Location(getString(R.string.hotel_2stars_5), getString(R.string.lorem), R.drawable.hotel1, 3.9f));
        hotels.add(new Location(getString(R.string.hotel_2stars_6), getString(R.string.lorem), R.drawable.hotel2, 4.2f));
        hotels.add(new Location(getString(R.string.hotel_2stars_7), getString(R.string.lorem), R.drawable.hotel3, 4.8f));

        return hotels;
    }

    private void showLocationDetail(Location selectedLocation) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(LOCATION_INTENT_KEY, selectedLocation);
        startActivity(intent);
    }
}
