package com.musicaengijon.mvvm_clean_arquitecture.patterns.creational.singleton

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object MySingleton: MyInterface {
    var propertyOne: Int = 100
    var proppertyTwo: Int = 200
    lateinit var context: Context

    fun getSum() = propertyOne + proppertyTwo

    fun initialize(context: Context) {
        this.context = context.applicationContext
    }

    init {
        println("MySingleton was created! :)")
    }

    override fun function1() {
        TODO("Not yet implemented")
    }

    override fun function2() {
        TODO("Not yet implemented")
    }
}