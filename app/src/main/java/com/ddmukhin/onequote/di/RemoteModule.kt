package com.ddmukhin.onequote.di

import android.app.Application
import android.content.Context
import android.os.Build
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.paperdb.BuildConfig
import okhttp3.Cache
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttp.VERSION
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    companion object {
        const val CONNECTION_TIMEOUT_SEC = 30L

        const val BASE_URL = ""
    }

    @Provides
    @Singleton
    fun provideHttpCache(@ApplicationContext appContext: Context): Cache {
        val cacheSize = 10L * 1024 * 1024
        return Cache(appContext.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient =
        OkHttpClient.Builder().apply {
            cache(cache)

            val cookieManager = CookieManager()
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
            cookieJar(JavaNetCookieJar(cookieManager))

            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }

            connectTimeout(CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
            readTimeout(CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
            writeTimeout(CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}