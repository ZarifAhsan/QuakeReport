package com.example.earthquakeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);


        // Create a fake list of earthquake locations.
        final ArrayList<List> earthquakes = new ArrayList<>();

        createListItem(earthquakes);

        createListView(earthquakes);

    }

    private void createListItem(ArrayList<List> earthquakes) {
        earthquakes.add(new List("7.1", "San Francisco", "January 23, 2019"));
        earthquakes.add(new List("4.6", "London", "March 02 2018"));
        earthquakes.add(new List("5.1", "Tokyo", "December 09, 2019"));
        earthquakes.add(new List("5.4", "Mexico City", "April 08, 2020"));
        earthquakes.add(new List("4.12", "Moscow", "August 12, 2018"));
        earthquakes.add(new List("6.2", "Rio de Janeiro", "July 20, 2019"));
        earthquakes.add(new List("5.5", "Paris", "February 16, 2020"));
    }

    private void createListView(final ArrayList<List> earthquakes) {
        ListAdapter listAdapter = new ListAdapter(EarthquakeActivity.this, earthquakes);

        ListView earthquakeListView = findViewById(R.id.list);
        earthquakeListView.setAdapter(listAdapter);
    }
}