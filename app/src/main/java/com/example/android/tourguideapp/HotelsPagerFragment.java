package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguideapp.Adapters.LocationPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsPagerFragment extends Fragment {

    public HotelsPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View hotelsRootView = inflater.inflate(R.layout.fragment_hotels_pager, container, false);
        // Set up the view pager
        ViewPager pager = hotelsRootView.findViewById(R.id.pager);
        LocationPagerAdapter pagerAdapter = new LocationPagerAdapter(getContext(), getFragmentManager());
        pager.setAdapter(pagerAdapter);

        // set up the tab layout
        TabLayout tabs = hotelsRootView.findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);

        return hotelsRootView;
    }

}
