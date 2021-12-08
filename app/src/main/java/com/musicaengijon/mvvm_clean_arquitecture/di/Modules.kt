package com.musicaengijon.mvvm_clean_arquitecture.di

import com.musicaengijon.mvvm_clean_arquitecture.data.remote.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Dagger annotation to set ready the class
@Module
@InstallIn(SingletonComponent::class)
object Modules {


    @Singleton
    @Provides
    //Retrofit provider
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonkeeper.com/b/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    //ApiClient provider
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }


}