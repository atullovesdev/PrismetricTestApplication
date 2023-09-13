package com.e.prismetrictestapplication.utilClasses;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import com.e.prismetrictestapplication.ListModel.ModelList;
import com.e.prismetrictestapplication.MainActivity;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public enum Utility {
    INSTANCE;

    public void locationDetails(Activity activity) {
        final CustomLoader customLoader = new CustomLoader(activity, android.R.style.Theme_Translucent_NoTitleBar);
        customLoader.show();

        ApiInterface service = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<ModelList>> call = service.location_id();
        Log.d("hello","atul");
        call.enqueue(new Callback<List<ModelList>>() {
            @Override
            public void onResponse(Call<List<ModelList>> call, Response<List<ModelList>> response) {
                if (response.isSuccessful()) {
                 String resp= String.valueOf(response.body());
                 Log.d("hello",resp);
                    MainActivity.Update(activity, new Gson().toJson(response.body()).toString());
                    customLoader.dismiss();
                }
            }
            @Override
            public void onFailure(Call<List<ModelList>> call, Throwable t) {
                Log.d("ram", t.getMessage());
                customLoader.dismiss();
                t.printStackTrace();
            }
        });
    }
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
