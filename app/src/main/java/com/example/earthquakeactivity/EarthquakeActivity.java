package com.example.earthquakeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);


        // Create a fake list of earthquake locations.
        final ArrayList<Earthquake> earthquakes = new ArrayList<>();

        createListItem(earthquakes);

        createListView(earthquakes);

    }

    private void createListItem(ArrayList<Earthquake> earthquakes) {
        earthquakes.add(new Earthquake("7.1", "San Francisco", "Jan 23, 2019"));
        earthquakes.add(new Earthquake("4.6", "London", "Mar 02 2018"));
        earthquakes.add(new Earthquake("5.1", "Tokyo", "Dec 09, 2019"));
        earthquakes.add(new Earthquake("5.4", "Mexico City", "Apr 08, 2020"));
        earthquakes.add(new Earthquake("4.12", "Moscow", "Aug 12, 2018"));
        earthquakes.add(new Earthquake("6.2", "Rio de Janeiro", "July 20, 2019"));
        earthquakes.add(new Earthquake("5.5", "Paris", "Feb 16, 2020"));

    }

    private void createListView(final ArrayList<Earthquake> earthquakes) {
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(EarthquakeActivity.this, earthquakes);

        ListView earthquakeListView = findViewById(R.id.list);
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}