package com.musicaengijon.mvvm_clean_arquitecture.patterns.abstractmethod

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.musicaengijon.mvvm_clean_arquitecture.R

/**
 * Defines a common framework for creating objects of the same family. But leave the creation to specific classes.
 **/

class AbstractActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abstract)

        //This is the way to start intents created by abstract methods, calling must be from another activity, this is an example
        AbstractActivity.start(this)
        AbstractActivity.startForResult(this,1)
    }

    companion object: ActivityFactory() {

        override fun getIntent(context: Context): Intent {
            return Intent(context, AbstractActivity::class.java)
        }
    }
}