package com.example.weathertestapp.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.weathertestapp.WeatherModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
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

        void onResponse(ArrayList<WeatherModel> response);
    }

    public void getWeatherForecastByID(String id,WeatherForecastResponse listener){
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

                    ArrayList<WeatherModel> _list = new ArrayList<>();
                    for(int i=0; i<apiResponse.length(); i++){
                        JSONObject data = (JSONObject) apiResponse.get(i);
                        WeatherModel weatherModel = new WeatherModel();
                        weatherModel.setId(data.getInt("id"));
                        weatherModel.setWeather_state_name(data.getString("weather_state_name"));
                        weatherModel.setWeather_state_abbr(data.getString("weather_state_abbr"));
                        weatherModel.setWind_direction_compass(data.getString("wind_direction_compass"));
                        weatherModel.setCreated(data.getString("created"));
                        weatherModel.setApplicable_date(data.getString("applicable_date"));
                        weatherModel.setMin_temp(data.getDouble("min_temp"));
                        weatherModel.setMax_temp(data.getDouble("max_temp"));
                        weatherModel.setThe_temp(data.getDouble("the_temp"));
                        weatherModel.setWind_speed(data.getDouble("wind_speed"));
                        weatherModel.setWind_direction(data.getDouble("wind_direction"));
                        weatherModel.setAir_pressure(data.getDouble("air_pressure"));
                        weatherModel.setHumidity(data.getInt("humidity"));
                        weatherModel.setVisibility(data.getDouble("visibility"));
                        weatherModel.setPredictability(data.getInt("predictability"));
                        _list.add(weatherModel);


                    }
                    listener.onResponse(_list);
                }catch (JSONException e){
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
