package com.example.mvvm_clean_arquitecture.domain

import com.example.mvvm_clean_arquitecture.data.RemoteRepository

class GetItemsUseCase {

    private val repository = RemoteRepository()

    suspend operator fun invoke() = repository.getAllItems()
}