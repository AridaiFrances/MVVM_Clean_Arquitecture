package com.example.mvvm_clean_arquitecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_clean_arquitecture.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }
}