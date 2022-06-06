package com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.factorymethod

import com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.factorymethod.CameraType.FIRSTCAMERA
import com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.factorymethod.CameraType.SECONDCAMERA

class CameraFactory {
    fun getCamera(type: CameraType) =
        when(type) {
            FIRSTCAMERA -> FirstCamera()
            SECONDCAMERA -> SecondCamera()
        }
}

enum class CameraType {
    FIRSTCAMERA,
    SECONDCAMERA
}