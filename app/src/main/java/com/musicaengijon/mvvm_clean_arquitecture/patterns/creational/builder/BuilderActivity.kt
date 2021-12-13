package com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.builder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.musicaengijon.mvvm_clean_arquitecture.R
import com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.builder.UserType.COPPER
import com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.builder.UserType.GOLD

/**
 * This is an example of creating the Builder pattern.
 * The use of this pattern is recommended for cases in which we have to create objects that are composed of many others
 **/

class BuilderActivity : AppCompatActivity() {

    companion object {

        fun getCallingIntent(context: Context): Intent {
            return Intent(context, BuilderActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Título")
            .setMessage("Message")
            .create()

        /* START COMMON PRACTICE TO CREATE OBJECTS */
        val user = User(1,"name", "secondName", "email", COPPER)

        val secondUser = User(2, "nameOfSecondUser").apply {
            secondName = "secondNameOfSecondUser"
            userTyoe = GOLD
        }

        /* END COMMON PRACTICE TO CREATE OBJECTS */

        /* START BUILDER PATTERN PRACTICE TO CREATE OBJECTS */

        val userForBuilderPattern = UserForBuilderPattern.Builder(3, "name")
            .setEmail("email")
            .setSecondName("secondName")
            .setUserType(GOLD)
            .build()

        /* END BUILDER PATTERN PRACTICE TO CREATE OBJECTS */
    }
}