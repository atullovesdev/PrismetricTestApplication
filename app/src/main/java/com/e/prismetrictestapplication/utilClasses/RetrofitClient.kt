package com.e.prismetrictestapplication.utilClasses

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val builder: OkHttpClient.Builder = OkHttpClient.Builder()

    companion object {
        private var retrofitClient: RetrofitClient? = null
        private var retrofit: Retrofit? = null

        //private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        val retrofitInstance: Retrofit?
            get() {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClient = OkHttpClient().newBuilder()
                    .connectTimeout(6, TimeUnit.MINUTES)
                    .readTimeout(6, TimeUnit.MINUTES)
                    .writeTimeout(6, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build()
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(ApplicationConstants.Companion.BASEURLLAB)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                }
                return retrofit
            }

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }
}