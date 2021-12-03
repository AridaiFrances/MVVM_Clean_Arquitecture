package com.example.mvvm_clean_arquitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_clean_arquitecture.domain.GetItemsUseCase
import com.example.mvvm_clean_arquitecture.model.Item
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val items = MutableLiveData<List<Item>>()
    var getItemsUseCase = GetItemsUseCase()

    fun fetchItems() {
        viewModelScope.launch {
            loading.postValue(true)
            val resultResponse = getItemsUseCase()
            if (!resultResponse.isNullOrEmpty()) {
                items.postValue(resultResponse)
                loading.postValue(false)
            }
        }
    }
}