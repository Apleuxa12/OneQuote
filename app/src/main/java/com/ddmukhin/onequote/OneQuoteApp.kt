package com.ddmukhin.onequote

import android.app.Application
import io.paperdb.Paper

class OneQuoteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Paper.init(this)
    }

}