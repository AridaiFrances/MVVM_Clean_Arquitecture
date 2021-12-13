package com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.lifecycle.whenResumed
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import com.musicaengijon.mvvm_clean_arquitecture.Common.Navigator
import com.musicaengijon.mvvm_clean_arquitecture.R
import com.musicaengijon.mvvm_clean_arquitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.Random.Default

//Dagger annotation to set ready the class
@DelicateCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {

        fun getCallingIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        setUpListeners()

        val snackbar = Snackbar.make(binding.rootView, "Hi, world", Snackbar.LENGTH_INDEFINITE)

        snackbar.show()

        lifecycleScope.launch {
            whenCreated {
                repeat(2000){
                    val color = Color.argb(255,
                        Random.nextInt(256),
                        Random.nextInt(256),
                        Random.nextInt(256))
                    snackbar.setTextColor(color)
                    delay(500)
            }

            }
        }
    }



    private fun setUpListeners() {
        binding.fbActivityMainToActivityMaps.setOnClickListener {
            Navigator.navigateToRoomActivity(this)
        }
        binding.fbActivityMainToActivityBuilder.setOnClickListener {
            Navigator.navigateToBuilderActivity(this)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}