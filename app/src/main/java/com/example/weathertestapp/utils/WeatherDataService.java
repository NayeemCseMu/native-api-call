package com.example.weathertestapp.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.weathertestapp.Model.WeatherDataModel.ConsolidatedWeather;
import com.example.weathertestapp.Model.WeatherDataModel.WeatherModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {


    public static final String QUERY_BY_CITY_NAME = "https://www.metaweather.com/api/location/search/?query=";
    public static final String QUERY_BY_CITY_ID = "https://www.metaweather.com/api/location/";

    Context context;
    ProgressDialog progressDialog;
    String cityId;

    public WeatherDataService(Context context, ProgressDialog progressDialog) {
        this.context = context;
        this.progressDialog = progressDialog;

    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String response);
    }

    public void getCityName(String searchCityName, final VolleyResponseListener listener) {

        String url = QUERY_BY_CITY_NAME + searchCityName;

        progressDialog.show();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                cityId = "";
                try {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityId = cityInfo.getString("woeid");
                    progressDialog.dismiss();
                    // Display the first 500 characters of the response string.
//                    textView.setText("Response is: \n" + cityId);
                    listener.onResponse(cityId);
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                listener.onError("Something Went Wrong!");

            }

        });

        MySingleton.getInstance(context).addToRequestQueue(request);

//        return  cityId;

    }

    public interface WeatherForecastResponse {
        void onError(String message);

        void onResponse(ArrayList<ConsolidatedWeather> response);
    }

    public void getWeatherForecastByID(String id, WeatherForecastResponse listener) {
        List<WeatherModel> report = new ArrayList<>();


        String url = QUERY_BY_CITY_ID + id;
        progressDialog.show();


        JsonObjectRequest request = new JsonObjectRequest(
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray apiResponse = response.getJSONArray("consolidated_weather");
                    progressDialog.dismiss();

                    ArrayList<ConsolidatedWeather> _list = new ArrayList<>();
                    for (int i = 0; i < apiResponse.length(); i++) {
                        JSONObject data = (JSONObject) apiResponse.get(i);

                        ConsolidatedWeather consolidatedWeather = new ConsolidatedWeather();
                        consolidatedWeather.setID(data.getInt("id"));
                        consolidatedWeather.setWeatherStateName(data.getString("weather_state_name"));
                        consolidatedWeather.setWeatherStateAbbr(data.getString("weather_state_abbr"));
                        consolidatedWeather.setWindDirectionCompass(data.getString("wind_direction_compass"));
//                        consolidatedWeather.setCreated(data.get("created"));
//                        consolidatedWeather.setApplicableDate(data.getAp("applicable_date"));
                        consolidatedWeather.setMinTemp(data.getDouble("min_temp"));
                        consolidatedWeather.setMaxTemp(data.getDouble("max_temp"));
                        consolidatedWeather.setTheTemp(data.getDouble("the_temp"));
                        consolidatedWeather.setWindSpeed(data.getDouble("wind_speed"));
                        consolidatedWeather.setWindDirection(data.getDouble("wind_direction"));
                        consolidatedWeather.setAirPressure(data.getDouble("air_pressure"));
                        consolidatedWeather.setHumidity(data.getInt("humidity"));
                        consolidatedWeather.setVisibility(data.getDouble("visibility"));
                        consolidatedWeather.setPredictability(data.getInt("predictability"));

                        _list.add(consolidatedWeather);


                    }
                    listener.onResponse(_list);
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();

                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError("Something wrong!");
                progressDialog.dismiss();

            }
        }
        );

        MySingleton.getInstance(context).addToRequestQueue(request);

    }
}
