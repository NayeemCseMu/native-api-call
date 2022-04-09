package com.example.weathertestapp.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.weathertestapp.R;

public class Constants {
    public static ProgressDialog getProgressDialog(Context context) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage(context.getString(R.string.please_wait));
        pd.setCancelable(false);
        return pd;
    }
}
