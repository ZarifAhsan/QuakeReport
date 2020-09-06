package com.example.earthquakeactivity;

public class Earthquake {

    private double mMagnitude;

    private String mPrimaryLocation;

    private long mTimeInMilliSeconds;

    private String mUrl;


    public Earthquake(double magnitude, String primaryLocation, long timeInMilliSeconds, String url) {
        mMagnitude = magnitude;
        mPrimaryLocation = primaryLocation;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }
}
