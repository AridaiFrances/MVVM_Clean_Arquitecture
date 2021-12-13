package com.musicaengijon.mvvm_clean_arquitecture

import android.app.Application
import androidx.room.Room
import com.musicaengijon.mvvm_clean_arquitecture.data.cache.TasksDatabase
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

//Remember to create android:name in manifest to correct work of this class

@HiltAndroidApp
class MvvmCleanArquitecture: Application() {

    companion object {
        lateinit var database: TasksDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        MvvmCleanArquitecture.database =  Room.databaseBuilder(this, TasksDatabase::class.java, "tasks-db").build()
    }
}

