package com.musicaengijon.mvvm_clean_arquitecture.patterns.singleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.musicaengijon.mvvm_clean_arquitecture.R

class SingletonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleton)

        MySingleton.initialize(this)
        MySingleton.getSum()
    }
}