package com.example.earthquakeactivity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    public EarthquakeLoader(@NonNull Context context, String url) {
        super(context);
    }

    @Override
    public void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Earthquake> loadInBackground() {
        return null;
    }
}
