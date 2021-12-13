package com.musicaengijon.mvvm_clean_arquitecture.log

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

//Only necessary if we want a singleton
@Singleton
class LogConsole @Inject constructor(): Log {

    override fun log(message: String) {
       Timber.i(message)
    }

    init {
        println("A new instance of LogConsole was created")
    }

}