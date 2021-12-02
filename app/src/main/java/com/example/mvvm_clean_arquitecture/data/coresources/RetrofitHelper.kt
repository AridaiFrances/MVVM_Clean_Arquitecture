package com.example.mvvm_clean_arquitecture.data.coresources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*Retrofit object that will be called to make a connection to the remote API*/

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.exampleurl.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}