package com.musicaengijon.mvvm_clean_arquitecture

import androidx.fragment.app.Fragment
import com.musicaengijon.mvvm_clean_arquitecture.log.Log
import com.musicaengijon.mvvm_clean_arquitecture.log.LogConsole
import com.musicaengijon.mvvm_clean_arquitecture.log.LogFile
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Only neccessary if we need a singleton pattern
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationGraph {

    fun inject(target: Fragment)
}

/**
        The mission of this class is to say dagger how to switch which dependency inject from an interface
 **/
@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {
    @Binds abstract fun providesLog(log: LogFile) : Log
}