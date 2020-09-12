package com.example.earthquakeactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> Earthquake) {
        super(context, 0, Earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);
        assert currentEarthquake != null;


        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_text_view);
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(formattedMagnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);


        String originalLocation = currentEarthquake.getPrimaryLocation();

        String primaryLocation;
        String locationOffset;


        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView = listItemView.findViewById(R.id.primary_location_text_view);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = listItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetView.setText(locationOffset);


        Date dateObject = new Date(currentEarthquake.getTimeInMilliSeconds());

        TextView dateTextView = listItemView.findViewById(R.id.date_text_view);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);



        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}