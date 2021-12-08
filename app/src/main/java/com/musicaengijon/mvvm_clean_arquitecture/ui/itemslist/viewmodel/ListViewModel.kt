package com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musicaengijon.mvvm_clean_arquitecture.domain.GetItemsUseCase
import com.musicaengijon.mvvm_clean_arquitecture.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Dagger annotation to set ready the class
@HiltViewModel
class ListViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val items = MutableLiveData<MutableList<Item>>()

    fun fetchItems() {
        viewModelScope.launch {
            loading.postValue(true)
            val resultResponse = getItemsUseCase()
            if (!resultResponse.isNullOrEmpty()) {
                items.postValue(resultResponse.toMutableList())
                loading.postValue(false)
            }
        }
    }
}