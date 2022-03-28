package com.news.topnews

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Application class for this app
 */
@HiltAndroidApp
class TopNewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Timber configuration to To print log on debug mode
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}