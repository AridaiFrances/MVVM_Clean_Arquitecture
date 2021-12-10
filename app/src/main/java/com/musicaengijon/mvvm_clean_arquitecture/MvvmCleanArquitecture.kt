package com.musicaengijon.mvvm_clean_arquitecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

//Remember to create android:name in manifest to correct work of this class

@HiltAndroidApp
class MvvmCleanArquitecture: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}