package com.example.mvvm_clean_arquitecture.domain

import com.example.mvvm_clean_arquitecture.data.RemoteRepository
import javax.inject.Inject

/*Simple usecase that implement RemoteRepository to make the network calling*/


class GetItemsUseCase @Inject constructor(private val repository: RemoteRepository) {

    suspend operator fun invoke() = repository.getAllItems()
}