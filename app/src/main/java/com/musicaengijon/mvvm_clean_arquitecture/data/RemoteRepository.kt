package com.musicaengijon.mvvm_clean_arquitecture.data

import com.musicaengijon.mvvm_clean_arquitecture.data.remote.RemoteService
import com.musicaengijon.mvvm_clean_arquitecture.model.Item
import javax.inject.Inject

/*Repository pattern to make abstract dependency
* This will be implemented by domain layer to make correct layer connection*/

class RemoteRepository @Inject constructor(private val api: RemoteService){

    suspend fun getAllItems(): List<Item> {
        return api.getItems()
    }
}