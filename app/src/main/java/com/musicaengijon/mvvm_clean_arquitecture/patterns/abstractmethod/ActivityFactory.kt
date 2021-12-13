package com.musicaengijon.mvvm_clean_arquitecture.patterns.abstractmethod

import android.app.Activity
import android.content.Context
import android.content.Intent

abstract class ActivityFactory {

    abstract fun getIntent(context: Context): Intent

    fun start(context: Context) {
        val intent = getIntent(context)
        context.startActivity(intent)
    }

    fun startForResult(activity: Activity, requestCode: Int) {
        val intent = getIntent(activity)
        activity.startActivityForResult(intent, requestCode)
    }
}