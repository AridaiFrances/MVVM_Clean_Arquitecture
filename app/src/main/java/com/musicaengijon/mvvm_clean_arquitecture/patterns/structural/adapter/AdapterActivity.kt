package com.musicaengijon.mvvm_clean_arquitecture.patterns.structural.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.musicaengijon.mvvm_clean_arquitecture.R

class AdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)
    }
}