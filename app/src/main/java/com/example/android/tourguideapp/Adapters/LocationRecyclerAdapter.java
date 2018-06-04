package com.example.android.tourguideapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.tourguideapp.Models.Location;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

public class LocationRecyclerAdapter extends RecyclerView.Adapter<LocationRecyclerAdapter.ViewHolder> {
    private ArrayList<Location> mLocations;

    private final ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int selectedItemPosition);
    }

    public LocationRecyclerAdapter(ArrayList<Location> locations, ListItemClickListener listener) {
        mLocations = locations;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View locationCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_card_item, parent, false);

        return new ViewHolder(locationCard);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mLocations.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            Location currentLocation = mLocations.get(position);

            TextView locationName = itemView.findViewById(R.id.location_name);
            locationName.setText(currentLocation.getName());

            ImageView locationFeaturedImg = itemView.findViewById(R.id.location_featured_img);
            locationFeaturedImg.setImageResource(currentLocation.getFeaturedImage());

            RatingBar locationRating = itemView.findViewById(R.id.rating);
            locationRating.setRating(currentLocation.getRating());
        }

        @Override
        public void onClick(View v) {
            int selectedItemPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(selectedItemPosition);
        }
    }
}
