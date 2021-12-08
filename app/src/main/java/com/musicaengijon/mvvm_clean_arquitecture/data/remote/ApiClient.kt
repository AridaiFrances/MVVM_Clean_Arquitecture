package com.musicaengijon.mvvm_clean_arquitecture.data.remote

import com.musicaengijon.mvvm_clean_arquitecture.model.City
import com.musicaengijon.mvvm_clean_arquitecture.model.Item
import retrofit2.Response
import retrofit2.http.GET

/*APIClient contains all the endpoints to complement Retrofit urls network calls*/

interface ApiClient {
    @GET("0A9F")
    suspend fun getAllItems(): Response<List<Item>>

    @GET("WH7G")
    suspend fun getAllCities(): Response<List<City>>
}