package com.musicaengijon.mvvm_clean_arquitecture.log

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LogFile @Inject constructor(): Log {

    override fun log(message: String) {
        println("Writing log in file")
    }

    init {
        println("A new instance of LogFile was created")
    }
}