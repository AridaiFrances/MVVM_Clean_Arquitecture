package com.musicaengijon.mvvm_clean_arquitecture.Common

import android.app.Activity
import androidx.annotation.NonNull
import com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist.MainActivity
import com.musicaengijon.mvvm_clean_arquitecture.ui.maps.MapsActivity

object Navigator {

    fun navigateToMainActivity(@NonNull activity: Activity) {
        val intentToLaunch = MainActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }

    fun navigateToRuntimePermissionsActivity(@NonNull activity: Activity) {
        val intentToLaunch = MapsActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }
}