package com.example.earthquakeactivity;

public class Earthquake {

    private String mMagnitude;

    private String mOccurrencePlace;

    private String mDateOfOccurrence;

    private String mTimeOfOccurrence;


    public Earthquake(String magnitude, String occurrencePlace,String dateOfOccurrence, String timeOfOccurrence) {
        mMagnitude = magnitude;
        mOccurrencePlace = occurrencePlace;
        mDateOfOccurrence = dateOfOccurrence;
        mTimeOfOccurrence = timeOfOccurrence;
    }


    public String getMagnitude() {
        return mMagnitude;
    }

    public String getOccurrencePlace() {
        return mOccurrencePlace;
    }

    public String getDateOfOccurrence() {
        return mDateOfOccurrence;
    }

    public String getTimeOfOccurrence() {
        return mTimeOfOccurrence;
    }
}
