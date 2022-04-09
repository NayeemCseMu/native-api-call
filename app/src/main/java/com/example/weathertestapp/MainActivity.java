package com.example.weathertestapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weathertestapp.Model.WeatherDataModel.ConsolidatedWeather;
import com.example.weathertestapp.utils.Constants;
import com.example.weathertestapp.utils.MyAdapter;
import com.example.weathertestapp.utils.WeatherDataService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button cityIdBtn, weatherIDBtn, weatherNameBtn;
    EditText editText;
    ListView lv;
    TextView textView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = Constants.getProgressDialog(MainActivity.this);
        cityIdBtn = findViewById(R.id.cityId);
        weatherIDBtn = findViewById(R.id.cityName);
        weatherNameBtn = findViewById(R.id.weatherId);

        editText = findViewById(R.id.edTextInput);
        lv = findViewById(R.id.lvId);
        textView = findViewById(R.id.textView);
        WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this, progressDialog);

//
//        cityIdBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String url = "https://www.metaweather.com/api/location/search/?query=" + editText.getText();
//
//                progressDialog.show();
//
//                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        String cityId = "";
//                        try {
//                            JSONObject cityInfo = response.getJSONObject(0);
//                            cityId = cityInfo.getString("woeid");
//                            progressDialog.dismiss();
//                            // Display the first 500 characters of the response string.
//                            textView.setText("Response is: \n" + response);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        textView.setText(error + "That didn't work!");
//                        progressDialog.dismiss();
//
//                    }
//
//
//        });
//
//            });

        cityIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                weatherDataService.getCityName(editText.getText().toString(), new WeatherDataService.VolleyResponseListener() {

                    @Override
                    public void onError(String message) {
                        textView.setText(message);
                    }

                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                });


            }
        });
        weatherIDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherDataService.getWeatherForecastByID(editText.getText().toString(), new WeatherDataService.WeatherForecastResponse() {
                    @Override
                    public void onError(String message) {
                        textView.setText(message);
                    }

                    @Override
                    public void onResponse(ArrayList<ConsolidatedWeather> response) {
//                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, response);
//                        lv.setAdapter(adapter);
                        MyAdapter adapter = new MyAdapter(MainActivity.this, response);
                        lv.setAdapter(adapter);

                        Toast.makeText(MainActivity.this, " " + response.get(0).getWindDirectionCompass(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        weatherNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You Typed  " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}