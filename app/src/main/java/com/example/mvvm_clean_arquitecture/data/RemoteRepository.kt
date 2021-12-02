package com.example.mvvm_clean_arquitecture.data

import com.example.mvvm_clean_arquitecture.data.remote.RemoteService
import com.example.mvvm_clean_arquitecture.model.Item

class RemoteRepository {
    private val api = RemoteService()

    suspend fun getAllItems(): List<Item> {
        return api.getItems()
    }
}