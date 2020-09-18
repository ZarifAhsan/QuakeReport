package com.example.earthquakeactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=4&limit=16&starttime=2017-01-01";

    private static EarthquakeAdapter mAdapter;

    private static final int EARTHQUAKE_LOADER_ID = 1;

    private TextView mEmptyStateTextView;


    @NonNull
    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, @Nullable Bundle bundle) {
        Log.i(LOG_TAG, "TEST: onCreateLoader() called..");
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        Log.i(LOG_TAG, "TEST: onLoadFinished() called..");

        mEmptyStateTextView.setText(R.string.no_earthquakes);

        mAdapter.clear();

        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Earthquake>> loader) {
        Log.i(LOG_TAG, "TEST: onLoaderReset() called..");
        mAdapter.clear();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST: Earthquake Activity OnCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        createListView();
        checkNetworkConnectivity();

    }

    private void createListView() {
        ListView earthquakeListView = findViewById(R.id.list);
        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        mEmptyStateTextView = findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);

        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake = mAdapter.getItem(position);

                assert currentEarthquake != null;
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                startActivity(websiteIntent);
            }
        });
    }

    private void checkNetworkConnectivity() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            initLoader();
        } else {
            ProgressBar progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);

            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    private void initLoader() {
        LoaderManager loaderManager = getSupportLoaderManager();
        Log.i(LOG_TAG, "TEST: Calling initLoader()..");
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
    }

}