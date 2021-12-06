package com.example.mvvm_clean_arquitecture.Common

import android.app.Activity
import androidx.annotation.NonNull
import com.example.mvvm_clean_arquitecture.ui.itemslist.MainActivity

object Navigator {

    fun navigateToSignInActivity(@NonNull activity: Activity) {
        val intentToLaunch = MainActivity.getCallingIntent(activity)
        activity.startActivity(intentToLaunch)
    }
}