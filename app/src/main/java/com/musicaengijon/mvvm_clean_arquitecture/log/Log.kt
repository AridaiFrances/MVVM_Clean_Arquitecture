package com.musicaengijon.mvvm_clean_arquitecture.log

import dagger.Provides

interface Log {
    fun log(message: String)
}