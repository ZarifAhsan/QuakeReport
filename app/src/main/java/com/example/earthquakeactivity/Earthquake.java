package com.example.earthquakeactivity;

public class Earthquake {

    private double mMagnitude;

    private String mPrimaryLocation;

    private long mTimeInMilliSeconds;


    public Earthquake(double magnitude, String primaryLocation, long timeInMilliSeconds) {
        mMagnitude = magnitude;
        mPrimaryLocation = primaryLocation;
        mTimeInMilliSeconds = timeInMilliSeconds;
    }


    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPrimaryLocation() {
        return mPrimaryLocation;
    }

    public long getTimeInMilliSeconds() {
        return mTimeInMilliSeconds;
    }
}
