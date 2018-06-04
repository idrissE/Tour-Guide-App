package com.example.android.tourguideapp.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.tourguideapp.Hotels.FeaturedHotelsFragment;
import com.example.android.tourguideapp.Hotels.FiveStarsHotelsFragment;
import com.example.android.tourguideapp.Hotels.FourStarsHotelsFragment;
import com.example.android.tourguideapp.Hotels.ThreeStarsHotelsFragment;
import com.example.android.tourguideapp.Hotels.TwoStarsHotelsFragment;
import com.example.android.tourguideapp.R;

public class LocationPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public LocationPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FeaturedHotelsFragment();
            case 1:
                return new FiveStarsHotelsFragment();
            case 2:
                return new FourStarsHotelsFragment();
            case 3:
                return new ThreeStarsHotelsFragment();
            default:
                return new TwoStarsHotelsFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.featured);
            case 1:
                return context.getString(R.string.five_stars);
            case 2:
                return context.getString(R.string.four_stars);
            case 3:
                return context.getString(R.string.three_stars);
            default:
                return context.getString(R.string.two_stars);
        }
    }
}
