package com.musicaengijon.mvvm_clean_arquitecture.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name") val name: String,
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String
)
