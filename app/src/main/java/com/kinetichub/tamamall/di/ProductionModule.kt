package com.kinetichub.tamamall.di

import android.content.Context
import android.content.SharedPreferences
import com.kinetichub.tamamall.TaMaMallApplication.Companion.context
import com.kinetichub.tamamall.utilities.DATA_STORE
import com.kinetichub.tamamall.utilities.EN_LANG
import com.kinetichub.tamamall.utilities.LANGUAGE
import com.kinetichub.tamamall.utilities.TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ProductionModule {

    private val sharedPreferences =
        context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)


    @Singleton
    @Provides
    fun getPrefs(): SharedPreferences? {
        return context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)
    }


    @Singleton
    @Provides
    fun getToken() =
        context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)
            .getString(TOKEN, "")

    fun setLanguage(language: String) =
        context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE).edit()
            .putString(LANGUAGE, language).apply()

    @Singleton
    @Provides
    fun getLanguage() =
        context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)
            .getString(LANGUAGE, EN_LANG)


}
