package com.example.earthquakeactivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<List> {

    public ListAdapter(Activity context, ArrayList<List> List) {
        super(context, 0, List);
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

        List currentList = getItem(position);

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_text_view);
        assert currentList != null;
        magnitudeTextView.setText(currentList.getMagnitude());

        TextView occurrencePlaceTextView = listItemView.findViewById(R.id.occurrence_place_text_view);
        occurrencePlaceTextView.setText(currentList.getOccurrencePlace());

        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(currentList.getTimeOfOccurrence());

        return listItemView;
    }


}