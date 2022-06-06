package com.musicaengijon.mvvm_clean_arquitecture.domain

import com.musicaengijon.mvvm_clean_arquitecture.data.RemoteRepository
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val repository: RemoteRepository) {
    suspend operator fun invoke() = repository.getAllCities()
}