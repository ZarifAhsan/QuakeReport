package com.example.earthquakeactivity;

public class List {

    private String mMagnitude;

    private String mOccurrencePlace;

    private String mTimeOfOccurrence;


    public List(String magnitude, String occurrencePlace, String timeOfOccurrence) {
        mMagnitude = magnitude;
        mOccurrencePlace = occurrencePlace;
        mTimeOfOccurrence = timeOfOccurrence;
    }


    public String getMagnitude() {
        return mMagnitude;
    }

    public String getOccurrencePlace() {
        return mOccurrencePlace;
    }

    public String getTimeOfOccurrence() {
        return mTimeOfOccurrence;
    }
}
