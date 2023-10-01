package com.e.prismetrictestapplication.utilClasses

import com.e.prismetrictestapplication.ListModel.ModelList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    fun location_id(): Call<List<ModelList?>?>?
}