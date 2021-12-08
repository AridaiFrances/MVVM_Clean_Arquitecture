package com.musicaengijon.mvvm_clean_arquitecture.ui.maps.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.musicaengijon.mvvm_clean_arquitecture.databinding.ActivityMapsBinding
import com.musicaengijon.mvvm_clean_arquitecture.ui.maps.viewmodel.MapsViewModel

class MapsActivity : AppCompatActivity() {

    companion object {

        fun getCallingIntent(context: Context): Intent {
            return Intent(context, MapsActivity::class.java)
        }
    }

    private val mapsViewModel: MapsViewModel by viewModels()
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}