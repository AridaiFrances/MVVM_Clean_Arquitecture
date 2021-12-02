package com.example.mvvm_clean_arquitecture.data

import com.example.mvvm_clean_arquitecture.data.remote.RemoteService
import com.example.mvvm_clean_arquitecture.model.Item

/*Repository pattern to make abstract dependency
* This will be implemented by domain layer to make correct layer connection*/

class RemoteRepository {
    private val api = RemoteService()

    suspend fun getAllItems(): List<Item> {
        return api.getItems()
    }
}