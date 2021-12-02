package com.example.mvvm_clean_arquitecture.data.remote

import com.example.mvvm_clean_arquitecture.model.Item
import retrofit2.Response
import retrofit2.http.GET

/*APIClient contains all the endpoints to complement Retrofit urls network calls*/

interface ApiClient {
    @GET("/example.json")
    suspend fun getAllItems(): Response<List<Item>>
}