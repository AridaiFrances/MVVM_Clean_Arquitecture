package com.musicaengijon.mvvm_clean_arquitecture.ui.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musicaengijon.mvvm_clean_arquitecture.domain.GetCitiesUseCase
import com.musicaengijon.mvvm_clean_arquitecture.model.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Dagger annotation to set ready the class
@HiltViewModel
class RoomViewModel @Inject constructor() : ViewModel() {

}