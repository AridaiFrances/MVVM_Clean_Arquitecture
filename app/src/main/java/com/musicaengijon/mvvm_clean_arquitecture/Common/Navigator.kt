package com.musicaengijon.mvvm_clean_arquitecture.Common

import android.app.Activity
import androidx.annotation.NonNull
import com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.builder.BuilderActivity
import com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist.MainActivity
import com.musicaengijon.mvvm_clean_arquitecture.ui.maps.MapsActivity
import com.musicaengijon.mvvm_clean_arquitecture.ui.room.RoomActivity

object Navigator {

    fun navigateToMainActivity(@NonNull activity: Activity) {
        val intentToLaunch = MainActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }

    fun navigateToMapsActivity(@NonNull activity: Activity) {
        val intentToLaunch = MapsActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }

    fun navigateToBuilderActivity(@NonNull activity: Activity) {
        val intentToLaunch = BuilderActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }

    fun navigateToRoomActivity(@NonNull activity: Activity) {
        val intentToLaunch = RoomActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }
}