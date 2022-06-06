package com.musicaengijon.mvvm_clean_arquitecture.data.remote

import com.musicaengijon.mvvm_clean_arquitecture.model.City
import com.musicaengijon.mvvm_clean_arquitecture.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*Here is where RetrofitHelper and ApiClient make their work to realize the network calling*/

class RemoteService @Inject constructor(private val api: ApiClient) {

    suspend fun getItems(): List<Item> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllItems()
            response.body() ?: emptyList()
        }
    }

    suspend fun getCities(): List<City> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCities()
            response.body() ?: emptyList()
        }
    }
}