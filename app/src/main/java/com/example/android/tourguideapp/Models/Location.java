package com.example.android.tourguideapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class implements Parcelable so that
 * a Location object can be passed using intents
 */
public class Location implements Parcelable {
    private String mName;
    private String mDescription;
    private int mFeaturedImage;
    private float mRating;

    public Location(String name, String description, int featuredImage, float rating) {
        mName = name;
        mDescription = description;
        mFeaturedImage = featuredImage;
        mRating = rating;
    }

    private Location(Parcel parcel) {
        mName = parcel.readString();
        mDescription = parcel.readString();
        mFeaturedImage = parcel.readInt();
        mRating = parcel.readFloat();
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getFeaturedImage() {
        return mFeaturedImage;
    }

    public float getRating() {
        return mRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeInt(mFeaturedImage);
        dest.writeFloat(mRating);
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {

        @Override
        public Location createFromParcel(Parcel parcel) {
            return new Location(parcel);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[0];
        }
    };
}
