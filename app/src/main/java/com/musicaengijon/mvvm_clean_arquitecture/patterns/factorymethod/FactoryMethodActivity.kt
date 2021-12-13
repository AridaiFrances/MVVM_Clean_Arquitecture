package com.musicaengijon.mvvm_clean_arquitecture.patterns.factorymethod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.musicaengijon.mvvm_clean_arquitecture.R
import com.musicaengijon.mvvm_clean_arquitecture.patterns.factorymethod.CameraType.FIRSTCAMERA

/**
 * The FactoryMethod pattern will be useful when we want to have a common way of instantiating objects that are related to each other
 * **/


class FactoryMethodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factory_method)

        val camera: GenericCamera = CameraFactory().getCamera(FIRSTCAMERA)

        val customButton = CustomButton(25.0)

        val customButtonPattern = CustomButton.withDiameter(25.0)
        val customButtonPattern1 = CustomButton.withRatio(25.0)



    }
}