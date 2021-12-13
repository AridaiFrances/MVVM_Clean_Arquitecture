package com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.musicaengijon.mvvm_clean_arquitecture.domain.GetItemsUseCase
import com.musicaengijon.mvvm_clean_arquitecture.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Dagger annotation to set ready the class
@HiltViewModel
class ListViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
    get() = _loading

    private val _items: MutableLiveData<MutableList<Item>> = MutableLiveData<MutableList<Item>>()
    val items: LiveData<MutableList<Item>>
    get() = _items

    val user: LiveData<String> = liveData {
        emitSource(DataBase.getUser())
        val data = loadUser()
        DataBase.updateUser(data)
        emit(data)
    }

    private suspend fun loadUser(): String {
        delay(3000)
        return "Remote Username"
    }

    fun fetchItems() {
        viewModelScope.launch {
            _loading.postValue(true)
            val resultResponse = getItemsUseCase()
            if (!resultResponse.isNullOrEmpty()) {
                _items.postValue(resultResponse.toMutableList())
                _loading.postValue(false)
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repeat(1000){
                delay(1000L)
                println("This is a coroutine!")
            }
            withContext(Dispatchers.Main) {
                //Do something in the UI
            }
        }
    }

    object DataBase {
        private val user: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }

        fun getUser(): LiveData<String> {
            user.value = "Cache Username"
            return user
        }

        fun updateUser(name: String) {
            user.value = name
        }
    }
}