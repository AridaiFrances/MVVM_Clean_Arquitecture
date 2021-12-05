package com.example.mvvm_clean_arquitecture.data.coresources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*Retrofit object that will be called to make a connection to the remote API*/

//This class is old, it worked before install dependency inyection with dagger

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonkeeper.com/b/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}