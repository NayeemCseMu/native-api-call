package com.example.weathertestapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.weathertestapp.Model.WeatherDataModel.ConsolidatedWeather;
import com.example.weathertestapp.R;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<ConsolidatedWeather> {
    public MyAdapter(Context context, ArrayList<ConsolidatedWeather> consolidatedWeathers) {
        super(context, 0, consolidatedWeathers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ConsolidatedWeather weather = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView state = (TextView) convertView.findViewById(R.id.stateId);
        TextView temp = (TextView) convertView.findViewById(R.id.tempId);
        TextView lowTemp = (TextView) convertView.findViewById(R.id.lowTempId);
        TextView highTemp = (TextView) convertView.findViewById(R.id.highTempId);
        // Populate the data into the template view using the data object
        state.setText(weather.getWeatherStateName());
        temp.setText( weather.getWeatherStateAbbr());
//        lowTemp.setText((int) weather.get());
//        highTemp.setText((int) weather.getMaxTemp());
        // Return the completed view to render on screen
        return convertView;
    }
}