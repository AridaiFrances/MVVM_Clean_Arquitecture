package com.example.mvvm_clean_arquitecture.data.remote

import com.example.mvvm_clean_arquitecture.data.coresources.RetrofitHelper
import com.example.mvvm_clean_arquitecture.model.Item
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
}