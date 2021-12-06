package com.example.mvvm_clean_arquitecture.Common

import android.app.Activity
import androidx.annotation.NonNull
import com.example.mvvm_clean_arquitecture.ui.itemslist.MainActivity
import com.example.mvvm_clean_arquitecture.ui.permissions.RuntimePermissionsActivity

object Navigator {

    fun navigateToMainActivity(@NonNull activity: Activity) {
        val intentToLaunch = MainActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }

    fun navigateToRuntimePermissionsActivity(@NonNull activity: Activity) {
        val intentToLaunch = RuntimePermissionsActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }
}