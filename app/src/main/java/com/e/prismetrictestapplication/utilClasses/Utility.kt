package com.e.prismetrictestapplication.utilClasses

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.e.prismetrictestapplication.ListModel.ModelList
import com.e.prismetrictestapplication.MainActivity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class Utility {
    INSTANCE;

    fun locationDetails(activity: Activity) {
        val customLoader = CustomLoader(activity, android.R.style.Theme_Translucent_NoTitleBar)
        customLoader.show()
        val service: ApiInterface =
            RetrofitClient.retrofitInstance!!.create<ApiInterface>(
                ApiInterface::class.java
            )
        val call = service.location_id()
        Log.d("hello", "atul")
        // call!!.enqueue(object : Callback<List<ModelList?>> {
        // call!!.enqueue(object : Callback<List<ModelList>> {
        call?.enqueue(object : Callback<List<ModelList?>?> {
            override fun onResponse(
                call: Call<List<ModelList?>?>,
                response: Response<List<ModelList?>?>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body().toString()
                    Log.d("hello", resp)
                    MainActivity.Companion.Update(
                        activity,
                        Gson().toJson(response.body()).toString()
                    )
                    customLoader.dismiss()
                }
            }

            override fun onFailure(call: Call<List<ModelList?>?>, t: Throwable) {
                Log.d("ram", t.message!!)
                customLoader.dismiss()
                t.printStackTrace()
            }
        }
        )
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}