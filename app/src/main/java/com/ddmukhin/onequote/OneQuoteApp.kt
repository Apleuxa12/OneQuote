package com.ddmukhin.onequote

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.paperdb.Paper
import timber.log.Timber

@HiltAndroidApp
class OneQuoteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Paper.init(this)
        Timber.plant(Timber.DebugTree())
    }

}