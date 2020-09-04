package com.example.earthquakeactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> Earthquake) {
        super(context, 0, Earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_text_view);
        assert currentEarthquake != null;
        magnitudeTextView.setText(currentEarthquake.getMagnitude());

        TextView occurrencePlaceTextView = listItemView.findViewById(R.id.occurrence_place_text_view);
        occurrencePlaceTextView.setText(currentEarthquake.getOccurrencePlace());

        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(currentEarthquake.getTimeOfOccurrence());

        return listItemView;
    }


}