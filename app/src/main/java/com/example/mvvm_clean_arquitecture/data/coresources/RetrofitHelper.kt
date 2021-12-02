package com.example.mvvm_clean_arquitecture.data.coresources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.exampleurl.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}