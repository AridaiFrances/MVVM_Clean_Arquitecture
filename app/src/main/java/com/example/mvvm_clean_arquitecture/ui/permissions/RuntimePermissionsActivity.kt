package com.example.mvvm_clean_arquitecture.ui.permissions

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvm_clean_arquitecture.R
import com.example.mvvm_clean_arquitecture.databinding.ActivityRuntimePermissionsBinding
import com.example.mvvm_clean_arquitecture.ui.itemslist.MainActivity

class RuntimePermissionsActivity : AppCompatActivity() {

    companion object {

        fun getCallingIntent(context: Context): Intent {
            return Intent(context, RuntimePermissionsActivity::class.java)
        }
    }

    private val runtimePermissionsViewModel: RuntimePermissionsViewModel by viewModels()
    private lateinit var binding: ActivityRuntimePermissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRuntimePermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}